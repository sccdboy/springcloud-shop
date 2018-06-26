package com.rokey.springcloud.auth.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * @author chenyuejun
 * @date 2018-06-20 上午10:10
 **/
@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {

  public User(){}

  public User(User user) {

    this.id = user.getId();
    this.username = user.getUsername();
    this.password = user.getPassword();
    this.email = user.getEmail();
    this.mobile = user.getMobile();
    this.roles = user.getRoles();
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "username")
  private String username;

  @Column(name = "password")
  private String password;

  @Column(name = "email")
  private String email;

  @Column(name = "mobile")
  private String mobile;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name="role_id"))
  private Set<Role> roles;
}