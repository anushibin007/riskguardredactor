### 1. Build Stage ###
FROM maven:3.9.5-eclipse-temurin-17 as builder
WORKDIR /tmp/staging-area

COPY . .

# 1.1 Install dependencies #
RUN cd ot2-riskguard-client && mvn clean install && cd ..
RUN cd ot2-corecapture-client && mvn clean install && cd ..
RUN cd ot2-contentstorageservice-client && mvn clean install && cd ..

# 1.2 Artefact #
RUN mvn clean test package

### 2. Package Stage ###
FROM eclipse-temurin:17-jre-alpine as runner

RUN apk add curl

COPY --from=builder /tmp/staging-area/target/riskguardredactor-0.0.1-SNAPSHOT.jar riskguard-redactor.jar
HEALTHCHECK --interval=10s --timeout=3s --start-period=10s --retries=10 \
    CMD curl http://localhost:8080/actuator/alive || exit 1

EXPOSE 8080

ENTRYPOINT java -jar riskguard-redactor.jar
