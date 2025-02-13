## Linux学习

*复习笔记*

**Day11  ** 编写Shell脚本

1. **基本知识**

   之前的学习已经知道Bash解释器是一款优秀的Shell终端解释器，是人与计算机硬件之间的“翻译官”，简而言之就是**用户和Linux系统内部的通信媒介**。

   除了能够支持各种变量与参数外，还提供了诸如循环、分支等高级编程语言才有的控制结构特性。要想正确使用Shell中的这些功能特性，准确下达命令尤为重要，会用到会用到前面学习过的很多**Linux命令以及正则表达式、管道符、数据流重定向**等语法规则，还需要把**内部功能模块化**后通过**逻辑语句**进行处理。Shell解释器的工作方式有下面两种。

   * **交互式（Interactive）**：用户每输入一条命令就立即执行。
   * **批处理（Batch）**：由用户事先编写好一个完整的Shell脚本，Shell会一次性执行脚本中诸多的命令。

      查看SHELL变量的值可知当前系统的命令行终端解释器：`echo $SHELL`

   

2. **编写简单的脚本**

      Shell脚本文件的名称可以任意，但为了避免被误以为是普通文件，建议将`.sh`后缀加上，以表示是一个脚本文件。

      脚本构成的三种元素：

      

      **第一行脚本声明** 以#！开头，用来告诉系统使用哪种Shell解释器来执行该脚本。

      **第二行注释信息** 以#开头，对脚本功能和某些命令的介绍信息，使得自己或他人在日后看到这个脚本内容时，可以快速知道该脚本的作用或一些警告信息。

      **第三行及之后可执行语句** 直接写命令序列即可。

      ```bash
      cd test 
      vim example.h
      
      #！/bin/bash
      #For example by NiKo
      pwd
      ls -al
      
      bash example.h
      ```

      

      除了用Bash解释器命令`bash`直接运行Shell脚本文件外，第二种运行脚本程序的方法是通过输入完整路径的方式来执行，如/cd/example.sh

      

3. **使用脚本接收用户参数**

      

         