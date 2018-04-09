# nginx
从Nginx官网下载nginx-1.8.0.tar.gz
从https://sourceforge.net/projects/pcre/files/pcre/下载pcre-8.38.zip（备用依据环境而定）
从http://www.zlib.net/ 下载zlib
从http://distfiles.macports.org/openssl/下载ssl

Nginx安装过程需要在/usr目录下新建工作目录（也可以用./configure --prefix=/home/csp_mclient/nginx/nginx指定工作目录），需要该目录权限，最好root权限账号

1.	将nginx-1.8.0.tar.gz上传到需要安装的服务器规划目录，例：/home/nginx/nginx-2016
2.	解压nginx-1.8.0.tar.gz，例：tar -zxvf nginx-1.8.0.tar.gz
3.	切换到/home/nginx/nginx-2016/nginx-1.8.0目录下，运行./configure进行初始化配置。如出现下面的提示，说明该机器没有安装PCRE，而Nginx需要依赖PCRE，需要手动安装PCRE
4.	将PCRE安装包上传到nginx服务器上（例：/home/nginx/nginx-2016），使用tar -zxvf pcre-8.38.tar.gz进行解压
5.	运行 chmod -R 777 /home/nginx/nginx-2016/pcre-8.38 对当前文件夹授予全部读写权限
6.	切换到/pcre-8.38目录下，运行 ./configure 进行pcre初始化配置，会在控制台打印出一大堆的输出信息
7.	执行make操作，进行编译
8.	运行make install，进行安装，至此PCRE安装完成
9.	安装完PCRE后，进到nginx安装目录运行./configure如出现如下失败，请安装zlib
10.	下载zlib-1.2.8.tar.gz（见参考资料），解压tar -zxvf zlib-1.2.8.tar.gz，进到解压目录/home/nginx/zlib/zlib-1.2.8，执行命令 ./configure，然后make，然后make install，安装完成
11.	再次进到nginx安装目录运行./configure --with-zlib=/home/nginx/zlib/zlib-1.2.8（这里zlib单独安装，需要指定安装路径，https同理）注意这里生成的配置文件，尤其箭头所指的方向，是启动nginx时的路径。
12.	到nginx安装目录，运行 make install 进行编译。
13.	切换到步骤11生成的nginx运行目录下（/usr/local/nginx/sbin），运行./nginx，启动Nginx
14.	启动Nginx
切换到步骤11生成的nginx运行目录下，运行./nginx，启动Nginx
关闭Nginx
使用 ps -ef|grep nginx 查看nginx的进程，可以看到nginx有两个进程
kill - QUIT nginx 主进程号
pkill -9 nginx

---OpenSSL安装
---
1.	从官网获取openssl包，如：openssl-1.0.1t.tar.gz
2.	将tar包上传到部署规划目录，例：/home/nginx/nginx-2016
3.	解压tar包，例tar  -zxvf openssl-1.0.1t.tar.gz
4.	进到解压目录openssl-1.0.1t
5.	执行./configure，会答应一堆信息
6.	执行make，编译opensll
7.	安装 Openssl，make install
cd openssl-1.1.0c
./config shared zlib
make
make install
9.	查看是否升级成功
openssl version -a

Ngnix https安装
1.	进入nginx解压目录/home/nginx/nginx-1.8.0，运行./configure --with-http_ssl_module --with-openssl=/home/nginx/openssl-1.0.1t --with-http_spdy_module --with-http_stub_status_module --with-pcre=/home/nginx/pcre-8.38进行初始化配置
2.	运行 make install 进行编译。

---nginx使用ssl模块配置HTTPS支持
---
进到nginx工作目录/usr/local/nginx/conf下，执行以下命令，提示输密码、国家省份、地市等，随便输入一些信息即可
openssl genrsa -des3 -out server.key 1024
openssl req -new -key server.key -out server.csr
openssl rsa -in server.key -out server.key
openssl x509 -req -days 8000 -in server.csr -signkey server.key -out server.crt

---配置主要说明：
---
我们先打开一份完整的nginx初始配置：每一行前面有#，表示是注释掉，在文件中不起作用。在配置文件中手动添加蓝色字体注释作为说明，对配置进行解释
#user  nobody;
worker_processes  1;           #nginx是多线程服务，可以配置多个处理进程，通过这个参数配置，业务量较大的情况下建议配置为服务器cpu核数相同的个数
#error_log  logs/error.log;
#error_log  logs/error.log  notice;
#error_log  logs/error.log  info;
#pid        logs/nginx.pid;
events {
    worker_connections  1024;   #单个进程的最大连接数配置，可以配置到65535
}
http {
    include       mime.types;
    default_type  application/octet-stream;
    #log_format  main  '$remote_addr - $remote_user [$time_local] "$request" '
    #                  '$status $body_bytes_sent "$http_referer" '
    #                  '"$http_user_agent" "$http_x_forwarded_for"';
    #access_log  logs/access.log  main;
    sendfile        on;
    #tcp_nopush     on;
    #keepalive_timeout  0;
    keepalive_timeout  65;       #长连接的超时时间，单位秒
    #gzip  on;
    server {                            #server可以配置多个，根据实际需要，每个server代表对外提供的一个服务
        listen       80;                #nginx的这个server对外的服务端口
        server_name  localhost;         #配置服务的ip或者主机名，真实的服务ip及端口
        #charset koi8-r;
        #access_log  logs/host.access.log  main;
        location / {                    #url路径匹配设置，“/” 所匹配的是所有url
            root   html;               #设置静态伺服页面的根路径为nginx目录下的html目录
            index  index.html index.htm;   #主页（http://IP:端口）显示的页面，从前到后优先匹配
        }
        #error_page  404              /404.html;  #404报错自动实现不需要配置单独页面
        # redirect server error pages to the static page /50x.html
        #
        error_page   500 502 503 504  /50x.html;
        location = /50x.html {       #重定向50X错误码的响应页面
            root   html;
        }
    }
            #这里可以添加其他server
}
 
上面是nginx的默认的基本配置，那么我们考虑，使用nginx并不是仅仅为了使用它的静态伺服功能，而要代理tomcat之类的http服务对外开放。其实要改动的地方不多，举例如下：
在server_name的位置配置真实服务所在的ip:端口；在location里面配置代理：proxy_pass，注释root节点。
    server {
        listen       80;
        #server_name  localhost;
        server_name  10.144.222.92:8080;
        location / {
            #root   html;
            #index  index.html index.htm;
            proxy_pass   http://10.144.222.92:8080;
        }
修改后可以重启nginx服务或者使用命令在线加载配置：nginx.exe -s  reload(./nginx –s reload)命令进行重新加载，如果不想立即加载修改的配置，只是想先校验配置文件是否正确，可以使用命令：nginx.exe –t（在/usr/nginx/sbin目录下执行./nginx -t -c /usr/local/nginx/conf/nginx.conf）命令。再次访问时可以发现已经跳转到8080端口所开启的服务了。

Nginx配置HTTP和HTTPS共存
在大多数情况下，我们有可能为了兼容之前APP或者项目发布的版本（之前都走HTTP请求），需要配置HTTP和HTTPS并存的情况，这时我们需要配置Nginx80端口和关闭SSL的强制开启。

server {
    listen       80; #80http请求
    listen       443;   #指定ssl端口
    ssl on;      #开启ssl支持
    ssl_certificate      /etc/nginx/server.pem;    #指定服务器证书路径
    ssl_certificate_key  /etc/nginx/server.key;    #指定私钥证书路径
    ssl_session_cache    shared:SSL:10m; #SSL会话缓存10MB
    ssl_session_timeout  10m; #SSL会话超时间10分钟
    ssl_protocols TLSv1 TLSv1.1 TLSv1.2;     #指定SSL服务器端支持的协议版本
    ssl_ciphers  ALL：!ADH：!EXPORT56：RC4+RSA：+HIGH：+MEDIUM：+LOW：+SSLv2：+EXP;    #指定加密算法
    ssl_prefer_server_ciphers   on;    #在使用SSLv3和TLS协议时指定服务器的加密算法要优先于客户端的加密算法
    #以下内容请按域名需要进行配置，此处仅供参考
    location /test {
        proxy_pass                 http://IP:PORT/test;
        proxy_redirect              off;
        proxy_set_header            Host $host; 
        proxy_set_header            Remote_Addr $remote_addr; 
        proxy_set_header            X-REAL-IP  $remote_addr; 
        proxy_set_header            X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_set_header           X-Forwarded-Proto  $scheme;  
    }
}

------demo-nginx.conf
------
#user  nobody;
worker_processes  2;
#error_log  logs/error.log;
#error_log  logs/error.log  notice;
#error_log  logs/error.log  info;
pid        logs/nginx.pid;
events {
    #use poll;
    worker_connections  65535;
}
http {
    include       mime.types;
    default_type  application/octet-stream;
    server_names_hash_bucket_size 128;
    sendfile        on;
    tcp_nopush     on;
    tcp_nodelay    on;
    keepalive_timeout  60;
    client_body_buffer_size 1024k;
    fastcgi_connect_timeout 300;
    fastcgi_send_timeout 300;
    fastcgi_read_timeout 300;
    fastcgi_buffer_size 256k;
    fastcgi_buffers 8 512k;
    fastcgi_busy_buffers_size 512k;
    fastcgi_temp_file_write_size 512k;
    send_timeout 60;
    gzip  on;
    gzip_min_length 1k;
    gzip_buffers 4  16k;
    gzip_http_version 1.1;
    gzip_comp_level 2;
    gzip_types text/plain application/x-javascript text/css application/xml;
    gzip_vary on;
    proxy_connect_timeout 120;
    proxy_read_timeout 240;
    proxy_send_timeout 240;
    proxy_buffer_size 16k; 
    proxy_buffers 4 16k;
    #proxy_set_header Host $host:7010;
    server {
            listen 7010;
            server_name localhost;
            root   html;
            index  index.html index.htm;            
            location ~^/* {
            proxy_pass http://IP:PORT;
            proxy_set_header Host $host:$server_port;
            proxy_set_header X-Real-IP $remote_addr;
            proxy_set_header X-Real-PORT $remote_port;
            proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
            proxy_redirect  http://localhost:7010 http://IP:PORT; 
        }
    }   
    server {
    server_name localhost; 
    listen 7011; 
    ssl on; 
    ssl_certificate /usr/local/nginx/conf/server.crt; 
    ssl_certificate_key /usr/local/nginx/conf/server.key; 
    ssl_session_timeout  5m;
    ssl_protocols  SSLv2 SSLv3 TLSv1;
    ssl_ciphers  HIGH:!aNULL:!MD5;
    ssl_prefer_server_ciphers   on;
    location ~^/console/* {
            root   html;
            index  index.html index.htm;
            proxy_set_header Host $host:$server_port;
            proxy_set_header X-Real-IP $remote_addr;
            proxy_set_header X-Real-PORT $remote_port;
            proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
            proxy_buffering off;
            proxy_pass https://IP:PORTS;
        }
    }
}
