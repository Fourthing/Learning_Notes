## Day4  力扣5：最长回文子串

### 2024年9月9日15:38:20

#### 一、java文件名和类名一致性问题

首先明确，不是必须一致。若一个类是公共`（public）`的，则应该在一个同名的java文件中声明。反之default类型的类声明则可以成功通过编译，编译后的`.class`文件和所声明的类名一致。

```java
public class Demo01_HelloWorld{
    public static void main(String args[]){
    	System.out.println("H R!");
	}
}
```

若有多个class声明，则会生成对应的多个`.class`文件，但不建议这么写，实际开发为了保证规范性，一个java文件写一个class。main方法写在带public类的java文件中。

#### 二、java关键字

下面列出了 Java 关键字。这些保留字不能用于常量、变量、和任何标识符的名称。

| 类别                 | 关键字       | 说明                           |
| :------------------- | :----------- | :----------------------------- |
| 访问控制             | private      | 私有的                         |
|                      | protected    | 受保护的                       |
|                      | public       | 公共的                         |
|                      | default      | 默认                           |
| 类、方法和变量修饰符 | abstract     | 声明抽象                       |
|                      | class        | 类                             |
|                      | extends      | 扩充、继承                     |
|                      | final        | 最终值、不可改变的             |
|                      | implements   | 实现（接口）                   |
|                      | interface    | 接口                           |
|                      | native       | 本地、原生方法（非 Java 实现） |
|                      | new          | 创建                           |
|                      | static       | 静态                           |
|                      | strictfp     | 严格浮点、精准浮点             |
|                      | synchronized | 线程、同步                     |
|                      | transient    | 短暂                           |
|                      | volatile     | 易失                           |
| 程序控制语句         | break        | 跳出循环                       |
|                      | case         | 定义一个值以供 switch 选择     |
|                      | continue     | 继续                           |
|                      | do           | 运行                           |
|                      | else         | 否则                           |
|                      | for          | 循环                           |
|                      | if           | 如果                           |
|                      | instanceof   | 实例                           |
|                      | return       | 返回                           |
|                      | switch       | 根据值选择执行                 |
|                      | while        | 循环                           |
| 错误处理             | assert       | 断言表达式是否为真             |
|                      | catch        | 捕捉异常                       |
|                      | finally      | 有没有异常都执行               |
|                      | throw        | 抛出一个异常对象               |
|                      | throws       | 声明一个异常可能被抛出         |
|                      | try          | 捕获异常                       |
| 包相关               | import       | 引入                           |
|                      | package      | 包                             |
| 基本类型             | boolean      | 布尔型                         |
|                      | byte         | 字节型                         |
|                      | char         | 字符型                         |
|                      | double       | 双精度浮点                     |
|                      | float        | 单精度浮点                     |
|                      | int          | 整型                           |
|                      | long         | 长整型                         |
|                      | short        | 短整型                         |
| 变量引用             | super        | 父类、超类                     |
|                      | this         | 本类                           |
|                      | void         | 无返回值                       |
| 保留关键字           | goto         | 是关键字，但不能使用           |
|                      | const        | 是关键字，但不能使用           |

**注意：**Java 的 null 不是关键字，类似于 true 和 false，它是一个字面常量，不允许作为标识符使用。

#### 三、常量与变量

![image-20240910104132902](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202409101041021.png)



#### 四、今日刷题

[最长回文子串](https://leetcode.cn/problems/longest-palindromic-substring/)

提示：给你一个字符串 `s`，找到 `s` 中最长的 回文子串。

**示例 1：**

```
输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。
```

**示例 2：**

```
输入：s = "cbbd"
输出："bb"
```

**提示：**

- `1 <= s.length <= 1000`
- `s` 仅由数字和英文字母组成

##### 题解1：暴力解法

时间复杂度：$O（n^3）$

```java
class Solution {
    public boolean isPalindrome(String s){
        int n=s.length();
        for(int i=0;i<n/2;i++){
            if (s.charAt(i)!=s.charAt(n-i-1))
                return false;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        int longestLen=0;
        int start=0; //子串开始处
        int end=0;//子串结束处
        if(n<1)
            return "";
        if(n==1)
            return s;
        for(int i=0;i<n;i++){
           for(int j=i;j<n;j++){
				if(isPalindrome(s.substring(i,j+1))==true){
                    if(longestLen<j-i+1){
                        longestLen=j-i+1;
                        start=i;
                    	end=j;
                    }
                }
           }
        }
        return s.substring(start,end+1);
    }
}
```

遇到的几个问题：

- substring()前闭后开
- 字符串输入判断
- 效率问题，过长的字符串处理时间
- 字符串长度为0或1

改进了1、2、4问题后，已经可以成功输出正确的结果，但是时间复杂度过高，提交后发现超出了时间限制。

##### 题解2：中点扩散

时间复杂度：$O(n^2)$

空间复杂度：$O(1)$

思路为遍历所有字符串节点 ，依次从每个节点往两边扩散，判断是否为回文串。

```java
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int longestLen=0;
        int start=0; //子串开始处
        int end=0;//子串结束处
        if(n<1)
            return "";
        else if(n==1)
            return s;
        else{
            for(int i=0;i<n;i++){//遍历节点
                for(int j=1;j<n-1;j++){//向左扩散
                    if(i-j<0)
                        break;
                    if(s.charAt(i-j)==s.charAt(i)){
                        longestLen=j+1;
                        start=i-j;
                        end=i;
                    }
                }
                for(int k=1;k<n-1;k++){//向右扩散
                    if(i+k>n-1)
                        break;
                    if(s.charAt(i+k)==s.charAt(i)){
                        longestLen=k+1;
                        start=i;
                        end=i+k;
                    }
                }
                for(int p=1;p<n/2;p++){//双向扩散
                    if(i-p<0||i+p>n-1)
                        break;
                    if(s.charAt(i-p)==s.charAt(i+p)){
                        longestLen=longestLen+2;
                        start=i-p;
                        end=i+p;
                    }
                }
            }
        }
        return s.substring(start,end+1);
    }
}
```

问题：

- 思路的确定：初步的思路已经确定为向两边扩散的比较方法，但是这个思路没有考虑到边界的特殊情况，比如从开头或者结尾开始时又该怎么扩散？

- 进一步考虑：我们遍历到的每一个节点，在当前的循环里是作为中心点来考虑的，中心点可以有一个或两个，也因此开头和结尾必不可能是只有一个中心点的情况，所以只能单向扩散去寻找两个中心点的情况。

- 最后方法的确立：要保证不重不漏，我们必须设计一个扩散的规范，最好能保证对所有节点都适用，因此只使用双向扩散；输入后进行输入判断；节点处于头和尾时判定为只有一个字符的回文串，从下一个位置继续匹配。


改进：

```java
class Solution {
    public int expandAroundCenter(String s,int left,int right){
        //辅助函数用于从中心双向扩展，返回最长回文子串的长度
		while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            //不一定要使用for循环，不确定循环次数时使用while循环更好
            left--;
            right++;
        }
        // 要注意最后一次的退出条件！ 实际回文长度为right - left - 1
        return right-left-1;
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 1) return "";
        //最终结果的头\尾索引
        int start = 0, end = 0;

        for(int i=0;i<n;i++){
            // 以字符s[i]为中心，扩展奇数长度的回文
            int len1 = expandAroundCenter(s, i, i);
            // 以字符s[i]和s[i+1]为中心，扩展偶数长度的回文
            int len2 = expandAroundCenter(s, i, i + 1);

            int len=Math.max(len1,len2);
            // 更新最长回文子串的起始和结束位置
            if(len>end-start+1){
                //要注意索引是从0开始的
                start=i-(len-1)/2;
                end=i+len/2;
            }
        }
        return s.substring(start,end+1);
    }
    
}
```

##### 题解3：动态规划

时间复杂度：$O(n^2)$

空间复杂度：$O(n^2)$

动态规划方法是一种用空间换时间的自底向上方法，先把问题分解成若干个子问题，一般使用数组来存储已经解决的子问题的解，这有点类似于分治法，但是分治法所分解的子问题一般互相独立。动态规划一般有一个状态转移方程，用以帮助递推的过程。

```java
class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        int start=0,end=0,len=0;
        int longestLen=0;
        //动态规划数组
        boolean[][] dp=new boolean[n][n];

        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                //当j=i时，代表单一字符一定是回文串，接下来就会继续向下推
                if(s.charAt(i)==s.charAt(j) && (j-i<=1 || dp[i+1][j-1])){//这句判断语句是关键，代表递推遇到两种情况，1.仅有一或二个字符必是回文串 2.双向中心扩散一个字符这里的i+1和j-1
                    dp[i][j]=true;
                    if(j-i+1>longestLen){
                        longestLen=j-i+1;
                        start=i;
                        end=j;
                    }
                }
            }
        }
        return s.substring(start,end+1);
    }
}
```

在这题里，其实就是一个用短字符串来推长字符串的过程。状态转移方程为`f[left][right] = f[left+1][right-1] && s[left] == s[right]`

但是这种方法的资源消耗比不上中心扩散方法。

##### 题解4：Manacher 算法

这是一种效率较高的解法，但是比较复杂，二刷会补全此方法

```java

```

##### 题解5：KMP

回文串有一个特点，正着反着读都一样，那么只要将原先的字符串s倒序为新的字符串s'，再与原来的字符串s做字符串匹配（KMP算法或最简单的朴素字符串匹配），即可较为高效的判断回文串。

```java
class Solution {
    public String longestPalindrome(String s) {

        int length = s.length();
        String maxStr="";
        String reverse=new StringBuffer(s).reverse().toString();

        int x=0;
        int y=1;
        while (x<length&&y<=length){
            String substring = s.substring(x, y);
            if (reverse.contains(substring)){
                if(substring.equals(new StringBuffer(substring).reverse().toString()))
                if (substring.length()>maxStr.length()){
                    maxStr=substring;
                }
                y++;
            }else {
                x++;
                y=x+1;
            }
        }

        return maxStr;
    }
}
```

