import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import prv.hjh.boot.Application;
import prv.hjh.boot.domain.User;


/**
 * @author 洪家豪
 * Created by HJH on 2017/10/24.
 * 测试spring boot 整合 redis
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class RedisSpringBootTests {

    private Logger logger = LoggerFactory.getLogger(RedisSpringBootTests.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String,User> redisTemplate;

    @Test
    public void test() throws Exception {
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.set("name","hjh");
        String name = operations.get("name");
        logger.info("取出的name为" +
                ""+name);
    }

    @Test
    public void testUser() throws Exception {
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        User user = new User("hjh","123",12,"jy","2017-11-02","天秤座","123465789","nothing");
        operations.set("prv.user",user);
        logger.info("向redis存入对象");
        logger.info("向redis取出对象" + operations.get("prv.user").toString());
    }
}