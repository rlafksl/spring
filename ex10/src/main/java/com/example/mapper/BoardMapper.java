package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.example.domain.BoardVO;
import com.example.domain.Criteria;

public interface BoardMapper {

	public List<BoardVO> list(Criteria cri);
	public int totalCount();
	public void addAttach(String fileName);
	public void insert(BoardVO vo);
	
}

