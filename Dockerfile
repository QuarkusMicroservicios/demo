FROM quay.io/quarkus/ubi-quarkus-mandrel-builder-image:22.3-java17 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:17-alpine
EXPOSE 80
COPY --from=build /home/app/target/code-with-quarkus-0.0.1-SNAPSHOT.jar app/app.jar
ENTRYPOINT ["java", "-jar","/app/app.jar"]





