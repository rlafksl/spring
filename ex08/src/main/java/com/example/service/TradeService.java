package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.TradeVO;
import com.example.mapper.TradeMapper;

@Service
public class TradeService {
	@Autowired
	TradeMapper mapper;
	
	@Transactional
	public void insert(TradeVO vo){
		//���
		String ano=vo.getAno();
		String tradeNo=vo.getTradeNo();
		vo.setType("���");
		mapper.insert(vo);
		mapper.updateBalance(ano, vo.getAmount() * -1);
		
		//�Ա�
		vo.setAno(tradeNo);
		vo.setTradeNo(ano);
		vo.setType("�Ա�");
		mapper.insert(vo);
		mapper.updateBalance(tradeNo, vo.getAmount());
	}
}
