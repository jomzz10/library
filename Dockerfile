FROM openjdk:oracle
# copy jar file into container image under app directory
COPY target/library-0.0.1-SNAPSHOT.jar app/library-0.0.1-SNAPSHOT.jar
# expose server port accept connections
EXPOSE 8888
# start application
CMD ["java", "-jar", "app/library-0.0.1-SNAPSHOT.jar"]