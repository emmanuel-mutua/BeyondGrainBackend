FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=BeyondGrain-0.0.1-SNAPSHOT.jar
COPY target/${JAR_FILE} beyondGrain.jar
ENTRYPOINT [ "java", "-jar","beyondGrain.jar" ]