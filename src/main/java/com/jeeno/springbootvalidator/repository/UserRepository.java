package com.jeeno.springbootvalidator.repository;

import com.jeeno.springbootvalidator.pojo.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Jeeno
 * @version 0.0.1
 * @date 2019/12/26 16:28
 */
@Repository
public interface UserRepository extends JpaRepository<UserDO, Long> {

    /**
     * query for user info by username
     * @param username username
     * @return UserDO
     */
    UserDO findByUsername(String username);

}
