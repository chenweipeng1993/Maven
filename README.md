# Maven
一个官方的仓库：https://oss.sonatype.org
远程仓库central：https://repo1.maven.org/maven2/

3er4#ER$
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

默认访问地址是
http://cwp-vm:8081
用户名密码是admin/admin123
这个版本的nexus有点难受
不建议使用此版本，建议使用2.1.2版本 如下

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


----手动更新索引------
1.手动更新
1.  下载索引文件
在http://repo.maven.apache.org/maven2/.index/ 中下载
nexus-maven-repository-index.gz
nexus-maven-repository-index.properties
然后再下载一个indexer-cli-5.1.0.jar
indexer的下载地址:http://maven.outofmemory.cn/org.apache.maven.indexer/indexer-cli/5.1.0/
indexer的Maven

<dependency>
    <groupId>org.apache.maven.indexer</groupId>
    <artifactId>indexer-cli</artifactId>
    <version>5.1.0</version>
</dependency>
2.   解压缩索引文件
将上面三个文件（.gz & .properties & .jar）放置到同一目录下，运行如下命令
java -jar indexer-cli-5.1.0.jar -u nexus-maven-repository-index.gz -d indexer
3.   停止nexus
4.   删除原有的索引文件
将{nexus_home}\sonatype-work\nexus\indexer\central-ctx下的文件全部删掉
5.   拷贝索引至central-ctx目录下
将nexus-maven-repository-index.gz解压后的indexer目录中所有文件，放到sonatype-work\nexus\indexer\central-ctx下面
6.   启动nexus即自动更新索引

如果以上的设置ok之后还是打开central的browse remote中Central还是空的，需要进行http代理设置，也需要吧central配置的remote storage location由https修改http的 如：http://repo1.maven.org/maven2/
-----有一些是需要配置http代理的-如公司内部网络-例如nexus2.*版本设置
1.在administration目录下点击Server
2.在新打开的页签中找到Default http proxy settings(optional)
3.输入proxy host 和proxy port 可以在ie浏览器打开Internet选项，选择连接，打开局域网设置，这里面有配置地址和端口
4.一般都要验证身份的，够远Authentication（optional） 输入username 和 password ，NT LAN host 填写本地的ip，NT LAN Manager Domain填写域名，这个可以打开我的电脑（计算机）右击选择属性在上面可以看到域
demo:
proxy host : proxy.huawei.com
proxy port : 8080
username  : xxxxxx
password : xxxxxx
NT LAN host : xxx.xxx.xxx.xxx
NT LAN Manager Domain : china.huawei.com



-----maven项目创建---
maven自定义变量及属性
https://www.cnblogs.com/zrbfree/p/6979389.html
设置变量、打包、编码

maven的远端仓库查看jar
https://mvnrepository.com/artifact/org.apache.hadoop/hadoop-core

