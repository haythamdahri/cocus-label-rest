FROM adoptopenjdk/openjdk11
# Set Working Directory
WORKDIR /app
# Set Jar File Then Copy It
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
# Set Container Entrypoint
ENTRYPOINT ["java","-jar", "-Dspring.profiles.active=prod", "app.jar"]
# Expose 8080 as default port
EXPOSE 8080