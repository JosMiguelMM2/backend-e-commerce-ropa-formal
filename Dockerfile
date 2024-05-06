FROM amazoncorretto:21-alpine-jdk

# copiar el archivi .JAR de la aplicacion
COPY build/libs/e-commerce-ropa-formal-0.0.1.jar e-commerce-ropa-formal-0.0.1.jar

# Comando para ejecutar la aplicacion
CMD ["java", "-jar", "-Dspring.profiles.active=prod", "e-commerce-ropa-formal-0.0.1.jar"]

EXPOSE 8080
