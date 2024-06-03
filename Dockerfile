FROM openjdk:11-jdk-slim

WORKDIR /app

COPY gradlew .
COPY gradle ./gradle

COPY build.gradle .
COPY settings.gradle .

COPY src ./src

RUN chmod +x ./gradlew
RUN ./gradlew build

COPY /build/libs/app.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
