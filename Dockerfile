FROM openjdk:17
EXPOSE 8080
ADD target/Devops.jar Devopsjar
ENTRYPOINT ["java","-jar","/Devops.jar"]
