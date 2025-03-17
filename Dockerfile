# Usa una imagen base con OpenJDK
FROM openjdk:17-jdk-alpine

# Copia el archivo .jar de tu aplicación al contenedor
COPY target/tu-aplicacion.jar app.jar

# Expone el puerto que utilizará tu aplicación
EXPOSE 8080

# Comando para ejecutar tu aplicación
ENTRYPOINT ["java", "-jar", "/app.jar"]
