# HTML概览

超文本标记语言（英语：HyperText Markup Language，简称：HTML）是一种用于创建网页的标准标记语言。

您可以使用 HTML 来建立自己的 WEB 站点，HTML 运行在**浏览器**上，**由浏览器来解析**。

## 后缀名

- `.html`
- `.htm`

两种方式没有区别，都可以用。

## 第一个HTML实例

```html
<!DOCTYPE html>
<html>
    <head>
    <meta charset="utf-8">
        <title>HTML处女作</title>
    </head>
    <body>
        <h1>
            我的第一个标题
        </h1>
        <p>
            我的第一个段落
        </p>
    </body>
</html>

```

### 解析

- `<!DOCTYPE html>`声明为HTML 5文档,不区分大小写

- 完整HTML页面

  - `<html>`

  - 头部元素：包含了文档的元（meta）数据

    - `<head>`
    - `<meta charset="utf-8">`
    - `<title>HTML处女作</title>`

    - `</head>`

  - 可见的页面内容：`<body>`

    - `<body>`
    - `<h1>我的第一个标题</h1>`
    - `<p>我的第一个段落</p>`
    - `</body>`

  - `</html>`


> **注：**在浏览器的页面上使用键盘上的 **F12** 按键开启调试模式，就可以看到组成标签。

## 对HTML的理解

HTML 不是一种编程语言，而是一种**标记**语言，通过各种标记来描述网页，因此HTML文档也被叫做**web页面**。HTML文档包括了HTML标签和文本内容。

## HTML元素

HTML标签(HTML tag)全名叫做**HTML标记标签**，是由尖括号包围的关键词。

关键词通常是成对出现的：

```html
<html>
    ...
</html>
```

其中两个标签又分别叫做**开始标签**和**结束标签**。也被叫做**开放标签**和**闭合标签**。

一个HTML元素包含了*开始标签*和*结束标签*以及*它们之间的文本内容*。

## Web浏览器

浏览器不仅可以作为一个客户端应用向服务器发送请求，它的功能还包括接收服务器的应答、解析并最终选择显示HTML页面。

HTML语言通过标签来告诉浏览器，页面该如何显示、显示什么内容（实际是`<body>`部分）。

![image-20241031105435487](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202410311054616.png)

### 浏览器编码问题

有时文件指定的编码模式和浏览器的解码模式不一致，就会导致乱码问题。

通过HTML中的meta元素声明字符的编码模式，浏览器就会按照这个编码格式解析HTML文档，就可以解决这个问题（中文建议UTF-8）。

其次，还需要确保文档编码和meta元素指定的编码元素是一致的，不然仍然会有乱码问题。

大部分浏览器还是ANSI或者UTF-8编码（但是360是GBK）。



## HTML编辑器

可以用专用的编辑器比如VSCode、Subline Text等等，也可以使用在线的编辑器，比如[HTML/CSS/JS 在线工具 | 菜鸟工具](https://www.jyshare.com/front-end/61/)等等能在线编译HTML、CSS、JS等语言的编辑器，比较方便，当然大的工程还是使用专用软件比较好。

