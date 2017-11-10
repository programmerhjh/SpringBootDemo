package prv.hjh.boot.rabbitmqrole;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 洪家豪
 * Created by acer on 2017/11/9.
 * MQ 信息接收者
 */
@Component
public class HelloReceiver {

    // @RabbitHandler
    /*
     注释了这个注解原因是这里有个坑
     就是加了RabbitHandler和加了绑定了containerFactory的RabbitListener注解会无限循环报一个
     No method found for class [B 的错误，导致无法监听队列

     官方文档有提到:
     如果不调试，侦听器会抛出异常，默认情况下，传输将会无限重试。您可以通过两种方式来修改该行为;设置默认队列
     属性为false
     并且将尝试重新传输。 或者，抛出一个AmqpRejectAndDontRequeueException
     发送信息应该被拒绝。这是启用重试时使用的机制以及最大的传输尝试。

     解决方法的思路：
        在@RabbitListener管道中有两个转换。
        第一个从Spring AMQP消息转换为Spring消息传递消息。
        目前没有任何方法可以改变第一个转换器，它可以处理字符串，Serializable，并将其他所有的东西都作为字节。
        第二个转换器将消息有效负载转换为方法参数类型(如果需要的话)。
        在方法级@RabbitListeners之间有一个紧密的绑定的处理程序和方法。
        使用类级别的@RabbitListeners，第一次转换的消息有效负载用于选择要调用的方法。只有到那时，转换才会尝试。
        这个机制对Java Serializable对象很好，因为在选择方法之前，有效负载已经被转换了。
        然而，在JSON中，第一个转换返回一个字节[]，因此我们没有找到匹配的@RabbitHandler。
        我们需要一种机制，这样第一个转换器就可以设置，这样负载就可以在管道中尽早转换，以选择合适的处理程序方法。
        ContentTypeDelegatingMessageConverter可能是最合适的。
        而且，在amqp - 574中，我们需要明确地记录一个@RabbitListener的转换需求，特别是使用JSON或定制转换时。

        http://www.cnblogs.com/lazio10000/p/5559999.html
    */
    /**
     * 传输信息
     */
    //监听来自队列名称为 hello 的信息
    @RabbitListener(queues = "test",containerFactory = "rabbitListenerContainerFactory")
    public void process(/*@Payload*/ String message) {
        System.out.println("Receiver  : " + message);
    }

}
