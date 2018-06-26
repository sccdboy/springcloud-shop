package com.rokey.springcloud.productservice.repository;

import com.rokey.springcloud.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author chenyuejun
 * @date 2018-06-20 下午5:09
 **/
public interface ProductRepository extends JpaRepository<Product, Long> {


}