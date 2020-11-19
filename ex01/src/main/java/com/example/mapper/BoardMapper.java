package com.example.mapper;

import java.util.List;

import com.example.domain.BoardVO;

public interface BoardMapper {
	//목록 출력
	public List<BoardVO> list();
	
	public void insert(BoardVO vo);
	public BoardVO read(int bno);
	public void update(BoardVO vo);
	public void delete(int bno);
	

}
