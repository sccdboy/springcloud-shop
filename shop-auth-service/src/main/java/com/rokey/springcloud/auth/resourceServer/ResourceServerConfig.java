package com.rokey.springcloud.auth.resourceServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @author chenyuejun
 * @date 2018-06-20 上午10:33
 **/
@Configuration
@EnableResourceServer
@EnableWebSecurity
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {


  @Autowired
  private UserDetailsService customUserDetailService;

  @Override
  @Bean
  public AuthenticationManager authenticationManagerBean() throws Exception {

    return super.authenticationManagerBean();
//    return super.authenticationManager();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.requestMatchers()
        .antMatchers("/login", "/oauth/authorize")
        .and()
        .authorizeRequests()
        .anyRequest()
        .authenticated()
        .and()
        .formLogin()
        .permitAll()
        .and()
        .csrf().disable();
    /*http
        .authorizeRequests().anyRequest().authenticated()
        .and()
        .csrf().disable();*/
  }


  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    auth
        .userDetailsService(customUserDetailService)
        .passwordEncoder(new BCryptPasswordEncoder());
  }
}