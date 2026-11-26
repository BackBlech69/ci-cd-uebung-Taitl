# ---------- Build stage: compile and package with Maven ----------
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /build
 
# Copy pom.xml first so dependency downloads are cached
COPY pom.xml .
RUN mvn --batch-mode -q dependency:go-offline
 
COPY src ./src
# Tests already run in the CI job before this one -> skip them here
RUN mvn --batch-mode -q package -DskipTests && ls -la target
 
# ---------- Runtime stage: only the JRE and the JAR ----------
FROM eclipse-temurin:17-jre
WORKDIR /app
 
# Do not run as root
RUN useradd --system --uid 1001 appuser
 
COPY --from=build /build/target/ci-cd-uebung-1.0.0.jar /app/app.jar
 
USER appuser
ENTRYPOINT ["java", "-cp", "/app/app.jar", "com.example.cicd.App"]
 