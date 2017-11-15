package prv.hjh.boot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prv.hjh.boot.dao.UserInfoRepository;
import prv.hjh.boot.domain.UserInfo;
import prv.hjh.boot.service.UserInfoService;

/**
 * @author 洪家豪
 *         Created by acer on 2017/11/13.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo findByUsername(String username) {
        return userInfoRepository.findByUsername(username);
    }

}
