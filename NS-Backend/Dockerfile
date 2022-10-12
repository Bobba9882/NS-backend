FROM openjdk:19
EXPOSE 8080
ADD NS-Backend/target/ns-backend-docker.jar ns-backend-docker.jar
ENTRYPOINT ["java","-jar","/ns-backend-docker.jar"]