package prv.hjh.boot.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import prv.hjh.boot.domain.User;
import prv.hjh.boot.domain.UserEntity;

import java.util.List;

/**
 * @author 洪家豪
 *         Created by acer on 2017/11/6.
 */
public interface UserEntityMapper {

    /**
     * 获取所有用户
     * @return 返回一个用户列表
     */
    @Select("select * from user")
    List<UserEntity> getAll();

    /**
     * 插入一个用户
     * @param user
     */
    @Insert("INSERT INTO user(name,password,age) values(#{name},#{password},#{age}) ")
    void insertOne(UserEntity user);

    /**
     * 返回指定用户
     * @param uid 用户id
     * @return 返回一个指定用户
     */
/*
    @Result 修饰返回的结果集，关联实体类属性和数据库字段一一对应，如果实体类属性和数据库属性名保持一致，就不需要这个属性来修饰
*/
    @Results({
            @Result(property = "name",column = "name"),
            @Result(property = "age",column = "age"),
            @Result(property = "address",column = "address")
    })
    @Select("select * from user where id=#{id}")
    UserEntity getOne(Integer uid);

    /**
     * 修改一个用户
     * @param user
     */
    @Update("update user set name=#{name} where id=#{id}")
    void updateOne(UserEntity user);

    /**
     * 删除一个指定用户
     * @param uid
     */
    @Delete("delete from user where id=#{id}")
    void deleteOne(Integer uid);

}
