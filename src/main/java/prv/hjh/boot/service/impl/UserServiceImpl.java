package prv.hjh.boot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
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
//keyGenerator 指定自定义的生成缓存中的key的方法，cacheNames 定义该事务完成后的数据在缓存中的存放位置
@CacheConfig(cacheNames = "users",keyGenerator = "getKeyGenerator")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    //@Cacheable 写进redis缓存
    @Cacheable
    public User findById(Integer uid) {
        return userRepository.findOne(uid);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void edit(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(Integer uid) {
        userRepository.delete(uid);
    }
}
