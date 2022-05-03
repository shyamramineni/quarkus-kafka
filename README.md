# quarkus-kafka

This is project quarkus kafka project is connecting to confluent cloud.

## Running the application in dev mode

cd to kafka-quickstatrt-processor directory and run the application
```
./mvn clean quarkus:dev
```
cd to kafka-quickstatrt-producer directory and run the application
```
./mvn clean quarkus:dev
```
http://localhost:8080/quotes.html

## Application.properties is critical

Make sure you the correct format and credentials in application.properties file. Don't use the credentials in this commit. I have already deleted that key.
Remeber to recreate the key and enter new details.



