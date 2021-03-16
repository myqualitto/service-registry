FROM openjdk:8
EXPOSE 9093
COPY target/*.jar service-registry.jar
ENTRYPOINT ["java","-jar","/service-registry.jar"]
