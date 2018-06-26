package com.rokey.springcloud.gateway.controller;

import com.rokey.springcloud.gateway.client.CategoryServiceClient;
import com.rokey.springcloud.gateway.client.ServiceCategory;
import com.rokey.springcloud.gateway.dto.CategoryDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenyuejun
 * @date 2018-06-19 上午10:33
 **/
@RestController
@Slf4j
@RequiredArgsConstructor
public class ShopGatewayController {

  @Autowired
  private ServiceCategory serviceCategory;

  @GetMapping("category/root")
  public CategoryDTO getCategoryRoot() {

    CategoryDTO rootCategory = serviceCategory.getCategoryRoot();
    return rootCategory;
  }

  @GetMapping("hello")
  public String helloGateway() {

    return "hello gateway";
  }
}