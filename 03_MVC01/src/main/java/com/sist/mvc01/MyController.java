﻿package com.sist.mvc01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

	/*
	 * ModelAndView 객체란?
	 * - ModelAndView 객체는 컨트롤러에 의해서
	 *   비지니스 로직이 수행이 되고 나면 대체적으로 
	 *   사용자에게 반환되어 브라우저에 보여질 정보들이 만들어진다.
	 *   이 때 만들어진 정보를 view page로 넘겨줄 때
	 *   응답을 할 view page 정보와 전달할 값을 
	 *   한꺼번에 저장하여 넘겨줄 때 사용함.
	 */
	@RequestMapping("/info")
	public ModelAndView aaa() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("email", "hong@naver.com"); // 정보(Model) 저장
		mav.setViewName("member/email");
		
		return mav;
		
	}
}
