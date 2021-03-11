# Using JDK 11
FROM openjdk:11

ARG JAR_FILE=target/reactive-bank-0.0.1.jar

# Copy .jar
ADD ${JAR_FILE} reactive-bank.jar

# Expose project PORT
EXPOSE 8081

# Execute project
ENTRYPOINT ["java","-jar","/reactive-bank.jar"]