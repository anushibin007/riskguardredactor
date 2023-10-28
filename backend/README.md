# Spring Boot Backend

## Description

The Spring Boot Backend has all the logic related to making calls to the OT2 Cloud APIs as well as the Python Redaction backend. The frontend will make calls to the Spring Boot Backend only.

## Public endpoint

https://riskguardredactor-backend-springboot-adxywvifka-el.a.run.app

## Developer Environment setup

1. Install the Java Development Kit (JDK) 17.
2. Install the Apache Maven CLI.
3. Run [generateandinstallclient.cmd](./generateandinstallclient.cmd).
4. Edit [application.properties](./src/main/resources/application.properties) and update it with values specific to your environment.
5. Import the project linked with the [main pom.xml file](./pom.xml) to your IDE to setup the development environment.

## Run locally

If you want to simply run the project locally, perform the following steps:

1. Follow steps 1-4 from the previous section
2. Open a terminal and run `mvn spring-boot:run`
3. You should be able to access the backend at the base endpoint `http://localhost:8080`
