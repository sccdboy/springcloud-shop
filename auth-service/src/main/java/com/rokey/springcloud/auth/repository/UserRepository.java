package com.rokey.springcloud.auth.repository;

import com.rokey.springcloud.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author chenyuejun
 * @date 2018-06-20 上午10:30
 **/
public interface UserRepository extends JpaRepository<User, Long> {

  User findByUsername(String username);

}