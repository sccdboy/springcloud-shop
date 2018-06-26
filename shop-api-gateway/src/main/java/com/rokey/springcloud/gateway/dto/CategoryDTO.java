package com.rokey.springcloud.gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenyuejun
 * @date 2018-06-19 上午10:27
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

  private Long id;

  private String displayName;

  private String value;

  private Long level;

  private Long seq;

  private String icon;
}