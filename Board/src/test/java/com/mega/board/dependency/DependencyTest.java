package com.mega.board.dependency;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mega.board.util.Color;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class DependencyTest {
	
	
	@Autowired
	Coding coding;
	
	@Autowired
	Color color;
	
	// 모든 테스트시 한번만 될건 beforeall
	@BeforeAll 
	public static void initTest() {
		log.info(Color.BOLD+"테스트 시작[첫번째]"+Color.END);
	}
	
	// 모든 테스트 마다 계속 나와야될 건 beforeEach
	@BeforeEach
	public void initTest2() {
		log.info(Color.BOLD+"테스트 시작[두번째]"+Color.END);
	}
	
	@Test
	public void testSample() {
		log.info("testSample logging...");
	}
	
	@Test
	public void testSample2() {
		log.info(Color.BLUE+"testSample2 logging"+Color.END);
	}
	
	@Test
	public void testCoding() {
		
		
		log.info("" + coding.toString());
	}
}
