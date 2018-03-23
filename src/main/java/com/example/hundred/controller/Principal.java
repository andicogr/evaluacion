package com.example.hundred.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Principal {

	@RequestMapping("/")
	public String principal(Model model) {
		return "principal";
	}
}
