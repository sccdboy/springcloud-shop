package com.rokey.springcloud.auth.service;

import com.rokey.springcloud.auth.model.User;

/**
 * @author chenyuejun
 * @date 2018-06-20 下午12:22
 **/
public interface IUserService {

  void createUser(User user);
}