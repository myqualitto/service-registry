FROM openjdk:8
EXPOSE 9093
ADD target/techhmr-serviceregistry.jar techhmr-serviceregistry.jar
ENTRYPOINT ["java","-jar","/techhmr-serviceregistry.jar"]