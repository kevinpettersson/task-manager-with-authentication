##### Multistage docker file #####

#### Stage 1: Build ####

# Parent image
FROM maven:3.9.6-eclipse-temurin-17 AS builder

# Set the working directory
WORKDIR /app

# Copy parent POM
COPY pom.xml ./                 

# Copy all modules
COPY backend backend

# Download dependencies for all modules, used cached dependencies if pom is unchanged (offline).
# Use batch mode '-B' to skip interactive prompts during docker build phase.
RUN mvn dependency:go-offline -B

# Build all modules (skip tests)
RUN mvn clean package -DskipTests -f backend/task-service/pom.xml


#### Stage 2: Run task-service ####
FROM eclipse-temurin:17-jdk

# Set the working directory
WORKDIR /app

# Copy the packaged JAR file from the build stage
COPY --from=builder /app/backend/task-service/target/*.jar app.jar

# Expose the application port
EXPOSE 8082

# Run the application
CMD ["java", "-jar", "app.jar"]
