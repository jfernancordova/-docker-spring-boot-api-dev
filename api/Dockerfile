FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml  package

FROM adoptopenjdk/openjdk11:jre-11.0.11_9-alpine
COPY --from=build /home/app/target/api-0.0.1-SNAPSHOT.jar /usr/local/lib/api.jar

WORKDIR /app
RUN apk --no-cache add ca-certificates wget procps curl
RUN apk --no-cache add openssl

# Entrypoint
ADD ./etc/set_features.sh /root/set_features.sh
ADD ./etc/start.sh /root/start.sh
COPY --from=build /home/app/target/api-0.0.1-SNAPSHOT.jar /app/api.jar
RUN chmod +x /root/set_features.sh
RUN chmod +x /root/start.sh

ENTRYPOINT ["/root/start.sh"]

HEALTHCHECK --interval=25s --timeout=3s --retries=2 CMD wget --spider http://localhost:8080/actuator/health || exit 1

EXPOSE 8080