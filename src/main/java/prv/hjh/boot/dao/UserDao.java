package prv.hjh.boot.dao;

import prv.hjh.boot.domain.UserEntity;

/**
 * @author 洪家豪
 *         Created by acer on 2018/1/29.
 */
public interface UserDao {

    /**
     * 创建对象
     * @param user
     */
    void saveUser(UserEntity user);

    /**
     * 根据用户名查询对象
     * @param userName
     * @return
     */
    UserEntity findUserByUserName(String userName);

    /**
     * 更新对象
     * @param user
     */
    void updateUser(UserEntity user);


    /**
     * 删除对象
     * @param id
     */
    void deleteUserById(Integer id);
}
