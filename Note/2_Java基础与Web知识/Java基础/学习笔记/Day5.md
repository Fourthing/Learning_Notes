

## Day5 JavaWeb知识了解以及每日一题：力扣125.验证回文串

### 2024年9月24日20:06:45

#### JavaWeb基础知识

#### Tomcat

**Apache Tomcat**是一个开源的Servlet容器和Web服务器，它是Java EE（Enterprise Edition）的一部分，专门用于运行Java Servlet和JavaServer Pages（JSP）。Tomcat的主要功能是接收HTTP请求，处理这些请求，并返回HTTP响应。哦对了，Tomcat是轻量级的Web服务器但是简单易用，因此用途很广。

##### Tomcat的架构

1. **Servlet容器**：负责管理Servlet的生命周期，包括加载、实例化、初始化、请求处理和销毁。
2. **连接器**：处理与客户端（浏览器）的连接，可以是HTTP、HTTPS等协议。
3. **引擎**：在Tomcat内部，负责处理请求并将其转发到适当的Servlet。
4. **上下文（Context）**：表示Web应用的一个实例，Tomcat可以同时运行多个Web应用。

##### Tomcat的工作流程

1. **客户端请求**：浏览器向Tomcat发送HTTP请求。
2. **请求处理**：Tomcat通过连接器接收请求，并将其传递给Servlet容器。
3. **调用Servlet**：Servlet容器根据请求的URL找到相应的Servlet，创建请求和响应对象。
4. **生成响应**：Servlet处理请求，并生成响应内容（如HTML、JSON等），返回给Tomcat。
5. **返回给客户端**：Tomcat将响应返回给客户端，浏览器接收并渲染页面。

##### 常用配置

- **`server.xml`**：Tomcat的主要配置文件，定义服务器端口、连接器、上下文等。
- **`web.xml`**：Web应用的配置文件，定义Servlet、过滤器、监听器等。

##### 典型应用场景

- **Web应用**：用于构建和部署Java Web应用。
- **RESTful服务**：可以用Tomcat运行基于Java的REST API。
- **开发和测试**：作为开发环境进行快速迭代和测试。

#### JSP技术

**JavaServer Pages (JSP)** 是一种基于Java的动态网页技术，允许开发者在HTML中嵌入Java代码，以便于生成动态内容。JSP文件在服务器上被编译成Servlet，能够处理用户请求并生成响应，通常用于构建用户界面和动态网页。拿猜数游戏举例，需要记录猜数的次数，这是`numguess.jsp`中的一句语句，根据次数动态地显示内容：

```jsp
You have made <%= numguess.getNumGuesses() %> guesses.<p>
You have made <jsp:setProperty name="numguess" property="numguess"/> guesses.
```

但是近几年随着前后端分离应用的增加，JSP使用频率减少，也有更强大的Web框架如Spring MVC、JSF等

##### 主要特点

1. **简化的语法**：与直接使用Servlet相比，JSP提供了更简洁的语法，使得在HTML中嵌入Java代码更加方便。
2. **自动编译**：JSP文件在首次请求时会自动被Servlet容器编译成Servlet，无需手动编译。
3. **与Servlet协作**：JSP与Servlet协同工作，Servlet负责处理业务逻辑，而JSP负责生成用户界面。
4. **标签库支持**：JSP支持自定义标签库（如JSTL），提供了更强大的功能，简化了页面开发。

##### JSP的工作流程

1. **请求接收**：客户端向JSP页面发送HTTP请求。
2. **编译**：如果是首次请求，JSP容器将JSP文件编译成Servlet。
3. **执行Servlet**：执行编译后的Servlet，生成动态内容。
4. **返回响应**：将生成的HTML或其他格式的内容返回给客户端。

##### JSP语法

1. **指令**：用于设置JSP页面的属性，如页面编码、内容类型等。

   ```jsp
   <%@ page language="java" contentType="text/html; charset=UTF-8" %>
   ```
   
2. **脚本块**：可以直接在JSP中写Java代码。

   ```jsp
   <%
       String message = "Hello, World!";
   %>
   ```

3. **表达式**：用于输出变量或表达式的值。

   ```jsp
   <%= message %>
   ```
   
4. **JSP标签**：使用HTML标签来处理动态内容，通常结合JSTL（JavaServer Pages Standard Tag Library）使用。

   ```jsp
   <c:forEach var="item" items="${itemList}">
       <li>${item}</li>
   </c:forEach>
   ```

##### 使用场景

- **动态网页生成**：根据用户输入生成个性化的网页内容。
- **表单处理**：接收用户提交的表单数据并显示结果。
- **数据展示**：从数据库中提取数据，并在网页上展示。

##### 示例代码

以下是一个简单的JSP示例：

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <h1>Welcome to My JSP Page</h1>
    <%
        String message = "Hello, World!";
    %>
    <p><%= message %></p>

    <c:forEach var="i" begin="1" end="5">
        <p>Item <c:out value="${i}" /></p>
    </c:forEach>
</body>
</html>
```

在这个例子中，JSP页面展示了欢迎信息，并使用JSTL输出循环内容。

JSP是构建动态Web应用的重要技术，能够将Java与HTML结合，实现灵活的数据展示。

#### Servlet技术

**Servlet**是Java EE的一部分，是一种服务器端的Java程序，用于处理客户端（通常是Web浏览器）发送的请求，并生成动态响应。Servlet通过Java编写，能够与Web服务器（如Tomcat）交互，通常用于构建Web应用程序的业务逻辑层。

##### 主要特点

1. **平台独立**：Servlet是用Java编写的，因此可以在任何支持Java的服务器上运行。
2. **高效**：Servlet在服务器端运行，能够处理大量并发请求，性能优越。
3. **生命周期管理**：Servlet的生命周期由Servlet容器管理，支持初始化、请求处理和销毁的不同阶段。
4. **会话管理**：Servlet可以跟踪用户的会话状态，支持持久化数据和用户交互。

##### Servlet的工作流程

1. **请求接收**：客户端发送HTTP请求，Servlet容器接收请求。
2. **请求分发**：Servlet容器查找对应的Servlet并创建一个请求对象（`HttpServletRequest`）和响应对象（`HttpServletResponse`）。
3. **处理请求**：Servlet中的`doGet()`或`doPost()`方法被调用，处理请求并生成响应。
4. **生成响应**：Servlet将处理结果（如HTML、JSON等）写入响应对象。
5. **返回给客户端**：Servlet容器将响应返回给客户端，浏览器接收并展示。

##### Servlet的生命周期

Servlet的生命周期由以下几个阶段构成：

1. **加载**：Servlet容器加载Servlet类，创建其实例。
2. **初始化**：调用`init()`方法进行初始化。通常用于设置配置参数。
3. **请求处理**：处理来自客户端的请求，调用`doGet()`或`doPost()`方法。
4. **销毁**：调用`destroy()`方法进行清理工作，释放资源。

##### 常用方法

- **`doGet(HttpServletRequest req, HttpServletResponse res)`**：处理GET请求。
- **`doPost(HttpServletRequest req, HttpServletResponse res)`**：处理POST请求。
- **`init()`**：初始化Servlet，执行一次。
- **`destroy()`**：销毁Servlet，释放资源。

##### 使用场景

- **表单处理**：接收并处理用户输入的表单数据。
- **动态内容生成**：根据请求生成动态HTML或其他格式的响应。
- **业务逻辑**：作为业务逻辑层，与数据库交互，处理数据。

##### 示例代码

以下是一个简单的Servlet示例：

```java
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Hello, World!</h1>");
    }
}
```

在这个例子中，`HelloServlet`处理GET请求并返回一个简单的HTML响应。

#### JavaBean技术

##### JavaBean概述

**JavaBean**是一种符合特定约定的Java类，用于封装多个对象成一个单一对象（bean）。JavaBean通常用于表示数据模型，便于在不同的Java组件之间传递和共享数据。JavaBean广泛应用于Java EE和Java Web应用中，尤其是在JSP和Servlet中。我们平时可能不知不觉使用的就是JavaBean，可以理解成是一种编码规范的类吧。

##### 主要特点

1. **封装性**：JavaBean使用私有属性，通过公共的getter和setter方法进行访问和修改，遵循封装原则。
2. **可重用性**：JavaBean可以在不同的应用程序中重用，支持模块化设计。
3. **无参数构造函数**：JavaBean必须提供一个无参数构造函数，以便于反射和实例化。
4. **可序列化**：JavaBean通常实现`Serializable`接口，使其可以方便地进行序列化和反序列化。

##### JavaBean的结构

一个标准的JavaBean通常具有以下结构：

1. **私有属性**：使用私有访问修饰符定义类的属性。
2. **无参数构造函数**：提供一个公共的无参数构造函数。
3. **公共的getter和setter方法**：提供用于访问和修改属性的公共方法。

##### 示例代码

以下是一个简单的JavaBean示例：

```java
import java.io.Serializable;

public class Student implements Serializable {
    private String id;
    private String name;
    private int age;

    // 无参数构造函数
    public Student() {}

    // Getter和Setter方法
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
```

在这个例子中，`Student`类是一个JavaBean，封装了学生的基本信息，包括学号、姓名和年龄。

##### 使用场景

- **数据传输**：在不同层（如控制层和视图层）之间传递数据。
- **JSP和Servlet**：在Web应用中作为模型对象，通过JSP展示数据或通过Servlet接收表单数据。
- **ORM框架**：如Hibernate和JPA中，JavaBean常用于映射数据库表。


#### 一、题目

> 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 **回文串** 。
>
> 字母和数字都属于字母数字字符。
>
> 给你一个字符串 `s`，如果它是 **回文串** ，返回 `true` ；否则，返回 `false` 。
>
> **示例 1：**
>
> ```
> 输入: s = "A man, a plan, a canal: Panama"
> 输出：true
> 解释："amanaplanacanalpanama" 是回文串。
> ```
>
> **示例 2：**
>
> ```
> 输入：s = "race a car"
> 输出：false
> 解释："raceacar" 不是回文串。
> ```
>
> **示例 3：**
>
> ```
> 输入：s = " "
> 输出：true
> 解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
> 由于空字符串正着反着读都一样，所以是回文串。
> ```
>
> **提示：**
>
> - `1 <= s.length <= 2 * 105`
> - `s` 仅由可打印的 ASCII 字符组成

#### 二、题解

##### 1.朴素写法

​	一开始不熟悉字符串比较规则，其实本质就是比较ASCII码，转换的地方使用了强制类型转换。多用了一个临时变量ch来储存单个字符，因为多层的嵌套或含有函数的语句比较容易出错且逻辑容易不清晰，不便于修改。

```java
class Solution {
    public boolean isPalindrome(String s) {
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                temp += ch;
            } else if (ch >= 'A' && ch <= 'Z') {
                temp += (char) (ch + 32); // 转换为小写字母
            }
        }
        
        int i = 0, j = temp.length() - 1;
        while (i < j) {
            if (temp.charAt(i) != temp.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

```

​	这里判断是否为回文串使用到了`while`循环和`if`语句，之所以不用`for`循环的原因是不知道具体的循环次数。使用两个指针来减少临时空间的额外开销。需要注意的是我一开始的写法是这样的：

```java
class Solution {
    public boolean isPalindrome(String s) {
        String temp="";
        for(int i=0;i<s.length();i++){
            if((s.charAt(i)>=97 && s.charAt(i)<=122)||(s.charAt(i)>=48 && s.charAt(i)<=57)){
                temp=temp+s.charAt(i);
            }
            else if(s.charAt(i)>=65 && s.charAt(i)<=90){
                char s1=s.charAt(i);
                temp=temp+(char)(s1+32);
            }
        }
        int i=0,j=temp.length()-1;
        while(i<=j && (temp.charAt(i)==temp.charAt(j))){
            i++;
            j--;
        }
        if(i==j+1)
            return true;
        else
            return false;
    }
}
```

这种写法的逻辑有重复之处，可以写成上面那种更为简洁的形式。

##### 2.使用Java自带函数

那么能不能进一步优化呢？注意到Java自带了现成的函数来判断是否为数字和字母。

使用Java自带的函数有几个好处：

1. **代码简洁性**：内置函数可以大大减少代码量，使代码更易读和维护。
   
2. **性能优化**：Java的标准库经过优化，通常比手动实现的版本性能更好，特别是在处理字符串操作时。

3. **错误处理**：内置函数往往处理了多种边界情况和异常，使得代码更加健壮。

4. **可读性**：使用内置函数可以提高代码的可读性，其他开发者更容易理解你的意图。

5. **功能丰富**：Java标准库提供了大量实用的工具，能够快速实现复杂的操作，节省开发时间。

```java
class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                temp.append(Character.toLowerCase(ch));
            }
        }
        int i = 0, j = temp.length() - 1;
        while (i < j) {
            if (temp.charAt(i) != temp.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
```

##### 3.优化执行性能

既然是简单的题，不能止步于解出题目，想想能不能进一步优化性能？

**使用`StringBuilder`**：如果要创建临时字符串，那么可以使用`StringBuilder`。避免在循环中使用字符串拼接（`temp +=`），因为这会**在每次拼接时创建新的字符串对象，影响性能。**

> `StringBuilder`是Java中的一个类，用于创建可变字符串。与`String`不同，`String`是不可变的，每次修改都会创建新的对象，而`StringBuilder`允许在原有对象上进行修改，这样可以提高性能，尤其是在需要频繁拼接或修改字符串的情况下。
>
> ### 主要特点：
>
> 1. **可变性**：可以在不创建新对象的情况下修改字符串内容。
> 2. **高效性**：在进行多次字符串拼接时，比使用`String`更高效。
> 3. **多种方法**：提供了多种方法，如`append()`, `insert()`, `delete()`, 和 `reverse()`，方便字符串操作。
>
> 例如：
>
> ```
> java复制代码StringBuilder sb = new StringBuilder();
> sb.append("Hello");
> sb.append(" ");
> sb.append("World!");
> String result = sb.toString(); // 结果为 "Hello World!"
> ```
>
> 这样使用`StringBuilder`可以有效减少内存使用和提高执行效率，特别是在需要进行多次字符串操作的场景中。

有没有不用创建临时字符串的方法？当然有！那就是<u>一边遍历，一边检查是否为回文串</u>。

* **减少循环次数**：在构建临时字符串时，可以直接检查字符，而不必将所有字符放入`temp`中，直接在比较时处理。

* **使用两个指针**：在同一个循环中构建并检查是否为回文，避免多次遍历字符串。

```java
class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            // 找到下一个有效字符
            while (left < right && !isValid(s.charAt(left))) {
                left++;
            }
            while (left < right && !isValid(s.charAt(right))) {
                right--;
            }

            // 比较字符
            if (toLowerCase(s.charAt(left)) != toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isValid(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9');
    }

    private char toLowerCase(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            return (char) (ch + 32);
        }
        return ch;
    }
}

```

如果有性能更高的方法，欢迎大家一起讨论呀！今日任务完成。
