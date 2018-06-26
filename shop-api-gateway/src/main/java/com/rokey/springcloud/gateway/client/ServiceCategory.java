package com.rokey.springcloud.gateway.client;

import com.rokey.springcloud.gateway.dto.CategoryDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author chenyuejun
 * @date 2018-06-26 下午5:32
 **/
@FeignClient(value = "category-service")
public interface ServiceCategory {

  @RequestMapping(value = "/root", method = RequestMethod.GET)
  CategoryDTO getCategoryRoot();
}