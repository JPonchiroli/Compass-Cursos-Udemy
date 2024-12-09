FROM maven:latest as build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:19
WORKDIR /app
COPY --from=build ./app/target/*.jar ./app.jar
EXPOSE 8761
ENTRYPOINT java -jar app.jar