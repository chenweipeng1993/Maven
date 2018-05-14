下载地址
https://dev.mysql.com/downloads/file/?id=476233
安装
1，解压ZIP文件到指定目录下：如D:\mysql-8.0.11-winx64
2，新建my.ini配置文件并粘贴修改如下内容：（1）baseidr路径  （2）datadir路径
[mysql]
# 设置mysql客户端默认字符集
default-character-set=utf8 
[mysqld]
#设置3306端口
port = 3306 
# 设置mysql的安装目录


basedir=D:\\mysql-8.0.11-winx64
# 设置mysql数据库的数据的存放目录
datadir=D:\\mysql-8.0.11-winx64\\data


# 允许最大连接数
max_connections=200
# 服务端使用的字符集默认为UTF8
character-set-server=utf8
# 创建新表时将使用的默认存储引擎
default-storage-engine=INNODB

这里需要以管理员身份运行！

执行mysqld --initialize --user=mysql --console 命令后并且记住 localhost的默认密码
mysqld --initialize --user=mysql --console
lqFHZ,.Fx0fE

cmd命令以管理员身份进入到控制台指定的mysql bin目录下 运行mysqld install命令。注意：这里需要以管理员身份运行！
安装成功后启动mysql服务：net start mysql
执行mysqld -remove命令将以前的错误安装删除，否则会提示已经安装

用默认密码登录mysql 然后执行如下命令进行修改密码： ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'root'

mysql8 之前的版本中加密规则是mysql_native_password,而在mysql8之后,加密规则是caching_sha2_password, 
解决问题方法有两种：
方法1.升级navicat驱动；
方法2.把mysql用户登录密码加密规则还原成mysql_native_password. 
这里采用方法2解决，具体操作步骤如下：
1.打开命令行小黑屏，进入MySQL的bin目录，然后输入mysql -u root -p，输入密码
2.然后输入
ALTER USER 'root'@'localhost' IDENTIFIED BY 'password' PASSWORD EXPIRE NEVER; #修改加密规则 （这行我没有写，不过貌似也可以）
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'password'; #更新一下用户的密码 
FLUSH PRIVILEGES; #刷新权限

修改密码
方法1： 用SET PASSWORD命令 
首先登录MySQL。 
格式：mysql> set password for 用户名@localhost = password(‘新密码’); 
例子：mysql> set password for root@localhost = password(‘123’);

方法2：用mysqladmin 
格式：mysqladmin -u用户名 -p旧密码 password 新密码 
例子：mysqladmin -uroot -p123456 password 123

方法3：用UPDATE直接编辑user表 
首先登录MySQL。 
mysql> use mysql; 
mysql> update user set password=password(‘123’) where user=’root’ and host=’localhost’; 
mysql> flush privileges;

方法4：在忘记root密码的时候，可以这样 
以windows为例： 
1. 关闭正在运行的MySQL服务。 
2. 打开DOS窗口，转到mysql\bin目录。 
3. 输入mysqld –skip-grant-tables 回车。–skip-grant-tables 的意思是启动MySQL服务的时候跳过权限表认证。 
4. 再开一个DOS窗口（因为刚才那个DOS窗口已经不能动了），转到mysql\bin目录。 
5. 输入mysql回车，如果成功，将出现MySQL提示符 >。 
6. 连接权限数据库： use mysql; 。 
6. 改密码：update user set password=password(“123”) where user=”root”;（别忘了最后加分号） 。 
7. 刷新权限（必须步骤）：flush privileges;　。 
8. 退出 quit。 
9. 注销系统，再进入，使用用户名root和刚才设置的新密码123登录。
