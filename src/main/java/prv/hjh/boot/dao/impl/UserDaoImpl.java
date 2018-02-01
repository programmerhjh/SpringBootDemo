package prv.hjh.boot.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import prv.hjh.boot.dao.UserDao;
import prv.hjh.boot.domain.UserEntity;

/**
 * @author 洪家豪
 * Created by acer on 2018/1/29.
 */
@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public void saveUser(UserEntity user) {
        mongoTemplate.save(user);
    }

    @Override
    public UserEntity findUserByUserName(String userName) {
        Query query=new Query(Criteria.where("name").is(userName));
        UserEntity user =  mongoTemplate.findOne(query , UserEntity.class);
        return user;
    }

    @Override
    public void updateUser(UserEntity user) {
        Query query=new Query(Criteria.where("id").is(user.getId()));
        Update update= new Update().set("name", user.getName()).set("password", user.getPassword());
        //更新查询返回结果集的第一条
        mongoTemplate.updateFirst(query,update,UserEntity.class);
        //更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query,update,UserEntity.class);
    }

    @Override
    public void deleteUserById(Integer id) {
        Query query=new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query,UserEntity.class);
    }
}
