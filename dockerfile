FROM openjdk:17
COPY . .
WORKDIR /src
RUN javac Main.java
RUN java Main
