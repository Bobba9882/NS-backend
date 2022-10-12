FROM openjdk:19
EXPOSE 9090
ADD User-Backend/target/user-backend-docker.jar user-backend-docker.jar
ENTRYPOINT ["java","-jar","/user-backend-docker.jar"]