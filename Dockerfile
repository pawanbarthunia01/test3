FROM openjdk:17
ADD target/test_01.jar /test_01.jar
ENV PORT 8081
EXPOSE $PORT
ENTRYPOINT ["java","-jar","-Xmx1024M","-Dserver.port=${PORT}","test_01.jar"]

