FROM maven as build
WORKDIR /build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk
WORKDIR /app
COPY --from=build  ./build/target/*.jar ./guests.jar
ENTRYPOINT java -jar guests.jar