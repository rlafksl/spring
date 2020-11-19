package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.domain.TradeVO;

public interface TradeMapper {
	public List<TradeVO> list(String ano);
	
	public void insert(TradeVO vo); 
	
	public void updateBalance(@Param("ano") String ano, @Param("amount") double amount);
}
