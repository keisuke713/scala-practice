FROM ubuntu:24.04

RUN apt-get update \
    && apt-get install -y --no-install-recommends \
        openjdk-21-jdk \
        git \
        openssh-client \
    && rm -rf /var/lib/apt/lists/*

ENV JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64

RUN apt-get update && \
    apt-get install -y wget && \
    rm -rf /var/lib/apt/lists/*

RUN wget https://downloads.lightbend.com/scala/2.13.16/scala-2.13.16.tgz && \
    tar -xzf scala-2.13.16.tgz && \
    rm scala-2.13.16.tgz

ENV PATH="/scala-2.13.16/bin:${PATH}"
