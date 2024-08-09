FROM maven:3.9.8-amazoncorretto-17 AS build
WORKDIR /build
COPY src ./src
COPY pom.xml ./
RUN mvn clean package

FROM openjdk:17
WORKDIR /app
COPY --from=build /build/target/ToDO*jar ./ToDO.jar
EXPOSE 8089
CMD ["java", "-jar", "ToDO.jar"]
