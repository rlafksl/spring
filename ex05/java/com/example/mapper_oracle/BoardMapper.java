package com.example.mapper_oracle;

import com.example.domain.Criteria;

import java.util.List;

import com.example.domain.BoardVO;

public interface BoardMapper {
			public List<BoardVO>list(Criteria cri); //�˻��ϰ� ����¡
			public int totalCount(Criteria cri);
			public BoardVO read(int bno);
			
}
