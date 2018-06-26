package com.rokey.springcloud.auth.service.impl;

import com.rokey.springcloud.auth.model.User;
import com.rokey.springcloud.auth.repository.UserRepository;
import com.rokey.springcloud.auth.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chenyuejun
 * @date 2018-06-20 下午12:24
 **/
@Service
public class UserService implements IUserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public void createUser(User user) {

    userRepository.save(user);
  }
}