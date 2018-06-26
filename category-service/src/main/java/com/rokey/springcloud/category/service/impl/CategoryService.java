package com.rokey.springcloud.category.service.impl;

import com.rokey.springcloud.category.dao.CategoryRepository;
import com.rokey.springcloud.category.model.Category;
import com.rokey.springcloud.category.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chenyuejun
 * @date 2018-06-19 上午9:18
 **/
@Service
public class CategoryService implements ICategoryService {

  @Autowired
  private CategoryRepository categoryRepository;

  @Override
  public Category getRoot() {

    return categoryRepository.findRoot();
  }
}