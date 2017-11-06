import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import prv.hjh.boot.Application;
import prv.hjh.boot.domain.UserEntity;
import prv.hjh.boot.mapper.UserEntityMapper;

import java.util.List;

/**
 * 测试 SpringBoot 对 Mybatis 的集成,只测试了 Retrieve 操作
 * @author 洪家豪
 * Created by acer on 2017/11/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UserMapperMybatisTests {

    private Logger logger = LoggerFactory.getLogger(UserMapperMybatisTests.class);

    @Autowired
    private UserEntityMapper userEntityMapper;

    /**
     * 测试查询功能
     */
    @Test
    public void testGetAllUsers(){
        List<UserEntity> entities = userEntityMapper.getAll();
        for (UserEntity user: entities
             ) {
            logger.info("打印用户：" + user.toString());
        }
    }

    /**
     * 测试 Mybatis 结果集的注解功能
     */
    @Test
    public void testGetUserById(){
        UserEntity entity = userEntityMapper.getOne(68);
        logger.info("打印用户的在Mapper接口中指定的结果集：" + entity.toString());
    }


}
