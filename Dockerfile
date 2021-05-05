FROM openjdk:8
RUN apt update
RUN apt install maven -y
WORKDIR /java/app
