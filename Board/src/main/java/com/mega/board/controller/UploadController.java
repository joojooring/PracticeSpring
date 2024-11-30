package com.mega.board.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mega.board.bean.AttachFileVO;

import lombok.extern.slf4j.Slf4j;

@Controller // @RestController 이게 responsebody로 html로 안가고 데이터로 감
@Slf4j
@RequestMapping("/upload/")
public class UploadController {
	@GetMapping("uploadForm")
	public void uploadForm() {
		log.info("[UploadController] uploadForm() called");
	}
	
	@PostMapping("uploadFormAction")
	public String upload(MultipartFile[] uploadFile, Model model) {
		String uploadFolder = "C:/upload/temp";
		for(MultipartFile f: uploadFile) {
			log.info("filename : " + f.getOriginalFilename());
			log.info("file size : "+f.getSize());
			
			// 파일 생성 (빈 파일) 
			File saveFile = new File(uploadFolder, f.getOriginalFilename());
			
			// 파일 내용 채우기
			try {
				f.transferTo(saveFile);				
			} catch (Exception e){
				e.printStackTrace();
			}
		}
		return "/upload/result";
	}
	
	
	@GetMapping("uploadAjax")
	public void uploadAjax() {
		log.info("[UploadControlelr] uploadAjax() called");
	}
	
	@PostMapping(value="uploadAjaxAction", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody // 메서드 종료시 html로 가지않고 데이터로 리턴
	public List uploadAjaxPost(MultipartFile[] uploadFile,Model model) {
		log.info("[UploadController] uploadAjaxAction called");
		
//		List fileList = new ArrayList();
//		fileList.add("Hello");
		
		List<AttachFileVO> fileList = new ArrayList();
		
		String uploadFolder = "C:/upload/temp";
		String uploadFolderPath = getFolder();
		
		log.info("-------------------------------"+uploadFolderPath);
		
		
		
		//yyyy/mm/dd 경로 만들기
		File uploadPath = new File(uploadFolder, getFolder());
		
		if(uploadPath.exists()) {// 디렉토리가 존재하면
			log.info("----------------------------------------디렉토리 이미 존재");
		} else {
			uploadPath.mkdirs();
		}
		
		
		for(MultipartFile f: uploadFile) {
			log.info("filename : " + f.getOriginalFilename());
			log.info("file size : "+f.getSize());
			
			// uuid 적용
			// network 상에서 각각의 개체를 식별하기 위해 사용
			String uploadFileName = f.getOriginalFilename();
			UUID uuid = UUID.randomUUID();
			
			uploadFileName = uuid.toString()+"_"+uploadFileName;
			
			// 파일 생성 (빈 파일) 
			//File saveFile = new File(uploadFolder, f.getOriginalFilename());
			//File saveFile = new File(uploadPath, f.getOriginalFilename());
			File saveFile = new File(uploadPath, uploadFileName);
			
			// 파일 내용 채우기
			try {
				f.transferTo(saveFile);				
			} catch (Exception e){
				e.printStackTrace();
			}
			try {
				Thread.sleep(3000);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return fileList;
	}	
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		String str = sdf.format(date);
		
		return str;
	}
}
