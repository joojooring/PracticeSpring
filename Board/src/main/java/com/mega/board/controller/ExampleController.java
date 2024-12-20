package com.mega.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mega.board.bean.ArtVO;
import com.mega.board.bean.SubjectVO;
import com.mega.board.mapper.TimeMapper;
import com.mega.board.util.Color;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/ex/*") // localhost:port/ex 하위 uri을 읽을 수 있음
public class ExampleController {
	
	@Autowired
	private TimeMapper mapper;
	
	@GetMapping("")
	public void nothing () {
		log.info("@@@ nothing method is called..");
	}

	//RequestMapping은 get, post 고를 수 있음
	@RequestMapping(value="sports", method= {RequestMethod.GET})
	//public void getSports() { // void의 경우 RequestMapping의 이름.html 을 찾아감
		public String getSports() {
		log.info(Color.BLUE+"@@@ My favorite sports is the soccer" + Color.END);
		//return "index";
		return "ex/mysports";
	}
	
	//RequestMapping은 get, post 고를 수 있음
	@RequestMapping(value="sports", method= {RequestMethod.POST})
	//public void getSports() { // void의 경우 RequestMapping의 이름.html 을 찾아감
		public String postSports() {
		log.info(Color.BLUE+"@@@ My favorite sports is the ski" + Color.END);
		//return "index";
		return "ex/mysports";
	}
	
	// 통상적 방법
	// localhost:port/ex/classic?title=nocturn&artist=Chopin (두가지 파라미터)
	@GetMapping("classic")
	public String classicTest(HttpServletRequest req) {
		String title = req.getParameter("title");
		String artist = req.getParameter("artist");
		
		log.info("classic : "+title +":" +artist);
		return "index";
	}
	
	//다른 방법
	@GetMapping("modern")
	public String modernTest(String title, String artist, String desc) {
		log.info("modern : "+title +":" +artist);
		return "index";
	}
	
	@GetMapping("future")
	public String futureTest(ArtVO artVO, String title) {
		log.info("future : "+artVO);
		//log.info("future : "+title);
		log.info("future : "+artVO.getTitle() +":" +artVO.getArtist());
		
		return "index";
	}
	
	// http://localhost:10000/ex/order?m=steack&a=10000로 입력
	@GetMapping("order")
	public String getOrder(String m, int a) {
		String menu =m;
		int amount=a;
		
		return "/index";
	}
	
	@GetMapping("order2")
	public String getOrder2(@RequestParam("m") String menu
									,@RequestParam("a") int amount) {
		log.info("-------------------------");
		log.info("menu= "+menu+ " : amount= "+ amount);
		log.info("-------------------------");
		
		return "/index";
	}
	
	// java에서 html로 데이터 전송하기 : Model 활용
	@GetMapping("query")
	public void  query(@ModelAttribute("MyModel") ArtVO vo ) {
		vo.setTitle("Everything");
		vo.setArtist("검정치마");
		//vo.setDesc("좋음");
		vo.setDesc(mapper.getTime());
	}
	
	@GetMapping("subject")
	public void subject() {
	}
	
	@GetMapping("subjectvo")
	public String subjectVO(SubjectVO vo, Model model) {
		model.addAttribute("subject",vo);
		model.addAttribute("feeling", "지침..");
		
		return "ex/subjectTest";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
