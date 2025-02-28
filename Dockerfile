# Step 1: Use the official OpenJDK image as the base image
FROM openjdk:17-slim

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy the Scala app JAR file into the container (adjust path as needed)
COPY target/scala-3.3.1/Main-assembly-0.1.jar /app/Main-assembly-0.1.jar

# Step 5: Run your Scala application
CMD ["java", "-jar", "/app/Main-assembly-0.1.jar"]
