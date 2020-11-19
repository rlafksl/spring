package com.example.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.domain.Criteria;
import com.example.domain.PageMaker;
import com.example.mapper.AddMapper;


@Controller
public class AddController {
	@Autowired
	AddMapper mapper;

	

	@RequestMapping(value ="/list")
	public void list(Criteria cri, Model model){
		cri.setPerPageNum(5);
		model.addAttribute("list", mapper.list(cri));
		
		PageMaker pm=new PageMaker();
		pm.setCri(cri);
		pm.setTotalCount(mapper.totalCount(cri));
		model.addAttribute("pm", pm);
		
	}
	
	
}
