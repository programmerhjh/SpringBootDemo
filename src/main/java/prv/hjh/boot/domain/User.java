package prv.hjh.boot.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author 洪家豪
 *         Created by HJH on 2017/10/24.
 */
@Entity
@Table(name = "user")
public class User implements Serializable{
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer uid;

    @Column(name = "name")
    private String uname;
    @Column(name = "password")
    private String upassword;
    @Column(name = "age")
    private Integer uage;
    @Column(name = "address")
    private String uaddress;
    @Column(name = "birth")
    private String udate;
    @Column(name = "constellation")
    private String constellation;
    @Column(name = "phone")
    private String phone;
    @Column(name = "introduce")
    private String introduce;



    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public Integer getUage() {
        return uage;
    }

    public void setUage(Integer uage) {
        this.uage = uage;
    }

    public String getUaddress() {
        return uaddress;
    }

    public void setUaddress(String uaddress) {
        this.uaddress = uaddress;
    }

    public String getUdate() {
        return udate;
    }

    public void setUdate(String udate) {
        this.udate = udate;
    }

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upassword='" + upassword + '\'' +
                ", uage=" + uage +
                ", uaddress='" + uaddress + '\'' +
                ", udate=" + udate +
                ", constellation='" + constellation + '\'' +
                ", phone='" + phone + '\'' +
                ", introduce='" + introduce + '\'' +
                '}';
    }
}
