package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.AccountVO;
import com.example.mapper.AccountMapper;

@Controller
public class AccountController {
	@Autowired
	AccountMapper mapper;
	
	@RequestMapping("/list")
	public void list(Model model){
		model.addAttribute("list", mapper.list());
	}
	
	@RequestMapping("/read")
	public void read(Model model, String ano){
		model.addAttribute("vo", mapper.read(ano));
		model.addAttribute("list", mapper.list());
	}
	
	@RequestMapping("/read.json")
	@ResponseBody
	public AccountVO read(String ano){
		return mapper.read(ano);
	}
}
