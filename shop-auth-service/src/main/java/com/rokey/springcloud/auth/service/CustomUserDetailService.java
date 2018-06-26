package com.rokey.springcloud.auth.service;

import com.rokey.springcloud.auth.model.CustomUserDetails;
import com.rokey.springcloud.auth.model.User;
import com.rokey.springcloud.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author chenyuejun
 * @date 2018-06-20 上午10:40
 **/
@Component
public class CustomUserDetailService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    User user = userRepository.findByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException(username);
    }
    return new CustomUserDetails(user);
  }
}