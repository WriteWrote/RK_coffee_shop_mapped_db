FROM openjdk:17.0.1-jdk
ARG JAR_FILE
RUN ls -al /
COPY  ${JAR_FILE} /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]