package com.rokey.springcloud.auth.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author chenyuejun
 * @date 2018-06-20 上午10:20
 **/
public class CustomUserDetails extends User implements UserDetails {

  public CustomUserDetails(User user) {

    super(user);
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {

    return getRoles();
  }

  @Override
  public String getPassword() {
    return super.getPassword();
  }

  @Override
  public String getUsername() {
    return super.getUsername();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}