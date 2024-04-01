FROM maven:latest

COPY target/assessment-0.0.1-SNAPSHOT.jar /dist/

WORKDIR /dist/

ENTRYPOINT ["java", "-jar", "assessment-0.0.1-SNAPSHOT.jar"]