FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=build/libs/KubernetesDeploy-0.0.1.jar
ADD ${JAR_FILE} KubePractice.jar
ENTRYPOINT ["java","-jar","/app.jar"]