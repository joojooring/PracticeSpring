package com.mega.board.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mega.board.util.Color;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class TimeMapperTest {
	
	@Autowired // new로 객체 안만들고 메모리에 있는거 갖다 쓸 수 있는게 autowired
	private TimeMapper mapper;
	
	@Test
	public void testGetTime() {
		log.info("---------------------------------------------------------------");
		log.info(Color.BLUE+"Annotation : "+mapper.getTime()+Color.END);
		log.info(Color.BLUE+"XML LINK: "+mapper.getTimeUsingXML()+Color.END);
		log.info("---------------------------------------------------------------");
	}
	
	
	
	
}
