FROM openjdk:17
ADD target/test_01.jar /test_01.jar
EXPOSE 9091
ENTRYPOINT [ "java","-jar","/test_01.jar" ]