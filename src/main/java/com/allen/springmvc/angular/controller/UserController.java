package com.allen.springmvc.angular.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/testAngularJs")
public class UserController {
	
	@RequestMapping(value="{id}/findOne")
	public @ResponseBody Object get(@PathVariable String id){
		return null;
	}

}
