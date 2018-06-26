package com.rokey.springcloud.auth.service.impl;

import com.rokey.springcloud.auth.model.User;
import com.rokey.springcloud.auth.repository.UserRepository;
import com.rokey.springcloud.auth.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @author chenyuejun
 * @date 2018-06-20 下午12:24
 **/
@Slf4j
@Service
public class UserService implements IUserService {

  @Autowired
  private UserRepository userRepository;

  private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

  @Override
  public void createUser(User user) {

    User existing = userRepository.findByUsername(user.getUsername());
    Assert.isNull(existing, "user already exist: " + user.getUsername());
    user.setPassword(encoder.encode(user.getPassword()));
    userRepository.save(user);
    log.info("new user has been created: {}" + user.getUsername());
  }
}