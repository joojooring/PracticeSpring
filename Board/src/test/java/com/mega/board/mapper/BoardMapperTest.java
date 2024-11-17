package com.mega.board.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mega.board.bean.BoardVO;
import com.mega.board.util.Color;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class BoardMapperTest {

	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		// 람다식 
		mapper.getList()
				  .forEach(board -> log.info(Color.YELLOW+board+Color.END));
	}
	
	
	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("테스트 제목");
		board.setContent("테스트 내용");
		board.setWriter("테스트 작성자");
		
		int result = mapper.insert(board);
		
		log.info(Color.GREEN+result+"건 insert 성공"+Color.END);
		board.setTitle("select를 먼저 한 후 insert하는 [selectKey]");
		result = mapper.insertSelectKey(board);
		log.info(Color.BLUE+result+"건 insert 성공"+Color.END);
	}
	
	
	@Test
	public void testRead() {
		 BoardVO board = mapper.read(2L);
		 log.info(Color.GREEN + board  +Color.END); // board.toString() 
		//log.info(Color.GREEN +   mapper.read(2L).getBno() +"번 글 : [제목] "+ mapper.read(2L).getTitle()+" : [내용] " +mapper.read(2L).getContent() +" : [글쓴이] "+mapper.read(2L).getWriter() +" : [등록일] "+mapper.read(2L).getRegdate() +" : [수정일] "+mapper.read(2L).getUpdatedate()  + Color.END );
	}

	@Test
	public void testDelete() {
		Long bno = 16L;
		int result = mapper.delete(bno);
		
		if(result == 0) {
			log.info(Color.RED+"delete할 대상이 없습니다."+Color.END);
		}else {
			log.info(Color.BLUE+result+"건 delete 성공"+Color.END);
		}
		
		
	}
	
	@Test
	public void testUpdate() {
		Long bno = 15L;
		BoardVO board = new BoardVO();
		board.setBno(bno);
		board.setTitle("수정됨");
		board.setContent("수정된 내용");
		board.setWriter("걸리버여행기");
		
		int result = mapper.update(board);
		if(result == 0) {
			log.info(Color.RED+"update할 대상이 없습니다."+Color.END);
		}else {
			log.info(Color.BLUE+result+"건 update 성공"+Color.END);
		}
	}
	
}
