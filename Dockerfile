FROM openjdk:11
COPY ./build/libs/docker-consumer.jar docker-consumer.jar
EXPOSE 9098
CMD ["java","-jar","docker-consumer.jar"]
