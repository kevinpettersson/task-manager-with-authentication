package com.kevinpe.task_service.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JWTService {

    private String secretKey = "";

    public JWTService(@Value("${JWT_SECRET}") String secretKey) {
        this.secretKey = secretKey;
    }

    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();

        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 60 * 60 * 100))
                .and()
                .signWith(getKey())
                .compact();
    }

    public String extractUsername(String token){
        Claims claims = Jwts.parser()
                            .verifyWith(getKey())
                            .build()
                            .parseSignedClaims(token)
                            .getPayload();

        return claims.getSubject();

    }

    public boolean validateToken(String token, String username) {
        String extractedUsername = extractUsername(token);
        return extractedUsername.equals(username);
    }

    private SecretKey getKey(){
        byte[] keyBytes = Decoders.BASE64.decode(this.secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
