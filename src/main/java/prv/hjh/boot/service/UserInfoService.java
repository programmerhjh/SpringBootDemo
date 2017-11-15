package prv.hjh.boot.service;

import prv.hjh.boot.domain.UserInfo;

/**
 * @author 洪家豪
 *         Created by acer on 2017/11/13.
 */
public interface UserInfoService {
    /**
     * 返回一个 用户信息实体
     * @param username 用户名
     * @return
     */
    UserInfo findByUsername(String username);

}
