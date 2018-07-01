package com.rokey.springcloud.category;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
//@EnableFeignClients
public class CategoryServiceApplication {

  public static void main(String[] args) {

    SpringApplication.run(CategoryServiceApplication.class, args);
  }

}
