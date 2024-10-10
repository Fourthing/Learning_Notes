## Day 3

### 2024年9月8日14:23:37

> 再次跟上Java的补漏学习，重点关注细节知识点，强化重点。

### 一、入门程序

编码没有问题，顺便复习一下dos命令：

创建文件夹并切换路径

```cmd
mkdir D:\JavaLearning\JavaLesson\Demo
cd D:\JavaLearning\JavaLesson\Demo
```

创建文件并使用记事本打开（需要管理员权限）

```cmd
notepad Demo01_HelloWorld.java
```

编写程序

```java
public class Demo01_HelloWorld{
    public static void main(String args[]){
    	System.out.println("Hello World!");
	}
}
```

需要注意的是

- *类名要和java文件名保持一致*。

- 搞清楚记事本的编码规范是GBK还是UTF-8，以免出现中文乱码问题。

  > - 编码：保存数据的过程就是编码的过程
  >
  > - 解码：读数据的过程就是解码的过程
  >
  > 注意！编码和解码的编码规范必须是一样的。
  >
  > 常见的两个编码规范：**GBK（ANSI）**与**UTF-8**
  >
  > GBK是专门为中文字符设计的编码，一个中文字符在GBK中占2个字节，在UTF-8中占3个字节，DOS命令窗口默认编码采用的是GBK模式

接着进行编译运行

```cmd
javac Demo01_HelloWorld.java
java Demo01_HelloWorld
```

成功输出结果。

#### 二、今日刷题

![image-20240908202015978](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202409082020182.png)

> **1.两数之和（简单）**
>
> 给定一个整数数组 `nums` 和一个整数目标值 `target`，请你在该数组中找出 **和为目标值** *`target`* 的那 **两个** 整数，并返回它们的数组下标。
>
> 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
>
> 你可以按任意顺序返回答案。

基本思路：使用一个双层嵌套for循环语句和一个if判断语句，要注意的是for语句的循环边界应该根据数组长度来确定，Java中的数组长度可以有两种办法（参考 [在 Java 中获取数组的长度 | D栈 - Delft Stack](https://www.delftstack.com/zh/howto/java/java-get-array-length/#在-java-中使用数组-length-属性来获取数组的长度)、[for-each循环的认识、定义、适用对象、举例、局限性_for each-CSDN博客](https://blog.csdn.net/qq_43573663/article/details/107446305)）：

- 数组 `length` 属性

  直接通过`数组名.length`使用

- `for-each` 循环（增强的for循环）

  ![image-20240908202534477](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202409082025508.png)

![image-20240908202642920](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202409082026955.png)

要注意的是 for-each虽然能遍历数组或者集合，但是只能用来遍历，无法在遍历的过程中对数组或者集合进行修改，而for循环可以在遍历的过程中对源数组或者集合进行修改。

题解：

```java
//时间复杂度：O（n^2）
//空间复杂度：O(1)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int a[] = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(target==(nums[i]+nums[j]))
                    {
                        a[0]=i;a[1]=j;
                    }
            }
        }
        return a;
    }
}
```

这种枚举解法的时间复杂度较高，如果我们需要提高查找的速度，可以采用以空间换时间的做法：`HashMap`

```java
// 引入 HashMap 类      
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hashtable=new HashMap<Integer,Integer>();
        //声明一个Map映射接口的对象hashtable，同时使用 HashMap 类的构造函数创建一个新的哈希表实例。HashMap 是 Map 接口的一个实现，提供了基于哈希表的键值对存储。（值是索引，键是存储的值）
        for(int i=0;i<nums.length;i++){
            //降低了时间复杂度，使用一个循环，每次循环去寻找另外一个补数
            if(hashtable.containsKey(target-nums[i])){
                return new int[]{hashtable.get(target-nums[i]),i};//返回的是索引值
            }
            hashtable.put(nums[i],i);//将遍历到的值加入哈希表，以避免找到自己
        }
        return new int[0];
    }
}
```

> 在 Java 中，`HashMap` 提供了多种方法来操作键值对。以下是一些常用的方法：
>
> 1. **添加元素**：
>    - `put(K key, V value)`：将指定的键和值添加到哈希表中。如果键已存在，则更新其对应的值。
>    ```java
>    hashtable.put(1, 100);
>    ```
>
> 2. **获取元素**：
>    - `get(Object key)`：根据指定的键获取对应的值。如果键不存在，则返回 `null`。
>    ```java
>    Integer value = hashtable.get(1);
>    ```
>
> 3. **删除元素**：
>    - `remove(Object key)`：根据指定的键删除对应的键值对。如果键不存在，则不做任何操作。
>    ```java
>    hashtable.remove(1);
>    ```
>
> 4. **检查键是否存在**：
>    - `containsKey(Object key)`：检查哈希表中是否包含指定的键。
>    ```java
>    boolean exists = hashtable.containsKey(1);
>    ```
>
> 5. **检查值是否存在**：
>    - `containsValue(Object value)`：检查哈希表中是否包含指定的值。
>    ```java
>    boolean hasValue = hashtable.containsValue(100);
>    ```
>
> 6. **获取键的集合**：
>    - `keySet()`：返回哈希表中所有键的集合。
>    ```java
>    Set<Integer> keys = hashtable.keySet();
>    ```
>
> 7. **获取值的集合**：
>    - `values()`：返回哈希表中所有值的集合。
>    ```java
>    Collection<Integer> values = hashtable.values();
>    ```
>
> 8. **获取键值对的集合**：
>    - `entrySet()`：返回哈希表中所有键值对的集合。
>    ```java
>    Set<Map.Entry<Integer, Integer>> entries = hashtable.entrySet();
>    ```
>
> 9. **清空哈希表**：
>    - `clear()`：清空哈希表中的所有键值对。
>    ```java
>    hashtable.clear();
>    ```
>
> 10. **获取大小**：
>     - `size()`：返回哈希表中键值对的数量。
>     ```java
>     int size = hashtable.size();
>     ```
