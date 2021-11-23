FROM adoptopenjdk/maven-openjdk11:latest as builder 

WORKDIR /usr/src/app
COPY . /usr/src/app 

FROM adoptopenjdk/maven-openjdk11:latest 

LABEL maintainer="de.eclipse"
WORKDIR /usr/src/app
COPY --from=builder /usr/src/app/target/BookApp-0.0.1-SNAPSHOT.jar /usr/src/app/book.jar

EXPOSE 8080

VOLUME /tmp

CMD  ["java", "-jar", "book.jar"]

