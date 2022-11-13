
# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template

FROM openjdk:11-jre-slim

COPY target/monitoramento_cli-1.0-SNAPSHOT-jar-with-dependencies.jar /app/app.jar

EXPOSE 8080

WORKDIR /app

ENTRYPOINT ["java", "-jar", "app.jar"]

