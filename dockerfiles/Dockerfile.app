# ===== Stage 1: Build =====
FROM maven:3.9-eclipse-temurin-26 AS build

ARG PROXY_HOST=proxy.fpts.com.vn
ARG PROXY_PORT=8080

ENV MAVEN_OPTS="${MAVEN_OPTS} -Dmaven.wagon.http.retryHandler.count=3 -Dmaven.wagon.httpconnectionManager.ttlSeconds=120"

WORKDIR /workspace

COPY pom.xml .
COPY app/pom.xml app/pom.xml
COPY commondb/pom.xml commondb/pom.xml
COPY consumer/pom.xml consumer/pom.xml

RUN mvn dependency:go-offline -B -Dmaven.wagon.http.retryHandler.count=5

COPY app/src app/src
COPY commondb/src commondb/src

RUN mvn clean package -DskipTests -pl app -am

# ===== Stage 2: Runtime =====
FROM eclipse-temurin:26-jre-alpine

WORKDIR /app

RUN addgroup -S appgroup && adduser -S appuser -G appgroup

COPY --from=build /workspace/app/target/*.jar app.jar

RUN mkdir -p /app/logs && chown -R appuser:appgroup /app

USER appuser

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]