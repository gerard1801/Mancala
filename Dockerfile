FROM gradle:6.9.1-jdk11-openj9
VOLUME /tmp
COPY api/build/libs/*.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
