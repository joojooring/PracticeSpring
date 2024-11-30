package com.mega.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mega.board.bean.BoardVO;

@Mapper // MyBatis와 연결
public interface BoardMapper {
	
	//게시글 목록 가져오는 함수 생성
	public List<BoardVO> getList();
	public List<BoardVO> getListWithKey(String type, String keyword);
	
	//게시글 INSERT
	public int insert(BoardVO vo);
	public int insertSelectKey(BoardVO vo);
	
	//게시글 read
	public BoardVO read(long bno);
	
	//게시글 삭제
	public int delete(long bno);
	
	//게시글 수정
	public int update(BoardVO vo);
	
}
