
FROM openjdk:17
COPY target/code-executor.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
