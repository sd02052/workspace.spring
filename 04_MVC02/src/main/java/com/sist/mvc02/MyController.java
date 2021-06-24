package com.sist.mvc02;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

	@RequestMapping("/input") // 이게 중요. 메서드이름은 중요하지 않다.
	public String aaa() {
		return "insertForm";
	}

	@RequestMapping("/inputOk")
	public String bbb(HttpServletRequest request, Model model) {

		String name = request.getParameter("name").trim();
		String id = request.getParameter("id").trim();

		model.addAttribute("userName", name);
		model.addAttribute("userId", id);

		return "login";
	}

	@RequestMapping("/insert")
	public String bbc() {

		return "insert";
	}

	@RequestMapping("/insert_ok")
	public ModelAndView ccc(@RequestParam("id") String userId, @RequestParam("pwd") String userPwd) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("req_id", userId);
		mav.addObject("req_pwd", userPwd);
		mav.setViewName("insert_ok");
		
		return mav;
	}
}
