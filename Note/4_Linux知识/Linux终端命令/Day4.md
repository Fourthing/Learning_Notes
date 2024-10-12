## Linux学习

*复习笔记*

**Day4  **查找定位文件命令（二）

1. **locate**命令用于*按照名称*   快速搜索 *文件所对应的位置*，语法格式为“**locate文件名称**”。

   <details> <summary>与find命令区别</summary>与find命令的区别是find命令全盘搜索（/）更准确、功能更全,但locate命令的效率更高、更加便捷。两者都能找出全部的同名文件。sudo find / -name "whereis" ≈ locate whereis 因为后者不能找到.1.gz的命令文件

   <details> <summary>原理</summary>先使用updatedb命令生成一个索引库文件，这个库文件的名字是/var/lib/mlocate/mlocate.db，后续在使用locate命令搜索文件时就是在该库中进行查找操作，速度会快很多。故第一次使用locate命令之前，应先执行updatedb命令来生成索引数据库，然后再进行查找。实际上还要安装一个mlocate库：sudo apt install mlocate --> sudo updatedb



2. **whereis**命令用于*按照名称*  快速搜索 *二进制程序（命令）、源代码以及帮助文件所对应的位置*，语法格式为“whereis命令名称”。

   <details> <summary>与locate命令区别</summary>简单来说，whereis命令也是基于updatedb命令所生成的索引库文件进行搜索，它与locate命令的区别是不关心那些相同名称的文件，仅仅是快速找到对应的命令文件及其帮助文件所在的位置。

​	注意找到的命令文件以.1.gz结尾

3. **which**命令用于*按照名称*  快速搜索 *二进制程序（命令）所对应的位置* ，，语法格式为“which命令名称”。

   <details> <summary>原理</summary>which命令是在PATH变量所指定的路径中，按照指定条件搜索命令所在的路径。也就是说，如果我们既不关心同名文件（find与locate），也不关心命令所对应的源代码和帮助文件（whereis），仅仅是想找到命令本身所在的路径，那么这个which命令就太合适了。

