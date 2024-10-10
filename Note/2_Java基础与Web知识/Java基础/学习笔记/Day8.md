## Day8

### 2024年9月27日14:54:58

#### 一、custom tag

包`javax.servlet.jsp.tagext.Tag`

#### 二、维持session的三种方法

cookie、URL重写、隐藏域 （必学)

Token认证？HTTPS

`numguess=(NumGuessBean)session.getAttribute("numguess");`对session的各种操作也要会。

门面模式

有个`SimpleTag`

```java
public void doTag() throws JspException,IOException {
    getJspContext().getOut().print(new java.util.Date());
}
```

### 三、Java三大框架

Java三大框架通常指的是以下三个知名框架：

1. **Spring框架**：一个全面的企业级应用开发框架，提供了全面的基础设施支持。Spring框架的核心是IoC（控制反转）和AOP（面向切面编程），可以帮助开发者更好地管理对象的生命周期和跨越多个模块的关注点。
2. **Hibernate框架**：一个对象关系映射（ORM）框架，简化了Java应用程序与数据库之间的交互。Hibernate可以自动将Java对象映射到数据库表，使得数据的持久化变得更加简单和高效。
3. **Struts框架**：一个基于MVC（模型-视图-控制器）设计模式的Web应用框架。Struts提供了一种标准的方法来开发和管理Web应用程序，帮助开发者分离表示层、控制层和业务逻辑层。

### 四、什么是struts？

Struts 是一个基于 Java 的开源**框架**，用于构建基于 MVC（模型-视图-控制器）架构的 web 应用程序。它最初由 Apache 软件基金会开发，能够帮助开发者简化 web 应用的开发和维护。

以下是 Struts 的一些关键特点：

1. **MVC 架构**：Struts 采用 MVC 模式，将应用程序的主要逻辑分为三个部分：模型（Model）、视图（View）和控制器（Controller），提高了应用程序的组织性和可维护性。
2. **灵活的配置**：使用 XML 文件（如 `struts-config.xml`）进行配置，使得应用的结构可以灵活调整而无需改变代码。
3. **标准的约定**：遵循 Java EE 技术标准（如 JSP 和 Servlet），提供了一致性的开发体验。
4. **表单处理**：提供了表单的验证和处理功能，使得表单提交更加简单和安全。
5. **插件架构**：可以通过插件扩展功能，方便集成第三方库和框架。

Struts 的主要版本是 Struts 1 和 Struts 2，其中 Struts 2 是对 Struts 1 的重写，提供了更多的功能和更好的灵活性，例如支持注解和更好的面向对象设计。

尽管 Struts 在 Java EE 应用开发中曾经非常流行，但近年来由于其他框架（如 Spring MVC 和 JSF）的崛起，其使用逐渐减少。

Struts的工作模式主要包括以下几个方面：

1. **请求处理**：
   - 用户通过Web浏览器发送请求到服务器。
   - 请求被Servlet（通常是`ActionServlet`）接收，该Servlet是Struts框架的核心组件，负责处理所有进入的请求。
2. **前端控制器**：
   - `ActionServlet`作为前端控制器，分析请求，并根据配置文件（如`struts-config.xml`）中的规则将请求映射到相应的操作（Action）。
3. **业务逻辑**：
   - `Action`类进行具体的业务逻辑处理。每个Action类通常会执行一些操作，如访问数据库、调用服务层等。
   - 在处理过程中，Action类可以使用Form Bean来封装和验证用户输入的数据。
4. **数据模型**：
   - 在处理完请求后，Action类可能会将数据存储在业务模型对象中（通常是POJO），这些数据会被用来生成视图。
5. **视图呈现**：
   - 处理完成后，Action类会返回一个`ActionForward`对象，指示应该转向的视图（通常是JSP页面）。
   - Struts框架利用JSP和标签库（如Struts标签库）来生成动态内容，将数据展示给用户。
6. **响应用户请求**：
   - 最后，生成的JSP页面会被发送回用户的浏览器，用户看到的是处理后的结果。

#### api包名

`org.apache.struts.action`

Java类名：`ActionServlet`

后端控制器父类：`Action` 去看api文档[Action (Struts 2 Core 2.6-SNAPSHOT API) (apache.org)](https://struts.apache.org/maven/struts2-core/apidocs/index.html)

.do结尾的URL
