# Maven
1、新建用户
adduser 用户名
。。。提示用户密码。。。等等输入
2、安装jdk
下载路径：http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
上传文件修改文件属组
chown cwpmaven:cwpmaven * -R
3、配置环境变量
ls -al查看隐藏文件
vim .bashrc 或者 vim .profile 
export JAVA_HOME=/home/cwpmaven/jdk1.8.0_161
export JRE_HOME=$JAVA_HOME/jre
export CLASSPATH=$JAVA_HOME/lib:$JRE_HOME/lib:$CLASSPATH
export PATH=$JAVA_HOME/bin:$JRE_HOME/bin:$PATH

4、上传nexus包
下载路径：https://www.sonatype.com/download-oss-sonatype
nexus-3.7.1-02-unix.tar.gz
解压
tar -zxvf nexus-3.7.1-02-unix.tar.gz

5、启动nexus
cd nexus-3.7.1-02/bin/
./nexus run

看到如下标志 表示成功
-------------------------------------------------

Started Sonatype Nexus OSS 3.7.1-02

-------------------------------------------------

--war包的方式
1、安装tomcat，下载解压
tar -zxvf apache-tomcat-8.0.49
2、配置环境变量
vim /etc/profile
export JAVA_HOME=/usr/lib/jvm/java-7-openjdk-amd64
export JRE_HOME=$JAVA_HOME/jre
export HADOOP_HOME=/opt/hadoop-1.2.1
export TOMCAT_HOME=/opt/apache-tomcat-8.0.49
export CLASSPATH=$JAVA_HOME/lib:$JRE_HOME/lib:$CLASSPATH
export PATH=$JAVA_HOME/bin:$JRE_HOME/bin:$HADOOP_HOME/bin:$TOMCAT_HOME/bin:$PATH

source profile
3、上传war到tomcat/webapps下
启动tomcat即可
