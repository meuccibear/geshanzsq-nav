## 安装依赖

```bash
npm install
```

## 启动服务

```bash
npm run serve
```

浏览器访问 [http://localhost:8823](http://localhost:8823)

## 发布构建

```bash
npm run build
```

server {
listen       80;
server_name  localhost;

    # 前端项目配置
    location / {
        # root 后面为项目存在目录
        root   /usr/share/nginx/html;
        #root /data/project/geshanzsq-nav/dist;
        index index.html index.htm;
        try_files $uri $uri/ /index.html;
}

# 后端项目配置
location /geshanzsq-nav-api {
# 项目 IP 地址和端口，如果不在一台服务器，请填写对应的 IP；如果后端端口修改后，请填写修改后的端口
proxy_pass http://192.168.0.101:8083//geshanzsq-nav-api;
proxy_set_header Host $host;
proxy_set_header X-Real-IP $remote_addr;
proxy_set_header REMOTE-HOST $remote_addr;
proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
}
}
