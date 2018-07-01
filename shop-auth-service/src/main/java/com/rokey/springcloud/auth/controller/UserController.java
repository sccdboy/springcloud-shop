package com.rokey.springcloud.auth.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rokey.springcloud.auth.model.User;
import com.rokey.springcloud.auth.service.IUserService;

/**
 * @author chenyuejun
 * @date 2018-06-20 下午12:26
 **/
@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private IUserService userService;

	@GetMapping(value = "/current")
	public Principal getCurrentUser(Principal principal) {

		return principal;
	}

	@PreAuthorize("#oauth2.hasScope('server')")
	@PostMapping
	public void createUser(User user) {

		userService.createUser(user);
	}

}