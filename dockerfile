FROM openjdk:8-jdk-alpine
COPY "./target/Talataa_Daniel_Pineros.jar" "Talataa.jar"
EXPOSE 8080
CMD ["java", "-jar", "api-test.jar"]
