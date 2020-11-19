package com.example.mapper_oracle;

import com.example.domain.Criteria;

import java.util.List;

import com.example.domain.BoardVO;

public interface BoardMapper {
			public List<BoardVO>list(Criteria cri); //검색하고 페이징
			public int totalCount(Criteria cri);
			public BoardVO read(int bno);
			
}
