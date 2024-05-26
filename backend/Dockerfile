# First stage: build the JAR
FROM eclipse-temurin:21-jdk-alpine as builder

# Set the working directory inside the container
WORKDIR /app

# Copy the Gradle wrapper and build scripts
COPY gradlew gradlew
COPY gradle gradle
COPY build.gradle build.gradle
COPY settings.gradle settings.gradle

# Copy the source code
COPY src src

# Make the Gradle wrapper executable and build the application
RUN chmod +x gradlew
RUN ./gradlew clean build -x test

# Second stage: run the application
FROM eclipse-temurin:21-jre-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the builder stage
COPY --from=builder /app/build/libs/*.jar app.jar

# Expose the port on which the application runs
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
