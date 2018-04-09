官网：https://www.jetbrains.com/idea/
alt+1-数字-跳转到应该的窗口
无处不在的跳转
项目之间的跳转
不同的窗口之间的跳转ctrl+alt+]/[
文件之间的跳转
ctrl+shift+a 输入recent files可以看到快捷键是ctrl+e 查看最近的文件
上一个修改的文件ctrl+shift+backspace
利用书签跳转
F11打上标签
alt+F11打上标签，选择123数字，查看的时候用ctrl+123来查看以及打上的标签
收藏位置和文件
alt+2跳转到窗口
单独收藏一个类或者函数
alt+shift+f
字符跳转插件emacsIdea置跳转
安装插件shift+ctrl+a打开find action 输入plugins，新开的窗口点击browse repositories，再输入emacsIdeas
激活插件-ctrl+shift+a输入keymaps，找到manage keymaps，清空搜索框找到plug-ins，在找到emacsIdeas，再找到AceJumpWord修改快捷键为alt+J
编辑区和文件区来回跳转alt+1 esc
安装插件ideavim
:vs 在右边开一个窗口
:sp 在下面开一个窗口
ctrl+w准备跳转窗口，然后左边的窗口按住h，左H 右L 上K 下J

精准搜索
ctrl+N搜索class
ctrl+shift+N搜索文件
符号
ctrl+shift+alt+N搜索符号-方法，变量
字符串
ctrl+shift+F搜索字符串

--列操作
alt+insert重构
move caret to next ctrl+ ->移动到单词的结尾
shift+ctrl+ ->选中单词
ctrl+ shift+U切换大小写
移动到行首home
shift+home选中光标到行首
ctrl+home到文件开头
移动到结尾是end
shift+end选中光标到结尾
ctrl+end到文件最后
alt+ctrl+shift+J选中相同的行
alt+insert getset快捷创建 toString重写
ctrl+shift+t 创建单元测试快捷键

--代码小助手
--Live Templates(代码模板)
---
位置：菜单->File->Setting->Editor->Live Templates
功能：定义模板，使用特定“字符”快速敲击出某段代码。
举例：psvm 敲出 public static void main(String[] args)
使用：
1.点击右侧+号。选中Template Group（模板组），自己定一个组。
2.选择自己的组，点击+号，选择Live Template，增添自己的模板。
3.在Abbreviation（缩写）中写自己的缩写，比如pis。
4.在Description中写响应的描述。比如 private String
5.在Template Text中写模板代码。
比如：
private String $VAR1$; //$VAR2$
$END$
其中$VAR1$表示参数。当产生模板后光标会在参数位置上，当写完一个参数后，按下回车会
到另一个参数。最后到$END$处。 
参数顺序可以使用右侧的"Edit variables"调整。
6.在下方选择"Define"，定义使用该模板的地方。
--Postfix Completion(后缀补全)
---
位置：菜单->File->Setting->Editor->General->Postfix Completion
功能：使用后缀，快速敲出代码块。 
举例：100.fori 敲出 for(int i=0;i<100;i++){}
--编写高质量代码
--alter + enter:
---
1.自动创建函数
2.List replace
3.字符串format或者build
4.实现接口
5.单词拼写
6.导包
--重构
---
Shift + F6 Rename
C+F6 方法添加参数 或者 alt + enter
--抽取
---
抽取变量：ctrl + alt + v（refactor选项）
抽取静态变量：ctrl + alt + c（refactor选项）
抽取成员变量：ctrl + alt + f（refactor选项）
抽取方法参数：ctrl + alt + p（refactor选项）
抽取函数：ctrl + alt + m（refactor选项）
--寻找修改轨迹
---
--git集成
移动所有修改轨迹：ctrl + alt + shift + ↑
撤销：ctrl + alt + z
Annotate
位置：代码区域中，显示行号的左侧边栏，右键点击 Annotate
功能：显示所有行的作者名称。当鼠标放在上面可以显示该行的版本详细信息。
--Local History (本地版本控制)
位置：Find Action搜索吧
功能：Idea提供的本地版本控制工具。
使用：Find Action搜索，然后选择Local History，选择Show History，会弹出一个窗口，

里面会记录以前的更改历史。

Put Label （打标记）
位置：搜索出Local History，选择第二个Put Label。
功能：对应上面版本控制工具，可以发布一个Label。也可以认为是打个标记。

--Spring的关联
---
位置：菜单->File->Project Structure->Facets
功能：帮助管理Spring容器。还提供了很多其他的管理，比如EJB
使用：
1.点击+号，选择Spring，选择模块
2.在Spring中，点击+号，起一个名字，选择spring配置文件。（SpringBoot中，选择类文件）
3.项目的各个文件中会出现spring的logo，其提供了很多功能。比如查看该Bean是在哪提供的。
--数据库的关联
---
关联了数据库之后，如果需要重构字段或表名，不仅可以更改当前页面，还可以更改所有引用到该表的sql以及数据库表名或字段
ctrl + F6 重构

--断点调试
---
添加/取消断点	Ctrl + F8
调试			Shift + F10
运行			Shift + F9
单步运行		F8
跳到下一个断点	F9
查看所有断点	Shift + Ctrl + F8
禁止所有断点	debug后在左下角的Mute breakPoints
条件断点		在需要用条件断点的断点处，使用Shift + Ctrl + F8
动态求值		Alt + F8
运行到指定行	Alt + F9
动态改变值		F2
--运行当前上下文
Ctril + Shift + F9 debug configuration
--选择运行
Alt   + Shift + F9 debug

