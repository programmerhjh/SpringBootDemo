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
import prv.hjh.boot.service.UserService;


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
    private UserService userService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Test
    public void test() {
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.set("name","hjh");
        String name = operations.get("name");
        logger.info("取出的name为" +
                ""+name);
    }

    @Test
    public void testUser() {
        ValueOperations<Object, Object> operations = redisTemplate.opsForValue();
        User user = new User("hjh","123",12,"jy","2017-11-02","天秤座","123465789","nothing");
        operations.set("prv.user",user);
        logger.info("向redis存入对象");
        logger.info("向redis取出对象" + operations.get("prv.user").toString());
    }


    /**
     * @Cacheable 应用到读取数据的方法上，先从缓存中读取，如果没有再从DB获取数据，然后把数据添加到缓存中,unless 表示条件表达式成立的话不放入缓存
     * @Cacheable(key = "#root.targetClass + #uid",value = "user",unless = "#result eq null")
     *
     * @CachePut 应用到写数据的方法上，如新增/修改方法，调用方法时会自动把相应的数据放入缓存
     * @CachePut(value = "user", key = "#root.targetClass + #result.username", unless = "#person eq null")
     *
     * @CacheEvict 应用到删除数据的方法上，调用方法时会从缓存中删除对应key的数据
     * @CacheEvict(value = "user", key = "#root.targetClass + #username", condition = "#result eq true")
     */
    @Test
    public void testAutoCache(){
        logger.info("这里写死了测试的用户id：6");
        User user = userService.findById(6);
        logger.info("打印user对象信息" + user.toString());
        ValueOperations<Object, Object> value = redisTemplate.opsForValue();
        Boolean hasKey = redisTemplate.hasKey("prv.hjh.user.6");
        logger.info("输出缓存中是否存在该key(存在则直接查缓存，可在控制台观看有没对应sql语句)，prv.hjh.user.6：" + hasKey);
        String string = value.get("prv.hjh.user.6").toString();
        logger.info("从redis缓存取数据并打印成日志" + string);
    }





}