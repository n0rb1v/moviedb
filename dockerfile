FROM adoptopenjdk:14-jre-hotspot
RUN mkdir /opt/app
COPY target/moviedb-0.0.1-SNAPSHOT.jar /opt/app/moviedb.jar
CMD ["java", "-jar", "/opt/app/moviedb"]