package com.example.controller;


import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.domain.Criteria;
import com.example.domain.PageMaker;

import com.example.domain.ProductVO;
import com.example.mapper.ProductMapper;
import com.example.service.ProductService;

@Controller
public class ProductController {
	@Autowired //똑같은 것들 자동으로 주입
	ProductMapper mapper;
	
	@Autowired 
	ProductService service;
	
	@Resource(name="uploadPath")
	String path;
	
	@RequestMapping("read")
	public void read(int pcode, Model model){
		model.addAttribute("vo",mapper.read(pcode));
	}
	
	
	@RequestMapping("insert")
	public void insert(){
	
	}
	
	
	@RequestMapping("list")
	   public void list(Criteria cri ,Model model){
	      PageMaker pm= new PageMaker();
	      pm.setCri(cri);
	      pm.setTotalCount(mapper.totalCount(cri));
	      model.addAttribute("pm",pm);
	      model.addAttribute("list",mapper.list(cri));
	      
	   }
	   
	@RequestMapping(value="insert", method=RequestMethod.POST)
	public String insertPost(ProductVO vo, MultipartHttpServletRequest multi)throws Exception{
		//대표이미지 하나 업로드
		MultipartFile file=multi.getFile("file");
		
		if(!file.isEmpty()){
		UUID uid=UUID.randomUUID();
        String savedName= uid.toString() +"_"+file.getOriginalFilename();
        File target= new File(path,savedName);
        FileCopyUtils.copy(file.getBytes(), target);
        vo.setImage(savedName);
	}
		//추가이미지 여러개 업로드

		List<MultipartFile> files=multi.getFiles("files");
		if(files.size()>0){
			File mkPath = new File(path +  "/attach");
			if(!mkPath.exists())  mkPath.mkdir();
		}
		ArrayList<String> images=new ArrayList<String>();
		for(MultipartFile attFile:files){
			if(!attFile.isEmpty()){
				UUID uid=UUID.randomUUID();
		        String savedName= uid.toString() +"_"+attFile.getOriginalFilename();
		        File target= new File(path +  "/attach", savedName);
		        FileCopyUtils.copy(attFile.getBytes(), target);
		        images.add(savedName);
			}
		}
		vo.setImages(images);
		service.insert(vo);
		
		return "redirect:list";
}
	//이미지출력
	@RequestMapping("display") //display?fileName=긴파일이름
	@ResponseBody
	public ResponseEntity<byte[]> display(String fileName)throws Exception{
	    ResponseEntity<byte[]> result=null;
	    //display fileName이 있는 경우
	    if(!fileName.equals("")) {
	        File file=new File(path + File.separator + fileName);
	        HttpHeaders header=new HttpHeaders();
	        header.add("Content-Type", Files.probeContentType(file.toPath()));
	        result=new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
	    }
	    return result;
	}
}
