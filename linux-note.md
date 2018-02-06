--Linux-----------
--Ubuntu
sudo passwd root 修改root密码

#ps -e | grep ssh 如果服务已经启动，则可以看到“sshd”，否则表示没有安装服务，或没有开机启动

Ubuntu安装ssh服务，输入命令：#sudo apt-get install openssh-server 

SSH服务器拒绝了密码，xshell连不上虚拟机怎么办
应该是sshd的设置不允许root用户用密码远程登录
修改 vim /etc/ssh/sshd_config
找到# Authentication:
LoginGraceTime 120
PermitRootLogin without passwd
StrictModes yes
改成
# Authentication:
LoginGraceTime 120
PermitRootLogin yes
StrictModes yes
重启虚拟机 or /etc/init.d/ssh restart

按照JDK
javac失败后有提示
apt-get install openjdk-7-jdk 
javac成功

设置JDK环境变量
vim /etc/profile
export JAVA_HOME=/usr/lib/jvm/java-7-openjdk-amd64/
export JRE_HOME=$JAVA_HOME/jre
export CLASSPATH=$JAVA_HOME/lib:$JRE_HOME/lib:$CLASSPATH
export PATH=$JAVA_HOME/bin:$JRE_HOME/bin:$PATH

修改主机名
/etc/hostname与/etc/hosts

下载hadoop
wget 下载路径
--hadoop
下载路径
http://mirrors.shu.edu.cn/apache/hadoop/common/hadoop-1.2.1/hadoop-1.2.1.tar.gz

mv hadoop-1.2.1.tar.gz /opt/
cd /opt/
tar -zxvf hadoop-1.2.1.tar.gz		解压缩
cd hadoop-1.2.1/conf			里面有四个文件需要配置的 hadoop-env.sh core-site.xml hdfs-site.xml mapred-site.xml

1、hadoop-env.sh
export JAVA_HOME=/usr/lib/jvm/java-7-openjdk-amd64/

2、core-site.xml
<!-- core-site.xml -->
<property>
<!-- hadoop的工作目录-->
<name>hadoop.tmp.dir</name>
<value>/hadoop</value>
</property>
<property>
<!-- 所有元数据的目录-->
<name>dfs.name.dir</name>
<value>/hadoop/name</value>
</property>
<property>
<!-- 文件系统的访问路径-->
<name>fs.default.name</name>
<value>hdfs://cwp-vm:9000</value>
</property>

3、hdfs-site.xml
<property>
<!--文件系统数据存放目录-->
<name>dfs.data.dir</name>
<value>/hadoop/data</value>
</property>

4、mapred-site.xml
<configuration>
<property>
<!-- 任务调度器如何访问-->
<name>mapred.job.tracker</name>
<value>cwp-vm:9001</value>
</property>
</configuration>

5、添加hadoop_home的环境变量
/etc/profile
export JAVA_HOME=/usr/lib/jvm/java-7-openjdk-amd64
export JRE_HOME=$JAVA_HOME/jre
export HADOOP_HOME=/opt/hadoop-1.2.1
export CLASSPATH=$JAVA_HOME/lib:$JRE_HOME/lib:$CLASSPATH
export PATH=$JAVA_HOME/bin:$JRE_HOME/bin:$HADOOP_HOME/bin:$PATH

6、source /etc/profile

7、hadoop namenode -format 先格式化namenode节点

8、start-all.sh  启动hadoop -查看有哪些进程在可以使用命令jps

9、hadoop fs -ls /	看文件系统中有哪些目录


--Maven--
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


----Oracle---
启动数据库监听
lsnrctl start LISTENER_ORA
crm_mon -fri
http://czmmiao.iteye.com/blog/1181720

----时钟服务器
ntp服务器配置
https://www.cnblogs.com/jczhu/p/5851268.html


windows下查看端口占用情况
netstat -ano|findstr "9001"

在linux上打上斷點進行遠程debug
tomcat/bin/setvmargs.sh
JAVA_OPTS="$JAVA_OPTS "-Xdebug" "-Xnoagent" "-Djava.compiler=NONE" "-Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=4999






























