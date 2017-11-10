package prv.hjh.boot.rabbitmqrole;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author 洪家豪
 * Created by acer on 2017/11/9.
 * MQ 发送者
 */
@Component
public class HelloSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {
        String context = "test01 " + new Date();
        System.out.println("Sender : " + context);
        //把信息绑定到名称为hello的队列中
        this.rabbitTemplate.convertAndSend("test", context);
    }

}
