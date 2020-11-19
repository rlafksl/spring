package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.TradeVO;
import com.example.mapper.TradeMapper;
import com.example.service.TradeService;

@RestController  //json
public class TradeController {
	@Autowired
	TradeMapper mapper;
	
	@Autowired
	TradeService service;
	
	@RequestMapping("/tradeList")  //tradeList?ano=1001
	public List<TradeVO> list(String ano){
		return mapper.list(ano);
	}
	
	@RequestMapping(value="tradeInsert", method=RequestMethod.POST)
	public void insert(TradeVO vo){
		service.insert(vo);
	}
}
