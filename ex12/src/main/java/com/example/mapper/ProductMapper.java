package com.example.mapper;

import java.util.List;

import com.example.domain.Criteria;
import com.example.domain.ProductVO;

public interface ProductMapper {
		public void insert(ProductVO vo);
		public List<ProductVO> list(Criteria cri);
		public int totalCount(Criteria cri);
		public void insertImage(String image);
		public ProductVO read(int pcode);
		public List<String> getImage(int pcode);
		
}

	
