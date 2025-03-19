# Use Maven image to build the project
FROM maven:3.9.6-eclipse-temurin-21 AS build

# Set working directory
WORKDIR /app

# Copy only the pom.xml and dependencies first (for better caching)
COPY pom.xml ./
RUN mvn dependency:go-offline -B

# Copy the entire project
COPY . .

# Ensure Maven Wrapper (mvnw) has correct permissions
RUN chmod +x mvnw

# Build the Spring Boot application
RUN ./mvnw clean package -DskipTests

# Use a lightweight JDK image for running the app
FROM openjdk:21-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "app.jar"]
