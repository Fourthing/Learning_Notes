



## Linux学习

*复习笔记*

**Day6  **文本文件编辑命令（续）

1. **stat**命令用于查看文件的具体存储细节和时间等信息，英文全称为“status”，语法格式为`stat 文件名称`。

   > Linux中文件的三种时间：分别是Access Time（内容最后一次被访问的时间，简称为Atime），Modify Time（内容最后一次被更改的时间，简称为Mtime）以及Change Time（文件属性最后一次被改动的时间，简称为Ctime）。

   

2. **grep**命令用于按行匹配文本内容，非常实用！！两个最常用的参数`-n`和`-v` 

   -n参数用来显示搜索到的信息的行号；

   -v参数用于反选信息（即没有包含关键词的所有信息行）

   表1-6                                          grep命令中的参数及其作用

   | 参数 | 作用                                           |
   | ---- | ---------------------------------------------- |
   | -b   | 将可执行文件(binary)当作文本文件（text）来搜索 |
   | -c   | 仅显示找到的行数                               |
   | -i   | 忽略大小写                                     |
   | -n   | 显示行号                                       |
   | -v   | 反向选择——仅列出没有“关键词”的行。             |

* 高级玩法：配合管道符使用，比如先用**ls**命令获取文件列表，再运用管道符把结果传递给**grep**命令

3. **cut**命令用于按列提取文本内容，语法格式为`cut [参数] 文件名称`。若当前不在目标文件的目录之下，则文件名称要带上路径。`-d` 参数用于设置间隔符号，`-f`参数设置要查看的列数

   接下来使用下述命令尝试提取出passwd文件中的用户名信息，即提取以冒号（：）为间隔符号的第一列内容：

   ```bash
   [root@linuxprobe ~]# cut -d : -f 1 /etc/passwd
   root
   bin
   daemon
   adm
   lp
   sync
   shutdown
   halt
   mail
   operator
   games
   ftp
   nobody
   dbus
   ………………省略部分输出信息………………
   ```
   * **带管道符一起玩：**`cut -d : -f 1 /etc/passwd | grep -n niko `这句命令把cut按列提取之后的结果交给`grep`命令按照名字提取

     

4. **diff**命令用于比较多个文件内容之间的差异，语法格式为`diff [参数] 文件名称A 文件名称B`。

   参数`--brief` 确认两个文件是否相同；参数`-c` 详细比较多个文件的差异之处。

   

5. **uniq**命令用于去除文本中连续的**重复行**，注意！非连续的重复不会去除。

   使用：`uniq a.txt` 

   

6. **sort**命令用于对文本内容进行排序，语法格式为`sort [参数] 文件名称`。默认是按首字母排序。

   表1-7                                              sort命令中的参数及其作用

   | 参数 | 作用                                           |
   | ---- | ---------------------------------------------- |
   | -f   | 忽略大小写                                     |
   | -b   | 忽略缩进与空格                                 |
   | -n   | 以数值型排序                                   |
   | -r   | 反向排序                                       |
   | -u   | 去除重复行（与uniq命令不同，不需相邻也能去除） |
   | -t   | 指定间隔符                                     |
   | -k   | 设置字段范围                                   |

    参考cut命令，sort的功能其实也能实现（可见sort命令真的能做到好多事情），用`-k`指定第几列，用`-t指定间隔符`，再用参数`-n`就能把一串文字按列排序

