FROM openjdk:8-jdk-alpine
EXPOSE 9093
COPY target/*.jar service-registry.jar
ENTRYPOINT ["java","-jar","/service-registry.jar"]
