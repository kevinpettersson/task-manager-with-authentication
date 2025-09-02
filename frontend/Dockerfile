# Use an official Node.js runtime as a parent image
FROM node:20

# Set the working directory
WORKDIR /app

# Copy package.json and package-lock.json to /app
COPY package.json ./
COPY package-lock.json ./

# Install dependencies
RUN npm install

# Copy all source files
COPY . .

# Set the enviroemnt variable to 3000
ENV PORT=3000

# Tell the container to listen on port 3000
EXPOSE 3000

# Command to start the frontend client
CMD [ "npm", "start" ]

