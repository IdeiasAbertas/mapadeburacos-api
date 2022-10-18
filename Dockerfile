FROM openjdk:11
#RUN addgroup -S mapadeburacos && adduser -S mapadeburacos -G mapadeburacos

#USER mapadeburacos:mapadeburacos

COPY . /mapadeburacos
WORKDIR /mapadeburacos
RUN ./mvnw clean package

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]