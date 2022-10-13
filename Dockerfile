FROM openjdk:11-jre-slim
COPY ./build/libs/pick_server_spring-0.0.0.jar ./pick_server_spring.jar
ENTRYPOINT ["java", "-Xmx200m", "-jar", "-Duser.timezone=Asia/Seoul", "/pick_server_spring.jar"]
