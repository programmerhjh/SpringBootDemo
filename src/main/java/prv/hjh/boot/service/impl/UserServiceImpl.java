package prv.hjh.boot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import prv.hjh.boot.dao.UserRepository;
import prv.hjh.boot.domain.User;
import prv.hjh.boot.service.UserService;

import java.util.List;

/**
 * @author 洪家豪
 *         Created by HJH on 2017/10/24.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Integer uid) {
        return userRepository.findOne(uid);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
