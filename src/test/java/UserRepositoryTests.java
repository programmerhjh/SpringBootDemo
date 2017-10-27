import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import prv.hjh.boot.Application;
import prv.hjh.boot.dao.UserRepository;
import prv.hjh.boot.domain.User;

import java.util.List;

/**
 * @author 洪家豪
 *         Created by HJH on 2017/10/24.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void getUserById(){
        User user = userRepository.findOne(2);
        System.out.println(user);
    }


    @Test
    public void getUsers(){
        List<User> users = userRepository.findAll();
        for (User user:users){
            System.out.println(user.toString()+"\n");
        }
    }

    @Test
    public void saveUser(){
        User user = new User();
        user.setUname("SpringBoot CRUD");
        user.setPhone("213214212");
        user.setUage(12);
        user.setUpassword("12312312412");
        user.setIntroduce("test01");
        userRepository.save(user);
    }

    @Test
    public void updateUser(){
        User user = userRepository.findOne(68);
        user.setPhone("1111");
        userRepository.save(user);
    }

    @Test
    public void deleteUser(){
        userRepository.delete(4);
    }


}
