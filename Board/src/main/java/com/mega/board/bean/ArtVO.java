package com.mega.board.bean;

import lombok.Data;

@Data
public class ArtVO {
	String title;
	String artist;
	String desc;

	
	public void setTitle(String title) {
		System.out.println("setter 호출 되니?");
		this.title = title;
	}
	
	public String getTitle() {
		return this.title;
		//return "getter 호출 되니?";
	}
}
