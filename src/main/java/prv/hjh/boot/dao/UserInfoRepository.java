package prv.hjh.boot.dao;

import org.springframework.data.repository.CrudRepository;
import prv.hjh.boot.domain.UserInfo;

/**
 * @author 洪家豪
 * Created by acer on 2017/11/14.
 * 用户信息 DAO
 */
public interface UserInfoRepository extends CrudRepository<UserInfo,Integer>{

    /**
     * 通过用户名寻找用户
     * @param username
     * @return
     */
    UserInfo findByUsername(String username);
}
