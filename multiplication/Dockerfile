FROM openjdk:17
COPY ./build/libs/multiplication-0.0.1-SNAPSHOT.jar $HOME/src/multiplication/
WORKDIR $HOME/src/multiplication
EXPOSE 8080
CMD ["java", "-jar", "multiplication-0.0.1-SNAPSHOT.jar"]