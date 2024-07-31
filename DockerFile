FROM  maven:3.9.5-openjdk-21 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:21
COPY --from=build /target/02.Spring-Boot-Web-Application-V2-0.0.1-SNAPSHOT.jar 02.Spring-Boot-Web-Application-V2.jar
EXPOSE 5000
ENTRYPOINT ["java","-jar","02.Spring-Boot-Web-Application-V2.jar"]