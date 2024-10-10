## Day7 力扣2860：让所有学生保持开心的分组方法数（中等）

> 给你一个下标从 **0** 开始、长度为 `n` 的整数数组 `nums` ，其中 `n` 是班级中学生的总数。班主任希望能够在让所有学生保持开心的情况下选出一组学生：
>
> 如果能够满足下述两个条件之一，则认为第 `i` 位学生将会保持开心：
>
> - 这位学生被选中，并且被选中的学生人数 **严格大于** `nums[i]` 。
> - 这位学生没有被选中，并且被选中的学生人数 **严格小于** `nums[i]` 。
>
> 返回能够满足让所有学生保持开心的分组方法的数目。
>
> **示例 1：**
>
> ```
> 输入：nums = [1,1]
> 输出：2
> 解释：
> 有两种可行的方法：
> 班主任没有选中学生。
> 班主任选中所有学生形成一组。 
> 如果班主任仅选中一个学生来完成分组，那么两个学生都无法保持开心。因此，仅存在两种可行的方法。
> ```
>
> **示例 2：**
>
> ```
> 输入：nums = [6,0,3,3,6,7,2,7]
> 输出：3
> 解释：
> 存在三种可行的方法：
> 班主任选中下标为 1 的学生形成一组。
> 班主任选中下标为 1、2、3、6 的学生形成一组。
> 班主任选中所有学生形成一组。 
> ```
>
> **提示：**
>
> - `1 <= nums.length <= 105`
> - `0 <= nums[i] < nums.length`

#### 一、JavaEE的四个作用域

在 Java EE（特别是 Servlets 和 JSP）的上下文中，作用域（Scope）定义了对象的生命周期和可访问范围。常见的四个作用域如下：

1. **Page Scope（页面作用域）**:
   - 对象的生命周期仅限于当前 JSP 页面。每次请求都会创建一个新的对象，作用域内的对象在页面处理完请求后会被销毁。
   - 用于存储只在当前页面上使用的数据。
2. **Request Scope（请求作用域）**:
   - 对象的生命周期限于一次 HTTP 请求。对象在请求开始时创建，在请求结束后销毁。
   - 可以在转发（forward）或包含（include）操作之间共享数据，但不能在多个请求中共享。
3. **Session Scope（会话作用域）**:
   - 对象的生命周期与用户的会话相对应。在用户会话持续期间，数据可以跨多个请求和页面共享。
   - 适合存储用户的个人信息或会话状态，如登录信息、购物车内容等。
4. **Application Scope（应用作用域）**:
   - 对象的生命周期与整个应用程序的运行时间相对应，可以在整个应用程序中的所有用户会话中共享。
   - 适合存储全局共享的数据，例如应用配置、统计信息等。

##### 总结

- **Page Scope**: 限于当前 JSP 页面（一次请求）。
- **Request Scope**: 限于当前请求（可以跨页面使用）。
- **Session Scope**: 限于用户会话（多个请求和页面）。
- **Application Scope**: 限于整个应用程序（所有用户共享）。

这四个作用域为开发者提供了不同层次的数据管理能力，使得应用程序能够更有效地处理用户数据和状态。

#### 二、goGet()方法

![QQ图片20240927140637](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202409271407405.png)

`doget` 方法通常是指在 Web 开发中使用的一个 HTTP 请求方法，特别是在 Java Servlet 中。它是一个处理 HTTP GET 请求的函数，用于从客户端获取数据。在 Servlet 的上下文中，当服务器收到一个 GET 请求时，它会调用 `doGet` 方法来处理该请求。

在使用 `doGet` 方法时，开发者可以通过以下方式获取请求参数、处理业务逻辑并生成响应：

```java
protected void doGet(HttpServletRequest request, HttpServletResponse response)   
                throws ServletException, IOException {  
    // 获取请求参数  
    String param = request.getParameter("paramName");  
    
    // 处理业务逻辑  
    // ...  

    // 设置响应内容类型  
    response.setContentType("text/html");  

    // 写入响应内容  
    PrintWriter out = response.getWriter();  
    out.println("<h1>Hello, World!</h1>");  
}  
```

需要注意的是，`doGet` 方法主要用于获取数据，它在 URL 中传递参数，通常用于表单的提交和数据检索。

#### 三、MVC设计模式

MVC（Model-View-Controller）设计模式是一种常用的软件架构模式，主要用于开发用户界面。它将应用程序分为三个核心组成部分，以促进代码的组织和分离关注点：

1. **模型（Model）**：模型代表应用程序的数据和业务逻辑。它负责管理数据的获取、存储和处理，通常与数据库进行交互。模型不直接与用户界面交互，而是通过控制器进行沟通。
2. **视图（View）**：视图是用户界面的一部分，它负责显示模型的数据。视图接收来自控制器的信息，并根据这些信息更新用户界面的展示。视图应尽量只关注如何呈现数据，而不涉及如何获取或处理数据。
3. **控制器（Controller）**：控制器充当模型和视图之间的中介。当用户在视图中执行某些操作时，控制器会接收这些输入，并决定如何处理这些输入。它可能会调用模型的方法来修改数据，然后通知视图更新显示。

MVC设计模式的优点包括：

- **分离关注点**：将数据处理、用户界面和输入管理分开，使得各部分可以独立开发和维护。
- **可重用性**：由于各部分的独立性，模型和视图可以在不同的应用程序中复用。
- **易于测试**：由于结构的清晰性，单元测试和集成测试变得更加容易。

总的来说，MVC是一种强大的设计模式，广泛应用于Web开发和桌面应用程序开发。

#### 四、Context Path

**Context Path**（上下文路径）是一个在Web应用程序中使用的重要概念，主要用于标识应用程序的根URL部分。它帮助Web服务器区分不同的应用程序，让服务器知道接收到的请求应该被转发到哪个具体的Web应用。

##### 详细说明：

1. **定义**：

   - Context Path是Web应用在服务器上的部署路径，通常是URL中应用的根部分。在URL中，它的格式通常是`http://hostname:port/contextPath/resource`。这里的`contextPath`部分指的是特定Web应用的部署标识。

2. **举例**：

   - 假设你有一个Web应用部署在URL为

     ```
     http://localhost:8080/myapp
     ```

     ，那么：

     - **Context Path**是`/myapp`
     - 如果要访问该应用中的某个资源（例如/hello），完整的路径就是`http://localhost:8080/myapp/hello`。

3. **作用**：

   - **独特性**：每个应用的Context Path都是唯一的，这样可以在同一服务器上运行多个应用而不会冲突。
   - **路由请求**：帮助服务器正确路由和处理用户的请求。
   - **简化开发**：在应用程序配置（如web.xml）中，通过Context Path，可以轻松管理和映射状态。

##### 相关概念：

- **Deployment Descriptor**：在Java EE中，应用的上下文路径通常在`web.xml`文件中进行配置。
- **Web服务器**：如Apache Tomcat、Jetty等，它们都利用上下文路径来管理和运行多个Web应用。

#### 五、HttpServletRequest源码

```java
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package javax.servlet.http;

import java.io.IOException;
import java.security.Principal;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;

public interface HttpServletRequest extends ServletRequest {
    String BASIC_AUTH = "BASIC";
    String FORM_AUTH = "FORM";
    String CLIENT_CERT_AUTH = "CLIENT_CERT";
    String DIGEST_AUTH = "DIGEST";

    String getAuthType();

    Cookie[] getCookies();

    long getDateHeader(String var1);

    String getHeader(String var1);

    Enumeration<String> getHeaders(String var1);

    Enumeration<String> getHeaderNames();

    int getIntHeader(String var1);

    default HttpServletMapping getHttpServletMapping() {
        return new HttpServletMapping() {
            public String getMatchValue() {
                return "";
            }

            public String getPattern() {
                return "";
            }

            public String getServletName() {
                return "";
            }

            public MappingMatch getMappingMatch() {
                return null;
            }

            public String toString() {
                return "MappingImpl{matchValue=" + this.getMatchValue() + ", pattern=" + this.getPattern() + ", servletName=" + this.getServletName() + ", mappingMatch=" + this.getMappingMatch() + "} HttpServletRequest {" + HttpServletRequest.this.toString() + '}';
            }
        };
    }

    String getMethod();

    String getPathInfo();

    String getPathTranslated();

    default PushBuilder newPushBuilder() {
        return null;
    }

    String getContextPath();

    String getQueryString();

    String getRemoteUser();

    boolean isUserInRole(String var1);

    Principal getUserPrincipal();

    String getRequestedSessionId();

    String getRequestURI();

    StringBuffer getRequestURL();

    String getServletPath();

    HttpSession getSession(boolean var1);

    HttpSession getSession();

    String changeSessionId();

    boolean isRequestedSessionIdValid();

    boolean isRequestedSessionIdFromCookie();

    boolean isRequestedSessionIdFromURL();

    /** @deprecated */
    @Deprecated
    boolean isRequestedSessionIdFromUrl();

    boolean authenticate(HttpServletResponse var1) throws IOException, ServletException;

    void login(String var1, String var2) throws ServletException;

    void logout() throws ServletException;

    Collection<Part> getParts() throws IOException, ServletException;

    Part getPart(String var1) throws IOException, ServletException;

    <T extends HttpUpgradeHandler> T upgrade(Class<T> var1) throws IOException, ServletException;

    default Map<String, String> getTrailerFields() {
        return Collections.emptyMap();
    }

    default boolean isTrailerFieldsReady() {
        return true;
    }
}

```

#### 六、JSP的九个隐含对象

九个隐含对象通常出现在Java EE（企业版）中的Java Servlet和JSP（Java Server Pages）技术中。它们是JSP页面的隐含对象，方便开发者在页面中处理请求、响应和其他上下文信息。以下是每个隐含对象的简要说明：

1. **request**：表示对服务器的HTTP请求。可以通过这个对象获取请求参数、请求头等信息。
2. **response**：表示服务器响应客户端的HTTP响应。通过这个对象可以发送数据回客户端，如HTML、JSON等。
3. **config**：表示JSP页面的配置信息。可以获取Servlet的配置信息，例如初始化参数。
4. **application**：表示整个Web应用的上下文。可以在多个Servlet或JSP页面之间共享数据。
5. **session**：表示用户会话信息。可以存储与用户相关的属性，以维持用户的状态。
6. **out**：用于向客户端输出内容。通常用于输出HTML或文本信息。
7. **pageContext**：提供对JSP页面的上下文信息的访问，包括对其他隐含对象的访问。（必学！）
8. **page**：表示当前JSP页面本身的引用。可以用于对象的互相调用。
9. **exception**：在错误处理时使用，表示发生的异常对象。当一个页面有错误发生时，可以通过这个对象获取异常信息。

#### 七、EL表达式的11个对象

在Java EE的JSP（JavaServer Pages）中，表达式语言（EL，Expression Language）提供了一种简洁的方式来访问数据。EL表达式的上下文中通常包含以下11个隐含对象（也称为“作用域”）：

1. **pageScope**：表示当前页面的作用域。可以在当前页面内存储和访问属性。
2. **requestScope**：表示当前请求的作用域。适用于单个请求的属性存储和访问。
3. **sessionScope**：表示用户会话的作用域。可以用于在用户的会话期间存储和访问属性。
4. **applicationScope**：表示整个Web应用的作用域。适合于跨多个用户和会话共享的属性。
5. **param**：用于访问请求参数（查询字符串和表单参数）。例如，`${param.paramName}`。
6. **paramValues**：用于访问请求参数的数组，适用于多值参数的情况。比如，`${paramValues.paramName}`。
7. **header**：用于访问HTTP请求头。比如，`${header.headerName}`。
8. **headerValues**：用于访问HTTP请求头的数组，适用于多值头的情况。比如，`${headerValues.headerName}`。
9. **cookie**：用于访问请求中的cookie。比如，`${cookie.cookieName}`。
10. **initParam**：用于访问Servlet的初始化参数配置。比如，`${initParam.pramName}`。
11. **pageContext**：提供一个对JSP页面上下文的引用。通过该对象，可以访问所有其他作用域，包括这些隐含对象。

除了`pageContext`其他的都是`Map`类型的，允许以键值对的形式访问数据。

#### 八、filter和listener

在Java EE（或Jakarta EE）中，Filter（过滤器）和Listener（监听器）都是Servlet API的重要**组件**。它们用于处理请求和响应，但它们的目的和工作方式不同。以下是对二者的详细说明：

##### 1. Filter（过滤器）

**定义**：过滤器是一种在请求被发送到Servlet之前或响应从Servlet发送到客户端之前进行处理的组件。

**功能**：
- **请求预处理**：可以在请求到达Servlet之前对请求进行修改或检查，例如添加通用的请求头、参数验证、身份验证等。
- **响应后处理**：可以在响应发送回客户端之前，对响应进行修改，例如压缩响应内容或添加序列化步骤。
- **日志记录**：记录请求的详细信息。
- **性能监控**：测量请求处理所需的时间。

**使用方式**：
- 通过实现 `javax.servlet.Filter` 接口，并重写 `doFilter` 方法。
- 配置过滤器通常在 `web.xml` 文件中，或者使用注解来注册过滤器。

**例子**：
```java
import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 初始化代码
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 处理请求前的操作
        chain.doFilter(request, response); // 继续调用下一个过滤器或目标资源
        // 处理响应后的操作
    }

    @Override
    public void destroy() {
        // 清理资源
    }
}
```

##### 2. Listener（监听器）

**定义**：监听器是一种用于监听特定事件并在事件发生时做出响应的组件。

**功能**：
- **事件处理**：可以响应特定的事件，如对象的创建、销毁或状态变化。
- **生命周期管理**：如ServletContext、HttpSession和ServletRequest的生命周期管理。
- **资源管理**：当相关的资源（如读写文件、数据库连接）需要创建或释放时，添加相应的逻辑。

**使用方式**：
- 通过实现相关的事件监听接口并重写相应的方法来创建监听器。
- 配置监听器通常在 `web.xml` 中，或使用注解来注册监听器。

**类型**：
- **ServletContextListener**：监听ServletContext的生命周期事件。
- **HttpSessionListener**：监听HTTP会话的生命周期事件。
- **ServletRequestListener**：监听Servlet请求的生命周期事件。

**例子**：
```java
import javax.servlet.*;
import javax.servlet.http.*;

public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 处理上下文初始化事件
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // 处理上下文销毁事件
    }
}
```

##### 主要区别

- **适用场景**：
  - **Filter** 适用于修改请求和响应，适合于中央处理和请求链式的操作。
  - **Listener** 主要用于事件处理，适合于处理对象的生命周期和状态变化。
  
- **调用顺序**：
  - 先执行所有的过滤器，再执行目标Servlet，最后执行响应的过滤器（后处理）。
  - 监听器是基于事件触发的，不同类型的监听器在相应的事件发生时执行。

这两者都是Java EE提供的可插拔的组件，增强了Web应用的灵活性和可扩展性。
