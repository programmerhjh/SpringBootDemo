package prv.hjh.boot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import prv.hjh.boot.domain.User;

/**
 * @author 洪家豪
 *         Created by HJH on 2017/10/24.
 */
public interface UserRepository extends JpaRepository<User,Integer>{
}
