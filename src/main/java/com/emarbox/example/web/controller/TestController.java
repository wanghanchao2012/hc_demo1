package com.emarbox.example.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.emarbox.example.web.domain.UserInfo;

@Controller
@RequestMapping(value = "test")
public class TestController {
	@ModelAttribute("myUser")
	public UserInfo populateModel() throws Exception {
		return new UserInfo(null, "xxxxxxx", null);
	}

	@RequestMapping(value = "list")
	public String list(UserInfo user) {
		user.setAmount(1000000D);
		return "/demo";
	}
}
