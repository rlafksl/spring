package com.example.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.domain.AddVO;
import com.example.mapper.AddMapper;
import com.example.mapper.MysqlMapper;

@RunWith(SpringJUnit4ClassRunner.class) //먼저 SpringJUnit4ClassRunner.class import한다.
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})

public class AddTest {
	@Autowired
	private AddMapper mapper;
	
	@Test
	public void list(){
		mapper.list();
		
	}
	
	@Test
	public void insert(){
		AddVO vo=new AddVO();
		vo.setName("김라니");
		vo.setTel("010-0000-0000");
		vo.setAddr("인천 연수구");
		mapper.insert(vo);
	}
	
	@Test
	public void read(){
		mapper.read(3);
	}
	
	@Test
	public void delete(){
		mapper.delete(6);
	}
	
	
	
	
	
	
	
	
	
	
}
