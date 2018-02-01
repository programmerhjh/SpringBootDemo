import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import prv.hjh.boot.Application;
import prv.hjh.boot.dao.UserDao;
import prv.hjh.boot.domain.UserEntity;

/**
 * 测试SpringBoot Mongo的集成
 * @author 洪家豪
 * Created by acer on 2018/1/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class SpringBootMongoTests {

    @Autowired
    private UserDao userDao;

    /**
     * 保存一个User实体，默认使用的集合为POJO类的类名，如果在数据库没有该集合先创建在插入保存
     * @throws Exception
     */
    @Test
    public void testSaveUser() throws Exception {
        UserEntity user=new UserEntity();
        user.setId(21);
        user.setName("小明");
        user.setPassword("fffooo123");
        userDao.saveUser(user);
    }

    @Test
    public void findUserByUserName(){
        UserEntity user= userDao.findUserByUserName("小明");
        System.out.println("user is "+user);
    }

    @Test
    public void updateUser(){
        UserEntity user=new UserEntity();
        user.setId(2);
        user.setName("天空");
        user.setPassword("fffxxxx");
        userDao.updateUser(user);
    }

    @Test
    public void deleteUserById(){
        userDao.deleteUserById(1);
    }
}
