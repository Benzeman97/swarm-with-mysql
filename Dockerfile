FROM openjdk:11
COPY ./target/docker-producer.jar docker-producer.jar
EXPOSE 9090
CMD ["java","-jar","docker-producer.jar"]