package com.rokey.springcloud.productservice.service;

import com.rokey.springcloud.productservice.model.Product;

import java.util.List;

/**
 * @author chenyuejun
 * @date 2018-06-20 下午5:10
 **/
public interface IProductService {


  List<Product> getByCategory(Long categoryId);
}