FROM zhuozhuang/java:1.8-glibc

RUN mkdir -p /opt/app
ENV PROJECT_HOME /opt/app
COPY ../../target/geshanzsq-nav-admin-application.jar $PROJECT_HOME/app.jar

WORKDIR $PROJECT_HOME
EXPOSE 8083
CMD ["java" ,"-jar","./app.jar"]

# docker build -t zhuozhuang/geshanzsq-nav:0.1 .
