package com.rokey.springcloud.category.dao;

import com.rokey.springcloud.category.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author chenyuejun
 * @date 2018-06-16 下午1:59
 **/
public interface CategoryRepository extends JpaRepository<Category, Long> {

  @Query("SELECT category FROM Category category WHERE category.parent is null")
  Category findRoot();
}