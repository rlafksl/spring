package com.example.mapper;

import java.util.List;

import com.example.domain.AccountVO;

public interface AccountMapper {
	public List<AccountVO> list();
	
	public AccountVO read(String ano);
}
