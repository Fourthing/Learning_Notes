
# 泛型数组列表ArrayList

在许多程序设计语言中，特别是在C语言中，必须在编译时就确定整个数组的大小。

在Java中，情况就好多了。它允许在运行时**确定数组的大小**。

```java
int actualSize = ...;
Employee[] staff = new Employee[actualSize];
```

当然，这段代码并没有完全解决运行时动态更改数组的问题。一旦确定了数组的大小，**改变**它就不太容易了。

在Java中，解决这个问题最简单的方法是使用Java中另外一个被称为`ArrayList`的类。它使用起来像数组，但在添加或删除元素时，具有自动调整数组容量的功能，而不需要为此编写任何代码。

在Java SE 5.0中，ArrayList是一个采用*类型参数（type parameter）*的*泛型类（generic class）*。为了指定数组列表保存的元素对象类型，需要用一对尖括号将类型括起来在后面，例如，`ArrayList<Employee>`。

```java
// 引入 ArrayList 类
import java.util.ArrayList; 
//声明、构造
ArrayList<Employee> staff = new ArrayList<Employee>();
```

![img](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202410311352928.png)

`ArrayList` 继承了 `AbstractList` ，并实现了 `List` 接口。

## 常用方法

| 方法                                                         | 描述                                          |
| ------------------------------------------------------------ | --------------------------------------------- |
| [add()](https://www.runoob.com/java/java-arraylist-add.html) | 将元素插入到指定位置的 arraylist 中           |
| [addAll()](https://www.runoob.com/java/java-arraylist-addall.html) | 添加集合中的所有元素到 arraylist 中           |
| [clear()](https://www.runoob.com/java/java-arraylist-clear.html) | 删除 arraylist 中的所有元素                   |
| [clone()](https://www.runoob.com/java/java-arraylist-clone.html) | 复制一份 arraylist                            |
| [contains()](https://www.runoob.com/java/java-arraylist-contains.html) | 判断元素是否在 arraylist                      |
| [get()](https://www.runoob.com/java/java-arraylist-get.html) | 通过索引值获取 arraylist 中的元素             |
| [indexOf()](https://www.runoob.com/java/java-arraylist-indexof.html) | 返回 arraylist 中元素的索引值                 |
| [removeAll()](https://www.runoob.com/java/java-arraylist-removeall.html) | 删除存在于指定集合中的 arraylist 里的所有元素 |
| [remove()](https://www.runoob.com/java/java-arraylist-remove.html) | 删除 arraylist 里的单个元素                   |
| [size()](https://www.runoob.com/java/java-arraylist-size.html) | 返回 arraylist 里元素数量                     |
| [isEmpty()](https://www.runoob.com/java/java-arraylist-isempty.html) | 判断 arraylist 是否为空                       |
| [subList()](https://www.runoob.com/java/java-arraylist-sublist.html) | 截取部分 arraylist 的元素                     |
| [set()](https://www.runoob.com/java/java-arraylist-set.html) | 替换 arraylist 中指定索引的元素               |
| [sort()](https://www.runoob.com/java/java-arraylist-sort.html) | 对 arraylist 元素进行排序                     |
| [toArray()](https://www.runoob.com/java/java-arraylist-toarray.html) | 将 arraylist 转换为数组                       |
| [toString()](https://www.runoob.com/java/java-arraylist-tostring.html) | 将 arraylist 转换为字符串                     |
| [ensureCapacity](https://www.runoob.com/java/java-arraylist-surecapacity.html)() | 设置指定容量大小的 arraylist                  |
| [lastIndexOf()](https://www.runoob.com/java/java-arraylist-lastindexof.html) | 返回指定元素在 arraylist 中最后一次出现的位置 |
| [retainAll()](https://www.runoob.com/java/java-arraylist-retainall.html) | 保留 arraylist 中在指定集合中也存在的那些元素 |
| [containsAll()](https://www.runoob.com/java/java-arraylist-containsall.html) | 查看 arraylist 是否包含指定集合中的所有元素   |
| [trimToSize()](https://www.runoob.com/java/java-arraylist-trimtosize.html) | 将 arraylist 中的容量调整为数组中的元素个数   |
| [removeRange()](https://www.runoob.com/java/java-arraylist-removerange.html) | 删除 arraylist 中指定索引之间存在的元素       |
| [replaceAll()](https://www.runoob.com/java/java-arraylist-replaceall.html) | 将给定的操作内容替换掉数组中每一个元素        |

可以看到`ArrayList`提供了常用的增删改查方法、显示当前容量方法等等。

官方文档：[ArrayList (Java SE 11 & JDK 11 )](https://www.runoob.com/manual/jdk11api/java.base/java/util/ArrayList.html)
