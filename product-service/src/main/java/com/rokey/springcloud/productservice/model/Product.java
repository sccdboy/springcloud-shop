package com.rokey.springcloud.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author chenyuejun
 * @date 2018-06-20 下午4:33
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
@Entity
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "sn")
  private String sn;

  @Column(name = "name")
  private String name;

  @Column(name = "full_name")
  private String fullName;

  @Column(name = "price")
  private Double price;

  @Column(name = "cost")
  private Double cost;

  @Column(name = "image")
  private String image;

  @Column(name = "unit")
  private Long unit;

  @Column(name = "weight")
  private Long weight;

  @Column(name = "stock")
  private Long stock;

  @Column(name = "category_id")
  private Long categoryId;

  /**
   * 是否上架
   */
  @Column(name = "is_marketable")
  private boolean marketable;

  @Column(name = "delete_flag")
  private boolean deleteflag;

}