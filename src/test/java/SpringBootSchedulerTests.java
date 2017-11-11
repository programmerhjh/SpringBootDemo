import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import prv.hjh.boot.Application;

/**
 * @author 洪家豪
 *         Created by acer on 2017/11/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class SpringBootSchedulerTests {

    /*
        运行结果：

        现在时间：15:06:55
        this is scheduler task running  0
        现在时间：15:07:01
        this is scheduler task running  1
        现在时间：15:07:07
        this is scheduler task running  2
        现在时间：15:07:13
        this is scheduler task running  3
        现在时间：15:07:19
    */
    /**
     * 通过线程休眠来
     * 测试 SpringBoot 对定时任务的集成
     */
    @Test
    public void testSchedulerTask(){
        try {
            Thread.sleep(130000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
