package com.sist.mvc01;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("hello", "안녕하세요? 스프링에 오신걸 환영합니다.");
		
		return "home";
	}
	
	/*
	 * 스프링 MVC에서 Model(모델)?
	 * - 컨트롤러에 의해서 비지니스 로직이 수행이 되고 나면
	 *   대체적으로 view page에 보여질 정보들이 만들어짐.
	 *   이러한 정보들을 스프링에서는 Model(모델)이라고 함.
	 *   이 Model(정보)을 view page로 보내게 됨.
	 */
	
	@RequestMapping("/memberInfo")
	public String member(Model model) {
		model.addAttribute("name", "홍길동");
		model.addAttribute("age", 27);
		model.addAttribute("addr", "경기도 고양시 일산동구");
		return "member";
	}
}
