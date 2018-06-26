package com.rokey.springcloud.auth.authorizeServer;

import com.rokey.springcloud.auth.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * @author chenyuejun
 * @date 2018-06-20 上午10:00
 **/
@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter {

  private TokenStore tokenStore = new InMemoryTokenStore();

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private CustomUserDetailService customUserDetailService;

  @Override
  public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {

    security.tokenKeyAccess("permitAll()")
        .checkTokenAccess("isAuthenticated()");
  }


  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

    // TODO persist clients details

    clients.inMemory()
        .withClient("browser")
        .authorizedGrantTypes("refresh_token", "password")
        .scopes("ui")
      .and()
        .withClient("category-service")
        .secret("secret")
        .authorizedGrantTypes("client_credentials", "refresh_token")
        .scopes("server")
      .and()
        .withClient("member-service")
        .secret("secret")
        .authorizedGrantTypes("client_credentials", "refresh_token")
        .scopes("server")
      .and()
        .withClient("product-service")
        .secret("secret")
        .authorizedGrantTypes("client_credentials", "refresh_token")
        .scopes("server");

  }


  @Override
  public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

    endpoints
        .tokenStore(tokenStore)
        .userDetailsService(customUserDetailService)
        .authenticationManager(authenticationManager);
  }


}