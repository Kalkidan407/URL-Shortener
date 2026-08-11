FROM eclipse-temurin:21-jdk

# Create non-root user and group, set workdir, copy app and ensure proper ownership
RUN groupadd -r appuser && useradd -r -g appuser -d /app -s /sbin/nologin appuser
WORKDIR /app
COPY target/project-0.0.1-SNAPSHOT.jar app.jar
RUN chown -R appuser:appuser /app

EXPOSE 8080

# Run as non-root user for safety
USER appuser
ENTRYPOINT ["java", "-jar", "app.jar"]

