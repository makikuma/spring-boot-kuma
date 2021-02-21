package com.kuma.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.kuma.domain.api.user.User;
import com.kuma.domain.api.user.UserService;

@Controller
public class UserController {
	
	@Reference
	private UserService userService;
	
	@RequestMapping("/user/list")
    @ResponseBody
	public List<User> getUserList(){
		return userService.getUserList();
	}
	
	@RequestMapping("/user/insert")
    @ResponseBody
	public boolean insertUser(User user){
		return userService.insertUser(user);
	}

}
