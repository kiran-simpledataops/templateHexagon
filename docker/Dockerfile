FROM amazoncorretto:11
ARG JAR_FILE=./restapp/target/restapp-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} restapp.jar
ENTRYPOINT ["java","-jar","/restapp.jar"]