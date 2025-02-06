# Java Message Service（JMS）

- J2EE提供的消息通信机制

- 高性能，高可靠性

- C/S架构

  >  严格来说，JMS（Java Message Service）并不完全属于传统的**C/S（Client/Server）架构**。虽然它涉及客户端和消息服务器的通信，但 JMS 是一种基于消息的通信模式，属于**消息中间件架构**。这种架构更接近于**松散耦合**的系统架构，通常应用于**分布式系统**，其模式与传统的 C/S 模式

- 包名：`javax.jms`

Java Message Service（JMS）是一种 Java API，用于在分布式应用程序中实现异步、松耦合的消息传递。它允许不同系统或模块通过消息传递的方式进行通信，而不需要直接相互依赖。在企业级应用中，JMS 常用于集成各类后台服务，如订单处理、日志记录、通知系统等。JMS 是 Java EE 的一部分，主要用于实现消息队列和发布/订阅模式的通信。

### JMS 核心概念
1. **消息提供者（Message Provider）**：消息提供者是 JMS 的实现，例如 ActiveMQ、RabbitMQ、IBM MQ 等。服务器软件有名的有Kafka、RocketMQ、和上面提到的这些。
2. **消息发送者（Message Producer）**：消息发送者创建并发送消息到指定的目标（Queue 或 Topic）。
3. **消息消费者（Message Consumer）**：消息消费者监听并接收来自指定目标的消息。

### JMS 模式
JMS 提供了两种主要的消息通信模型：

1. **点对点（Point-to-Point）模型**
   - 消息通过**队列（Queue）**传递，发送者将消息发送到队列，消费者从队列中接收消息。
   - 每条消息只能被一个消费者消费，因此适合一对一的通信。
   - 例子：订单系统将新订单发送到订单处理队列，队列中的处理服务负责消费这些订单并执行处理。

2. **发布/订阅（Publish/Subscribe）模型**
   - 消息通过**主题（Topic）**传递，发布者将消息发布到主题，多个订阅者可以订阅该主题并同时接收到消息。
   - 适合一对多的通信，每个订阅者都会收到发布者的每条消息。
   - 例子：新闻发布系统将消息发布到主题，多个订阅者（如手机、网页等）可以同时接收该消息。

### JMS 消息结构
JMS 消息包含三部分：
1. **消息头**：包含消息的标识信息，例如时间戳、唯一 ID、消息优先级等。
2. **消息属性**：允许发送者自定义消息属性，便于过滤和分类。
3. **消息主体**：实际的数据负载，有以下几种类型：
   - **TextMessage**：包含字符串内容，适合 JSON、XML 数据。
   - **ObjectMessage**：包含序列化对象。
   - **BytesMessage**：包含字节流，适合二进制数据。
   - **MapMessage**：包含键值对的映射。
   - **StreamMessage**：包含原始值序列。

### JMS 的基本使用步骤
1. **连接工厂**：通过 JNDI 查找获取 `ConnectionFactory`。
2. **连接**：通过 `ConnectionFactory` 创建 `Connection`。
3. **会话**：通过 `Connection` 创建 `Session`，会话负责发送和接收消息。
4. **目标**：创建消息目标（Queue 或 Topic）。
5. **生产者和消费者**：通过 `Session` 创建消息的生产者（Producer）或消费者（Consumer）。
6. **消息处理**：生产者创建并发送消息，消费者监听并接收消息。

### JMS 编程示例

**发送消息：**
```java
ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
Connection connection = factory.createConnection();
Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
Destination queue = session.createQueue("OrderQueue");
MessageProducer producer = session.createProducer(queue);

TextMessage message = session.createTextMessage("New Order Received");
producer.send(message);

producer.close();
session.close();
connection.close();
```

**接收消息：**
```java
ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
Connection connection = factory.createConnection();
Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
Destination queue = session.createQueue("OrderQueue");
MessageConsumer consumer = session.createConsumer(queue);

connection.start();

consumer.setMessageListener(new MessageListener() {
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            System.out.println("Received: " + textMessage.getText());
        }
    }
});

// 保持连接
Thread.sleep(10000);

consumer.close();
session.close();
connection.close();
```

### JMS 的优势
- **松耦合**：系统模块之间通过消息通信，实现模块解耦。
- **异步处理**：消息的发送和接收不必同步，适合分布式和异步处理任务。
- **可靠性**：支持消息持久化，保证消息传输的可靠性，即使消息代理或消费者出现故障，消息不会丢失。

### JMS 的应用场景
- **订单处理**：订单模块将订单信息发往队列，后台服务消费订单并处理。
- **日志和事件记录**：各模块将日志发送到日志队列，由专用服务消费并存储。
- **通知服务**：当某个事件触发时，发布者将通知发布到主题，多个订阅者可接收通知并执行相应动作。

JMS 在需要分布式、高并发和异步通信的场景中广泛使用，尤其适合分布式系统的消息传递和事件驱动架构。