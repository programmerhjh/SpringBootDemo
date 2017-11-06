package prv.hjh.boot.domain;

import java.io.Serializable;


/**
 * 用于 Mybatis 的实体类
 * @author 洪家豪
 * Created by HJH on 2017/10/24.
 */

public class UserEntity implements Serializable{

    public UserEntity(Integer id, String name, String password, Integer age, String address, String date, String constellation, String phone, String introduce) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.address = address;
        this.date = date;
        this.constellation = constellation;
        this.phone = phone;
        this.introduce = introduce;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", date='" + date + '\'' +
                ", constellation='" + constellation + '\'' +
                ", phone='" + phone + '\'' +
                ", introduce='" + introduce + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    private Integer id;


    private String name;

    private String password;

    private Integer age;

    private String address;

    private String date;

    private String constellation;

    private String phone;

    private String introduce;


    public UserEntity() {
    }


}
