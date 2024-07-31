FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=build/libs/KubernetesDeploy-0.0.2.jar
ADD ${JAR_FILE} KubePractice.jar
ENTRYPOINT ["java","-jar","/KubePractice.jar"]