import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import prv.hjh.boot.Application;

/**
 * @author 洪家豪
 * Created by acer on 2017/11/14.
 * 测试 SpringBoot 对Shiro的集成
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class SpringBootShiroTests {

    /**
     * 开启Application，测试Shiro权限
     */
    @Test
    public void contextLoads() {
    }
}
