package prv.hjh.boot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import prv.hjh.boot.domain.Article;
import prv.hjh.boot.resultmap.ArticleForUser;

import java.util.List;

/**
 * @author 洪家豪
 *         Created by acer on 2017/11/3.
 */
public interface ArticleRepository extends JpaRepository<Article,Integer> {

    /**
     * 自定义查询语句
     * @param username 用户姓名
     * @return 返回一个用户对应的文章的自定义结果集列表
     */
    /*
    @Query(value = "select u.name,a.article_id,a.article,a.editor,a.date,a.content from articles a left outer join user u on a.editor=u.name and u.name = ?1",nativeQuery=true)
    List<ArticleForUser> selectUserArticle(String username);
    */
}
