package com.mega.board.bean;

import java.util.List;

import lombok.Data;

@Data
public class BoardVO {
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private String regdate;
	private String updatedate;
	private List<AttachFileVO> attachList;
	
	// input 태그의 name에 원래는  name="bno"로 적었는데 
	// 배열로 만들다면 
	//attachList[i].fileName
	//attachList[i].uuid
	//attachList[i].uploadPath
	//attachList[i].fileType
	//방식으로 submit하면 자동으로 List에 add됨 
	// 배열은 [i]로 줌
	
	
}
