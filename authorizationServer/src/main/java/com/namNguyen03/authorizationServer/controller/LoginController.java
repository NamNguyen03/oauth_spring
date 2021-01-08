package com.namNguyen03.authorizationServer.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {

	@GetMapping("/login")
	public String login( @RequestParam(value = "error", required = false) String error) {
	
		return "login";
	}

	
	
	
	@GetMapping("/accept")
	public ModelAndView accept(@RequestParam String token) {
		ModelAndView modelAndView = new ModelAndView("accept");
		modelAndView.addObject("token",token);
		return modelAndView;
	}
	@GetMapping("/get_profile")
	public void getProfile(HttpServletResponse response,@RequestParam String token) throws IOException{
		response.sendRedirect("http://localhost:8080/users/profile?access_token=" + token);
	}
	
	@GetMapping("/erro")
	public String erro(){
		return "erro";
	}
}