package prv.hjh.boot.service;

import prv.hjh.boot.domain.User;

import java.util.List;

/**
 * @author 洪家豪
 *         Created by HJH on 2017/10/24.
 */
public interface UserService {

    /**
     * 通过用户ID查询
     * @author 洪家豪
     * @Date 2017/10/25 16:52
     * @param uid  用户ID
     * @return 用户实体
     */
    User findById(Integer uid);

    /**
     * 查询所有用户
     * @author 洪家豪
     * @Date 2017/10/25 16:54
     * @return 返回User列表
     */
    List<User> findAll();

    /**
     * 保存用户信息
     * @param user
     */
    void save(User user);

    /**
     * 修改用户信息
     * @param user
     */
    void edit(User user);

    /**
     * 删除用户
     * @param uid
     */
    void delete(Integer uid);
}
