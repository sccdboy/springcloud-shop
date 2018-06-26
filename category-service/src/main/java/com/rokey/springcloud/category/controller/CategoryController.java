package com.rokey.springcloud.category.controller;

import com.rokey.springcloud.category.model.Category;
import com.rokey.springcloud.category.service.impl.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenyuejun
 * @date 2018-06-19 上午9:35
 **/
@Controller
@Slf4j
@RestController
public class CategoryController {

  @Autowired
  private CategoryService categoryService;

  @PreAuthorize("#oauth2.hasScope('server') or #name.equals('youtube')")
  @GetMapping(value = "/root")
  public Category getRoot() {

    return categoryService.getRoot();
  }

}