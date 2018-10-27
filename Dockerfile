# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file
ARG JAR_FILE=build/libs/devops-demo-0.1.0.jar

# Add the application's jar to the container
ADD ${JAR_FILE} devops-demo.jar

# Run the jar file 
ENTRYPOINT ["java","-jar","/devops-demo.jar"]

