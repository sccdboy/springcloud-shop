package com.rokey.springcloud.gateway.client;

import com.rokey.springcloud.gateway.dto.CategoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author chenyuejun
 * @date 2018-06-19 上午10:23
 **/
@Component
@RequiredArgsConstructor
public class CategoryServiceClient {

  @Autowired
  private RestTemplate loadBalancedRestTemplate;

  @Autowired
  private ServiceCategory serviceCategory;

  public CategoryDTO getRootCategory() {

    return loadBalancedRestTemplate.getForObject("http://category-service/root", CategoryDTO.class);
  }
}