# lambda表达式

## lambda表达式概念

当然可以。Lambda表达式是一种匿名函数的表示法，它允许你定义一个没有名字的函数，并且可以在需要函数对象的地方使用。Lambda表达式通常用于简化代码，使得函数式编程更加方便。

在Python中，lambda表达式的语法非常简洁，它的基本形式如下：

```python
lambda 参数列表: 表达式
```

这里的“参数列表”是lambda函数的输入参数，而“表达式”则是函数的返回值。Lambda函数只能包含一个表达式，不能包含复杂的语句块。

举个例子，假设我们有一个简单的函数，用于计算两个数的和：

```python
def add(x, y):
    return x + y
```

使用lambda表达式，我们可以将这个函数简化为：

```python
add = lambda x, y: x + y
```

这样，`add`就变成了一个lambda函数，你可以像调用普通函数一样调用它：

```python
result = add(3, 5)
print(result)  # 输出 8
```

Lambda表达式常用于需要短小函数的地方，比如作为参数传递给高阶函数（如`map()`、`filter()`和`sorted()`等）。例如，对一个列表进行排序时，可以使用lambda表达式来指定排序的关键字：

```python
points = [(1, 2), (3, 4), (5, 1)]
points_sorted = sorted(points, key=lambda point: point[1])
print(points_sorted)  # 输出 [(5, 1), (1, 2), (3, 4)]
```

在这个例子中，lambda表达式`lambda point: point[1]`定义了一个函数，它接受一个点（一个二元组）并返回其第二个元素（y坐标），`sorted()`函数使用这个lambda函数作为排序的关键字。

## Java中的lambda表达式

当然可以。Java的Lambda表达式是Java 8引入的一项重要特性，它提供了一种清晰简洁的方式来表示一个方法的接口（即函数式接口）的实例。Lambda表达式主要用于简化匿名内部类的写法，使得代码更加简洁和易读。

Lambda表达式的基本语法如下：

```java
(parameters) -> expression
```

或者

```java
(parameters) -> { statements; }
```

其中，`parameters`是参数列表，`->`是Lambda操作符，`expression`是单一的表达式，而`{ statements; }`是包含多条语句的代码块。

Lambda表达式有几个重要的特性：

1. **可选类型声明**：不需要声明参数的类型，编译器可以统一识别参数类型。
2. **可选的参数圆括号**：如果只有一个参数，可以省略圆括号。
3. **可选的大括号**：如果主体只包含一个语句，可以省略大括号。
4. **可选的返回关键字**：如果主体只有一个表达式返回值，编译器会自动返回这个值，不需要使用`return`关键字。

下面是一个简单的Lambda表达式示例，它定义了一个接口`GreetingService`，并使用Lambda表达式实现了这个接口：

```java
interface GreetingService {
    void sayMessage(String message);
}

public class LambdaExample {
    public static void main(String args[]) {
        // 使用Lambda表达式实现GreetingService接口
        GreetingService greetService1 = message -> System.out.println("Hello " + message);
        greetService1.sayMessage("World");
    }
}
```

在这个例子中，`message -> System.out.println("Hello " + message)`就是一个Lambda表达式，它实现了`GreetingService`接口的`sayMessage`方法。

Lambda表达式极大地简化了Java代码，尤其是在使用集合、流（Streams）和进行函数式编程时。它们使得代码更加简洁，同时也提高了代码的可读性和维护性。

## 苍穹外卖实例

让我们详细分析一下这段代码：

具体来说，`map(x -> { ... })`这部分就是一个lambda表达式。它定义了一个匿名函数，这个函数接受一个参数`x`（在这里`x`代表`orderDetailList`中的每一个元素），并返回一个新的`ShoppingCart`对象。

```java
List<ShoppingCart> shoppingCartList = orderDetailList.stream().map(x -> {
    ShoppingCart shoppingCart = new ShoppingCart();

    // 将原订单详情里面的菜品信息重新复制到购物车对象中
    BeanUtils.copyProperties(x, shoppingCart, "id");
    shoppingCart.setUserId(userId);
    shoppingCart.setCreateTime(LocalDateTime.now());

    return shoppingCart;
}).collect(Collectors.toList());
```

1. **`orderDetailList.stream()`**: 将`orderDetailList`转换为一个流（Stream），以便进行后续的流式操作。

2. **`.map(x -> { ... })`**: 这是使用lambda表达式的地方。`map`函数接受一个函数式接口`Function`的实例，这里用lambda表达式来实现这个接口。`x`是流中的每一个元素（即`orderDetailList`中的每一个订单详情对象），lambda表达式的主体部分（`{ ... }`）定义了如何处理每一个`x`。

3. **`ShoppingCart shoppingCart = new ShoppingCart();`**: 创建一个新的`ShoppingCart`对象。

4. **`BeanUtils.copyProperties(x, shoppingCart, "id");`**: 使用`BeanUtils.copyProperties`方法将`x`的属性复制到`shoppingCart`中，忽略`id`属性。

5. **`shoppingCart.setUserId(userId);`**: 设置`shoppingCart`的`userId`属性。

6. **`shoppingCart.setCreateTime(LocalDateTime.now());`**: 设置`shoppingCart`的`createTime`属性为当前时间。

7. **`return shoppingCart;`**: 返回新创建的`shoppingCart`对象。

8. **`.collect(Collectors.toList());`**: 将流中的元素收集到一个新的`List`中，最终得到`shoppingCartList`。

总结来说，这段代码通过lambda表达式将`orderDetailList`中的每一个订单详情对象转换为一个`ShoppingCart`对象，并将这些`ShoppingCart`对象收集到一个新的列表中。