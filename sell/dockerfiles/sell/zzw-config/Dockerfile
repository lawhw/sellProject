FROM hub.c.163.com/library/java:8-alpine

VOLUME /tmp

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

ADD zzw-config.jar app.jar


ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]