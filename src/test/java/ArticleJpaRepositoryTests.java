import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import prv.hjh.boot.Application;
import prv.hjh.boot.dao.ArticleRepository;
import prv.hjh.boot.dao.UserRepository;

/**
 * @author 洪家豪
 * Created by HJH on 2017/10/24.
 * 测试 Spring Boot 对JPA的支持
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ArticleJpaRepositoryTests {

    private Logger logger = LoggerFactory.getLogger(ArticleJpaRepositoryTests.class);

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * 测试Jpa的多表查询
     */
    /*
    @Test
    public void testTablesQuery(){
        User user = userRepository.findOne(2);
        List<ArticleForUser> list = articleRepository.selectUserArticle(user.getUname());
        for (ArticleForUser articleForUser : list){
            logger.info("循环输出结果集：" + articleForUser.toString());
        }
    }*/




}
