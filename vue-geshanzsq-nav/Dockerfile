FROM --platform=linux/amd64 nginx
#FROM nginx

RUN rm /etc/nginx/conf.d/default.conf

RUN apt update && apt install -y vim

ADD nginx.conf /etc/nginx/conf.d/default.conf
COPY dist/ /usr/share/nginx/html/

# docker build -t zhuozhuang/geshanzsq-nav-vue:0.1 .
