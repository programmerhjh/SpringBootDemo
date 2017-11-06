package prv.hjh.boot.domain;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 用于 JPA 的实体类
 * @author 洪家豪
 * Created by acer on 2017/11/3.
 */
@Entity
@Table(name = "articles")
public class Article implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "article_id")
    private Integer aid;
    private String article;
    private String editor;
    private Date date;
    private String content;

    @OneToOne(targetEntity = User.class)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Article() {
    }

    public Article(String article, String editor, Date date, String content) {
        this.article = article;
        this.editor = editor;
        this.date = date;
        this.content = content;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Article{" +
                "aid=" + aid +
                ", article='" + article + '\'' +
                ", editor='" + editor + '\'' +
                ", date=" + date +
                ", content='" + content + '\'' +
                '}';
    }
}
