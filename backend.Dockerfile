FROM adoptopenjdk/openjdk16
VOLUME /tmp
COPY api/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]