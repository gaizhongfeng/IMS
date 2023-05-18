FROM openjdk:8
MAINTAINER gzf
ADD feng-1.0.8.jar /data/ims.jar
WORKDIR /data
ENTRYPOINT ["java","-jar","/data/ims.jar","--spring.config.location=/data/application-druid.yml"]