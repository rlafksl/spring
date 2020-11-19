package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.domain.AddVO;
import com.example.mapper.AddMapper;

@Controller
public class AddController {
	@Autowired
	AddMapper mapper;

	@RequestMapping("/list")

	public String list(Model model) {
		model.addAttribute("list", mapper.list());
		return "list";
	}

	@RequestMapping("/read")
	public String read(int ano, Model model) {
		model.addAttribute("vo", mapper.read(ano));
		return "read";
	}
	@RequestMapping("/delete")
	public String delete(int ano, Model model) {
		mapper.delete(ano);
		return "redirect:list";
	}

	@RequestMapping("/insert")
	public void insert() {
		
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertPost(AddVO vo) {
		System.out.println(vo.toString());
		mapper.insert(vo);
		return "redirect:list";

	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updatePost(AddVO vo) {
		System.out.println(vo.toString());
		mapper.update(vo);
		return "redirect:list";

	}

}
