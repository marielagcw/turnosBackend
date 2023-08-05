# Dockerfile generar una imagen local
# Establece la imagen base
FROM eclipse-temurin:17-jdk-alpine
# Crea un volumen dentro del contenedor para almacenamiento
VOLUME /tmp
# Copia los archivos del directorio local del proyecto 
COPY target/*.jar app.jar
# Especifica el comando que se ejecutará cuando se inicie el contenedor para ejecutar la app de Java
ENTRYPOINT ["java","-jar","/app.jar"]
