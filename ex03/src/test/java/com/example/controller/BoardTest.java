package com.example.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.domain.BoardVO;
import com.example.mapper.BoardMapper;
import com.example.mapper.MysqlMapper;

@RunWith(SpringJUnit4ClassRunner.class) //먼저 SpringJUnit4ClassRunner.class import한다.
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})

public class BoardTest {
	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void list() { 
		//mapper.totalCount(); 
	}
	
//	@Test
	public void read(){
		mapper.read(8);
	}
	
	@Test
	public void insert(){
		BoardVO vo=new BoardVO();
		vo.setTitle("새로운 글을 추가합니다.");
		vo.setContent("새로운 내용입니다.");
		vo.setWriter("user02");
		mapper.insert(vo);
		//mapper.list();
	}
	@Test
	public void update(){
		BoardVO vo=new BoardVO();
		vo.setTitle("새로운 글을 추가합니다.");
		vo.setContent("수정된 내용입니다.");
		vo.setWriter("user02");
		vo.setBno(9);
		mapper.update(vo);
		mapper.read(9);
	}
	
	@Test
	public void delete(){
		mapper.delete(8);
	//	mapper.list();
	}
	
}
