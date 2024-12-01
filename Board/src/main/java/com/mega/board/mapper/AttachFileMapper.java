package com.mega.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mega.board.bean.AttachFileVO;

@Mapper
public interface AttachFileMapper {
	public void insert(AttachFileVO vo);
	public List<AttachFileVO> findByBno(Long bno);

}
