import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import prv.hjh.boot.Application;
import prv.hjh.boot.rabbitmqrole.HelloReceiver;
import prv.hjh.boot.rabbitmqrole.HelloSender;

/**
 * @author 洪家豪
 * Created by acer on 2017/11/9.
 * 测试 SpringBoot 对 RabbitMQ 的集成
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class RabbitMQTests {

    @Autowired
    private HelloSender helloSender;

    @Autowired
    private HelloReceiver helloReceiver;

    /**
     * 发布信息
     */
    @Test
    public void senderSendHello(){
        helloSender.send();
        /*try {
            senderSendHello();
        }catch (Exception e){
            senderSendHello();
        }finally {
            senderSendHello();
        }*/
    }

    /**
     * 接受信息
     * @throws InterruptedException
     */
    @Test
    public void receiverReceiveHello() throws InterruptedException {
        helloReceiver.process("hello");
        Thread.sleep(1);
        /*try {
            receiverReceiveHello();
        }catch (Exception e){
            receiverReceiveHello();
        }finally {
            receiverReceiveHello();
        }*/
    }

}
