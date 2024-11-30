package com.mega.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mega.board.bean.BoardDAO;
import com.mega.board.bean.BoardVO;
import com.mega.board.util.Color;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/board/")
@Slf4j
public class BoardController {

	@Autowired
	private BoardDAO dao;


	@GetMapping("list")
	public void list(Model model, String type, String keyword) {
		log.info("-----------------------------");
		log.info(Color.BLUE+"[BoardController] list called"+keyword+Color.END);
		log.info("-----------------------------");
		
		// 람다식 외우자
		//dao.getList().forEach(board -> log.info(board.toString()));
//		model.addAttribute("list",dao.getList());
		
		if(keyword == null) {
			dao.getList().forEach(board -> log.info(board.toString()));
			model.addAttribute("list", dao.getList());
		} else {
			model.addAttribute("list", dao.getListWithKey(type, keyword));
		}
		
		
	}
	
	@GetMapping("write")
	public void write() {
		
	}
	
//	@PostMapping("write")
//	// 글을 쓰고, 리스트 화면으로 이동하십시오.
//	public RedirectView register(BoardVO board) {
//		if(board != null) {
//		dao.register(board);
//		}
//		return new RedirectView("list");
//	}
	
	
	// String을 쓰면 return에 redirect:를 써야되지만
	// RedirectView 를 쓰면 return에 RedirectView("페이지명") 쓰면 됨
	@PostMapping("write")
	public String register(BoardVO board, RedirectAttributes rttr) {
		if(board !=null) {
		log.info("Register"+board);
		dao.register(board);
		log.info("Register"+board);
		
		rttr.addFlashAttribute("msg", board.getBno() +"번 글이 등록되었습니다.");
		}
		return "redirect:/board/list";
	}
	
}
