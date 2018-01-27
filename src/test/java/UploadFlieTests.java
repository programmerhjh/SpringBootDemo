import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import prv.hjh.boot.Application;

/**
 * @author 洪家豪
 * Created by acer on 2018/1/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UploadFlieTests {

    /**
     * 开启Application，测试文件上传功能
     */
    @Test
    public void contextLoads() {
    }
}
