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

RUN  apt-get update && \
     apt-get -y install apt-transport-https curl gnupg -yqq && \
     echo "deb https://repo.scala-sbt.org/scalasbt/debian all main" | tee /etc/apt/sources.list.d/sbt.list && \
     echo "deb https://repo.scala-sbt.org/scalasbt/debian /" | tee /etc/apt/sources.list.d/sbt_old.list && \
     curl -sL "https://keyserver.ubuntu.com/pks/lookup?op=get&search=0x2EE0EA64E40A89B84B2DF73499E82A75642AC823" | gpg --no-default-keyring --keyring gnupg-ring:/etc/apt/trusted.gpg.d/scalasbt-release.gpg --import && \
     chmod 644 /etc/apt/trusted.gpg.d/scalasbt-release.gpg && \
     apt-get update && \
     apt-get install -y sbt
