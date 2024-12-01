# Use an OpenJDK base image
FROM openjdk:17-jdk-slim

# Add a volume pointing to /tmp (optional for caching)
VOLUME /tmp

# Copy the WAR file into the container
COPY target/restaurant-0.0.1-SNAPSHOT.war app.war

# Expose the application port (default Spring Boot port is 8080)
EXPOSE 8085

# Run the WAR file
ENTRYPOINT ["java", "-jar", "/app.war"]
