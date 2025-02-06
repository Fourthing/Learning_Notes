# Object类:所有类的超类

在Java中每个类都是由`Object`类扩展而来的,但不需要显式地指定,如果没有明确地指出超类，就默认扩展`Object`类。

在Java中，只有基本类型（primitive types）不是对象，例如，数值、字符和布尔类型的值都不是对象。所有的数组类型，不管是对象数组还是基本类型的数组都扩展于Object类。

理所当然的，可以把任何类型的对象实例赋值给一个Object对象，也就是可以使用`Object`类型的变量引用任何类型的对象。
```java
Object obj = new Employee("Harry Hacker",35000);
```

当然，Object类型的变量只能用于作为各种值的通用持有者。要想对其中的内容进行具体的操作，还需要将对象的原始类型，并进行相应的类型转换：

```java
Employee e = (Employee) obj;
```

所以了解`Objcet`这个类以及它的一些常用的方法还是很有必要的，下面一一学习。

## Equals方法

- 作用：用于判断一个对象是否等于另一个对象。（在`Object`类中奖判断两个对象是否具有相同的引用）

- 局限：对于多数类而言这种默认判断方式无意义

  

### 重写自己的equals方法

  对于具体的类重写自己的`equals`方法，比如对于雇员对象，比较ID更有意义。

在标准Java中也含有150多个equals方法的实现，包括使用`instanceof`检测，调用`getClass`检测，抛出`ClassCastException`或者什么也不做。

下面给出编写一个完美的equals方法的建议：
1) 显式参数名称`otherObject`，稍后需要将它转换成另一个叫做other的变量。
2) 检测`this`与`otherObject`是否引用同一个对象：
 ```java
  if (this == otherObject) return true;
 ```
3) 检测`otherObject`是否为`null`，如果为`null`，返回`false`。这项检测是很必要的。
 ```java 
 if (otherObject == null) return false;
 ```
4) 比较`this`和`otherObject`是否属于同一个类。如果`equals`的意义在每个子类中有所改变，就使用`getClass`检测：
 ```java 
 if (getClass() != otherObject.getClass()) return false;
 ```
如果所有子类都具有统一的定义，就使用`instanceof`检测：

```java
if (!(otherObject instanceof ClassName)) return false;
```

5) 将`otherObject`转换为相应的类类型变量： 

```java
ClassName other = (ClassName) otherObject
```

6) 现在开始对所有需要比较的域进行比较了。使用 == 比较基本类型域，使用 equals 比较对象域。如果所有的域都匹配，就返回 true；否则返回 false。 

```java
return field1 == other.field1 
    && field2.equals(other.field2) 
    && ...;
```

如果在子类中重新定义 `equals`，就要在其中包含调用 `super.equals(other)`。

   

  - 小技巧：
    - 参数传进一个obj的话，先用`instanceof`判断一下是不是可以转换的类
    - 首先调用超类的`equals`，如果检测失败，那么对象就不可能相等；如果超类中的域相等，就需要比较子类中的实例域。
    - 对于数组类型的域，可以使用静态的`Arrays.equals`方法检测相应的数组元素是否相等
  - 注意：如果隐式和显式的参数不属于同一个类，不用`instanceof`进行检测，`equals`也会返回`false`
  - 重写应该遵循的五个原则：
    - 自反性：对于任何非空引用用 x，x.equals(x) 应该返回 true。
    - 对称性：对于任何非空引用 x 和 y，当且仅当 y.equals(x) 返回 true，x.equals(y)也应该返回 true。
    - 传递性：对于任何非空引用 x, y 和 z，如果 x.equals(y) 返回 true，y.equals(z) 返回 true，则 x.equals(z)也应该返回 true。
    - 一致性：如果 x 和 y 引用的对象没有发生变化，反复调用 x.equals(y) 应该返回同样的结果。
    - 对于任何空引用用 x，x.equals(null) 应该返回 false。
    
    

## HashCode方法

- 作用：获取对象的散列值

*hash code* 是由对象导出的一个整型值。散列码是没有规律的，两个不同的对象基本没有相同的hash code。通过调用`Object`类中定义的`hashCode`方法可以获得对象的散列值，其值为对象的存储地址。

当然这个方法也可以根据需要被重写，比如如果存在数组类型的域，那么可以使用静态的`Arrays.hashCode`方法计算一个散列码，这个散列码由数组元素的散列码组成。



## ToString方法

- 作用：返回表示对象值的字符串，默认返回的是十六进制的hashCode。

  ![image-20241030212557298](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202410302125342.png)

- 建议：为每一个自定义类中都增加`toString`方法，不仅便于调试，还便于他人使用。

这也是一个非常重要的方法，重要的原因之一是所有对象与字符串用‘+’号连接时编译器都会自动调用`toString`方法，它用于返回对象值的字符串。这也是我们说所有对象都能转换成字符串的原因。

下面是一个典型的例子。`Point`类的`toString`方法将返回下面这样的字符串：

```java
java.awt.Point(x=10,y=20)
```

绝大多数（但不是全部）的`toString`方法都遵循这样的格式：类的名字，随后是一对方括号括起来的域值。下面是`Employee`类中的`toString`方法的实现：

```java
public String toString(){
     return "Employee[name=" + name 
     + ",salary=" + salary 
     + ",hireDay=" + hireDay + "]";
}
```

实际上，还可以设计得更好一些。最好通过调用``获得类名的字符串，而不要将类名硬编码到toString方法中：

```java
public String toString(){
    //这里如果是子类调用父类的方法并且父类使用了getClass().getName()，那么子类只要调用super.toString再加上自己的特有域就可以了
     return getClass().getName()
     + "[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay + "]";
}
```



## getClass方法

- 作用：返回包含对象信息的类对象名（包含包名）。

  ![image-20241030213358632](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202410302133672.png)

> 在Java中，`native`关键字用于声明一个方法是由本地代码实现的，通常是指用其他编程语言（如C或C++）编写的代码。



## clone方法

- 作用：创建一个对象的副本。Java运行时系统会为新实例分配存储空间，并将当前的对象复制到这块存储区域中。

  ![image-20241030213717722](https://gitee.com/De1ores/csdn-picture-bed/raw/master/202410302137772.png)

## notify方法

用于并发编程，在后面学习。还要用到的方法还包括`wait`和`notifyAll`方法等等。
