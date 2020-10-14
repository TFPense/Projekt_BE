FROM openjdk:15-alpine
WORKDIR /
ADD build/libs/Projekt_BE.jar Projekt_BE.jar
CMD ["java", "-jar", "Projekt_BE.jar", "--port=$PORT"]