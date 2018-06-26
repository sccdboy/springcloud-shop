package com.rokey.springcloud.category.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

/**
 * @author chenyuejun
 * @date 2018-06-16 下午1:40
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "category")
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String displayName;

  @Column(nullable = false, unique = true)
  private String value;

  /**
   * 层级
   */
  private Long level;

  /**
   * 同一层级顺序
   */
  private Long seq;

  private String icon;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "parent_id")
  private Category parent;

  @OneToMany(mappedBy = "parent")
  @Fetch(FetchMode.SUBSELECT)
  @OrderBy("seq")
  private List<Category> children;
}