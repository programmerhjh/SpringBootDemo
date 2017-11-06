import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import prv.hjh.boot.Application;
import prv.hjh.boot.dao.UserRepository;
import prv.hjh.boot.domain.User;

import java.util.List;

/**
 * @author 洪家豪
 * Created by HJH on 2017/10/24.
 * 测试 Spring Boot 对JPA的支持
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UserJpaRepositoryTests {

    private Logger logger = LoggerFactory.getLogger(UserJpaRepositoryTests.class);

    @Autowired
    private UserRepository userRepository;

    /**
     * 测试根据用户id从数据库去用户
     */
    @Test
    public void testGetUserById(){
        User user = userRepository.findOne(2);
        logger.info("取出的用户信息" + user.toString());
    }


    /**
     * 测试获取所有用户
     */
    @Test
    public void testGetUsers(){
        List<User> users = userRepository.findAll();
        for (User user:users){
            logger.info("用户：" + user.toString()+"\n");
        }
    }

    /**
     * 测试插入数据
     */
    @Test
    public void testSaveUser(){
        User user = new User();
        user.setUname("SpringBoot CRUD");
        user.setPhone("213214212");
        user.setUage(12);
        user.setUpassword("12312312412");
        user.setIntroduce("test01");
        userRepository.save(user);
    }

    /**
     * 测试更改数据
     */
    @Test
    public void testUpdateUser(){
        User user = userRepository.findOne(68);
        user.setPhone("1111");
        userRepository.save(user);
    }

    /**
     * 测试删除数据
     */
    @Test
    public void testDeleteUser(){
        userRepository.delete(4);
    }


    /**
     * 测试数据分页效果
     */
    @Test
    public void testPageUser(){
        int page = 1,size = 10;
        Sort sort = new Sort(Sort.Direction.DESC,"uid");
        Pageable pageable = new PageRequest(page,size,sort);
        Page<User> users = userRepository.findAll(pageable);
        logger.info("用户列表第" + pageable.getPageNumber() + "页....数量：" + users.getSize()
                    + ",打印用户：" + users.getContent());
        //翻页
        pageable = pageable.next();
        users = userRepository.findAll(pageable);
        logger.info("用户列表第" + pageable.getPageNumber() + "页....数量：" + users.getSize()
                + ",打印用户：" + users.getContent());
    }


    /**
     * 测试Jpa的限制查询
     */
    @Test
    public void testConstraintQuery(){
        List<User> users = userRepository.findUserByUnameStartsWithOrderByUid("b");
        logger.info("循环输出用户名开头为b的用户");
        for (User user:users){
            logger.info(user.toString());
        }
    }

}
