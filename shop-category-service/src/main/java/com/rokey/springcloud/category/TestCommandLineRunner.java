package com.rokey.springcloud.category;

import com.rokey.springcloud.category.dao.CategoryRepository;
import com.rokey.springcloud.category.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author chenyuejun
 * @date 2018-06-19 上午10:58
 **/
@Component
public class TestCommandLineRunner implements CommandLineRunner {

  @Autowired
  private CategoryRepository categoryRepository;

  @Override
  public void run(String... args) throws Exception {

    Category root = Category.builder().level(1L).seq(1L).displayName("根菜单").value("root").icon("/root").build();
    categoryRepository.save(root);

  }
}