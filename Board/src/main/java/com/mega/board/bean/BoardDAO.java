package com.mega.board.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mega.board.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Repository // 메모리에서 관리하라는건 @Component 이걸 dao에서 쓸 수 있게  하는 어노테이션이 @Repository 
@RequiredArgsConstructor
@Slf4j
public class BoardDAO {
	@Autowired
	private BoardMapper mapper;
	
	// 전체 게시글 가져오기
	public List<BoardVO> getList(){
		return mapper.getList();
	}

	public List<BoardVO> getListWithKey(String type, String keyword){
		return mapper.getListWithKey(type, keyword);
	}
	
	// 게시글 입력
	public void register(BoardVO board) {
		mapper.insertSelectKey(board);
	}

	// 게시글 읽기
	public BoardVO get(long bno) {
		return mapper.read(bno);
	}
	
	// 게시글 삭제
	public boolean remove(long bno) {
		//삭제를 성공하면 true, 실패하면 false를 리턴하도록 구현하시오.
/*
		if(mapper.delete(bno) !=0 ) {
			return true;
		} else {
			return false;
		}
*/		
		return mapper.delete(bno) == 1;
	}
	
	//게시글 수정
	public boolean modify(BoardVO board) {
		return mapper.update(board) !=0;
	}
}
