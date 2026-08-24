
# =========================
# Stage 1: Build application
# =========================
FROM maven:3.9-eclipse-temurin-21 AS builder

WORKDIR /build

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests


# =========================
# Stage 2: Run application
# =========================
FROM eclipse-temurin:21-jdk

# Create non-root user
RUN groupadd -r appuser && \
    useradd -r -g appuser -d /app -s /sbin/nologin appuser

WORKDIR /app

# Copy JAR from builder stage
COPY --from=builder /build/target/project-0.0.1-SNAPSHOT.jar app.jar

# Give appuser ownership
RUN chown -R appuser:appuser /app

EXPOSE 8080

# Run as non-root user
USER appuser

ENTRYPOINT ["java", "-jar", "app.jar"]
