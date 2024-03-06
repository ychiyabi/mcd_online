# Use a base image with Java installed
FROM openjdk:17-alpine

# Install Maven
RUN apk add --no-cache maven

# Set the working directory inside the container
WORKDIR /app

# Copy the entire source code of your Spring Boot application into the container
COPY . /app/

# Copy the Maven Wrapper script into the container and set executable permissions
COPY mvnw /app/
RUN chmod +x mvnw

# Build the Spring Boot application inside the container
RUN ./mvnw package

# Expose the port your Spring Boot application runs on
EXPOSE 8080

# Command to run your application when the container starts
CMD ["mvn", "spring-boot:run"]