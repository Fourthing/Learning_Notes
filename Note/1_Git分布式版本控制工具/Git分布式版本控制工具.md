# Git分布式版本控制工具

## 1.学习目标

- 知道Git是什么
- 了解Git具体工作流程
- 熟悉使用Git常用命令
- 熟悉Git代码托管服务并使用idea操作Git

## 2.Git概述

### 2.1 开发场景

- 文件备份
- 代码还原
- 多人协同开发
- 追溯问题代码的编写人和编写时间

### 2.2 版本控制器

- 集中式版本控制工具（半淘汰）

  ​       版本库集中存放在中央服务器，团队成员每个人从中央服务器下载代码，也因此必须联网（物联网或局域网）才能工作，个人修改后提交到中央版本库。

  - `SVN`
  - `CVS`

- 分布式版本控制工具

  每个人的电脑上都有一个自己的版本，工作无需联网，只需要将各自的修改push给对方，也能合并支流

  - `Git`

### 2.3 SVN

![image-20241009150021155](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202410091500189.png)

### 2.4 Git

Git是分布式的，原则上不需要有中心服务器，为了便于大家修改服务器，所以设计了一个中心服务器，仅仅为了方便修改与交换代码，地位和普通的个人电脑地位是一样的。

- 速度
- 设计简单
- 对非线性开发模式的强力支持（允许成千上万个并行开发的分支）
- 完全分布式
- 有高效管理类似Linux内核一样的超大规模（速度和数据量）项目的能力 

![image-20241009145937005](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202410091459109.png)

### 2.5 Git工作流程

![image-20241009194907086](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202410091949176.png)

常用术语：

1. **clone（克隆）**：
   克隆是指从*远程仓库*复制一个完整的代码库到*本地计算机*。使用`git clone <repository>`命令可以创建一个本地副本，包括所有的历史版本和分支。
2. **checkout（检出）**：
   检出是用来切换到不同的分支或恢复特定版本文件的操作（从本地仓库检出一个仓库分支然后进行修订）。使用`git checkout <branch>`命令可以切换到指定的分支或版本，如果需要检出特定的提交，可以使用`git checkout <commit-hash>`。
3. **add（添加）**：
   添加是（在提交前）将文件的修改或新文件包含到暂存区的操作。使用`git add <file>`命令可以将指定文件的更改添加到暂存区，准备进行提交。如果想添加所有更改的文件，可以使用`git add .`。
4. **commit（提交）**：
   提交是将暂存区的更改保存到本地仓库的操作。使用`git commit -m "commit message"`命令，可以将暂存区的内容保存，并附带一条描述当前更改的消息。
5. **fetch（获取）**：
   获取是从 *远程仓库*下载<u>所有的</u>更新到 *本地仓库*，但**不会自动合并**到本地分支中。使用`git fetch`命令可以更新本地的远程跟踪分支，以便查看远程仓库的最新状态。
6. **pull（拉取）**：
   拉取是将*远程仓库*的更新下载到本地并**自动合并**到当前分支的操作。使用`git pull`命令相当于先执行`git fetch`再执行`git merge`，这使得本地分支更新与远程分支同步。
7. **push（推送）**：
   推送是将*本地仓库*的更改上传到*远程仓库*的操作。使用`git push`命令可以将本地的*提交（commit）*更新到远程分支，使其他团队成员能够获取这些更改。



## 3.Git安装配置以及常用命令

### 3.1 安装

不再赘述，安装成功后在任意位置右键可以看到如下两个工具。

![屏幕截图 2024-10-09 195542](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202410091958773.png)

> `Git GUI`：Git提供的**图形界面工具**
>
> `Git Bash`：Git提供的**命令行工具**。有意思的是这似乎就是一个内嵌的Linux命令行，Linux命令都适用。

### 3.2 配置

1. 打开`Git Bash`

2. 设置用户信息

   ```bash
   git config --global user.name "your name"
   git config --global user.email "your email"
   ```

   查看配置信息

   ```bash
   git config --global user.name
   git config --global user.email 
   ```




### 3.3 创建本地仓库

想使用Git对我们的某个项目进行版本控制，

- 首先需要在我们的电脑本地选定一个目录创建一个本地仓库，进入选定目录内打开Git Bash窗口 或者 在任意位置打开Git Bash，再使用cd命令跳转到指定的目录。

  ![image-20241020103043537](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202410201030659.png)

- 执行命令`git init`，执行完毕后可以看到成功出现了一个.git隐藏目录

  ![image-20241020103201117](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202410201032177.png)

  ![image-20241020103258833](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202410201032871.png)

- 创建完毕后即可开始基本的git操作



### 3.4 基础操作

Git工作目录下对于文件的**修改**（增、删、改）会存在几个状态，这些修改的状态会随着我们执行Git的命令而发生变化。

![image-20241020103623662](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202410201036705.png)

我们在日常工作中直接交互的区域是*工作区（workspace）*，在工作区进行增改操作文件有*未暂存（unstaged）*和*未跟踪（untracked）*两种状态。

一个文件在工作目录下被创建，处于未跟踪状态，代表着该文件未处于Git系统管理之下，想要加入Git系统进行管理，则需要执行`git add`命令；对于已有的文件在进行了修改之后仍旧处于未暂存状态，也需要使用`git add`指令进入暂存区。

#### 3.4.1 查看修改的状态（status）

- 作用：查看修改的状态（暂存区、工作区）

- `git status`

- 实例

  - 执行`git add .`（使用通配符的add命令，将全部文件添加到暂存区）之前：

  ![image-20241020105948543](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202410201059580.png)

  - 执行`git add .`之后：

  ![image-20241020111306196](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202410201113245.png)

  可见在执行add命令之后，所有文件都被添加到暂存区

#### 3.4.2 添加工作区到暂存区（add）

- 作用：添加工作区一个或多个文件的修改到暂存区
- `git add 单个文件名|通配符选中多个文件`

#### 3.4.3 提交暂存区到本地仓库（commit）

- 作用：commit命令用于提交暂存区内容至仓库的当前分支，对应一次提交记录

- `git commit -m "注释内容"` 其中`-m`参数是`--message`的缩写，用于提示提交信息

- 实例：可以看到如果没有commit message，commit会中止（abort）的。

  ![image-20241020115559742](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202410201155782.png)

#### 3.4.4 查看提交日志 （log）

- 作用：查看提交记录

- `git log [option]`

  - `options`

    - `--all` 显示所有分支

    - `--pretty=oneline` 将提交信息显示为一行

    - `--abbrev-commit` 使得输出的commitid更简短

    - `--graph` 以图的形式显示

      ![image-20241020115836620](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202410201158665.png)

- 想要更好的效果可以使用自定义常用命令，就不用每次都输入一遍这么长的命令啦

#### 3.4.5 版本回退

- 作用：版本切换

- `git reset --hard commitID` 其中的commitID可以使用`git log`指令查看

- 作用：查看已经删除的记录

-  `git reflog` 用于查看已经删除的提交记录

  ![image-20241020115944891](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202410201159937.png)

  注意到有两个参数的描述是一样的：`--hard`和`--merge`，实际功能是不一样的

  - 使用 `--hard` 会丢弃所有未提交的更改，完全重置到指定提交。
  - 使用 `--merge` 会保留可以合并的更改，并允许您解决冲突。

#### 3.4.6 添加文件至忽略列表

有时`git add .`并不适用于全部情况，有些文件不希望被纳入Git管理，也不希望它们总出现在未跟踪文件列表，举例来说一般都是自动生成的文件，或者是编译过程中的副产品、一些临时文件等等。在这种情况下，可以在工作目录中创建一个名为`.gitignore`的文件（名称是固定的），列出要忽略的文件模式。

- 示例：

  ```bash
  Star@DESKTOP-1NFINP7 MINGW64 /d/ubuntu (master)
  $ touch .gitignore
  
  Star@DESKTOP-1NFINP7 MINGW64 /d/ubuntu (master)
  $ vi .gitignore
  
  ```

  在vi或者vim中编辑文件，结合通配符设置忽略的文件格式即可。

  ```bash
  # no .a files  
  *.a  
  # but do track lib.a, even though you're ignoring .a files above  
  !!lib.a  
  # only ignore the TODO file in the current directory, not subdir/TODO  
  /TODO  
  # ignore all files in the build/ directory  
  build/  
  # ignore doc/notes.txt, but not doc/server/arch.txt  
  doc/*.txt  
  # ignore all .pdf files in the doc/ directory  
  doc/**/*.pdf
  ```




### 3.5分支

几乎所有的版本控制系统都以某种形式支持分支，版本控制系统中的分支（Branch）是一种创建代码或文档的独立副本的方法，以便在这一副本上进行独立的开发工作，而不会影响主线（通常称为“主分支”或“主干”）的代码。分支允许开发者在同一项目中**并行开发**不同的特性、修复错误或**进行实验**，之后再将这些更改**合并回主分支**。

也因此，同一工作区同一时间只能编辑一个分支！想在不同的分支进行更改，需要进行**切换分支（checkout）**操作。

#### 3.5.1 查看本地分支

- `git branch` 列出所有本地分支，并标记当前所处的分支。

#### 3.5.2 创建本地分支

- `git branch 新分支名`

#### 3.5.3 切换分支(checkout)

- `git checkout 目标分支名`
- `git switch <branch-name>` Git 2.23以后的新命令
- `git checkout -b 新目标分支名` 该命令功能是切换到一个不存在的分支（创建并切换）

#### 3.5.4 合并分支(merge)

一个分支上的提交可以合并到另一个分支

- `git merge 分支名`

#### 3.5.5 删除分支

不能删除当前分支（正在工作区的），只能删除其他分支

- `git branch -d <branch-name> `删除指定的本地分支（在分支合并后，通常会使用此命令），会进行检查。
- `git branch -D <branch-name>` 强制删除未合并的分支。

#### 3.5.6 解决冲突

在Git中，冲突通常发生在合并（merge）或变基（rebase）操作时。这是因为两个分支在相同的文件和行进行了不同的更改，Git无法确定应选择哪一方的更改。

在执行 `git merge <branch-name>` 或 `git rebase` 时，如果某些文件发生了冲突，Git会生成一个错误消息，提示你哪些文件存在冲突。

同时，这些文件的状态会变为`“Unmerged”`。使用`git status`命令查看冲突的文件，手动编辑冲突的文件，选择你想保留的改动，可以保留其中一个或是合并两者。                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      

接着将文件修改添加至暂存区`git add .`一次性添加所有解决了冲突的文件。

- 如果是在合并操作中，接着执行：`git commit`，这里不用使用-m，Git会自动生成一个合并的提交消息，也可以手动编辑。

- 如果是在变基操作中，使用：`git rebase --continue`

使用`git status`命令查看更改后的状态，或者使用`git log`检查提交历史。



#### 3.5.7 开发中分支使用原则与流程

在开发中分支不是任意使用命名的，一般需要遵循一定的规范，一般用到以下分支或使用它们的缩写

- **master（主产）分支**
  线性分支、主分支，中小规模项目作为线性运行的应用对应的分支；

- **develop（开发）分支**
  是从master创建的分支，一般作为开发部门的主要开发分支，如果没有并行开发不同时期的需求，都可以在此进行开发，阶段开发完成后，需要合并到master分支，准备上线。

- **feature/xxx分支**
  是从develop创建的分支，一般是周期性开发，但不同期上线的创建的分支，分支上的研发任务完成后合并到develop分支。

- **hotfix/xxx分支**
  是从master派生的分支，一般作为线上的bug修复使用，修复完成后需要合并到master、test、develop分支。

- 还有一些其他分支，在不再维护，例如test分支（用于代码测试）、pre分支（预上线分支）等。

  ![image-20241020160422065](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202410201604171.png)

  

## 4. Git远程仓库

### 4.1 常用的托管服务(远程仓库)

### 4.2 注册

### 4.3 创建远程仓库

### 4.4 配置SSH公钥

### 4.5 操作远程仓库

#### 4.5.1 添加远程仓库

#### 4.5.2

#### 4.5.3

#### 4.5.4







