package com.mega.board.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Service // Spring에서 관리하는 Bean에 등록
@Mapper // MyBatis와 연결

//인터페이스의 특징
//본인이 함수내용을 구현하지 않고 선언만 함
public interface TimeMapper {
	
	// 1. Annotation 방식
	@Select("select sysdate() from dual")
	public String getTime();
	
	
	//2. XML 방식
	public String getTimeUsingXML();

}
