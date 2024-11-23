package com.mega.board.bean;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class BoardDAOTest {

	@Autowired
	private BoardDAO dao;
	
	@Test
	public void testRemove() {
		long bno = 17L;
		
		if(dao.remove(bno)) {
			log.info("글번호 "+ bno + " 삭제 성공");
		} else {
			log.info("글번호 확인하세요. 삭제 실패.");
		}
	}
	
	
}
