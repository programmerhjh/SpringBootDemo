package prv.hjh.boot.dao;

import org.apache.ibatis.annotations.Insert;
import org.springframework.data.jpa.repository.JpaRepository;
import prv.hjh.boot.domain.User;
import prv.hjh.boot.resultmap.ArticleForUser;

import java.util.List;

/**
 * @author 洪家豪
 *         Created by HJH on 2017/10/24.
 */
public interface UserRepository extends JpaRepository<User,Integer>{

    /**
      * 根据用户名是 参数nameCondition 开头的字串来寻找用户
      * @author 洪家豪
      * @Date 2017/11/3 14:22
      * @param nameCondition 查询字符条件
      * @return 返回一个列表的用户
      */
    List<User> findUserByUnameStartsWithOrderByUid(String nameCondition);

}
