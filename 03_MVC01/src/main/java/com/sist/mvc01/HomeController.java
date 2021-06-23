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
		model.addAttribute("hello", "�ȳ��ϼ���? �������� ���Ű� ȯ���մϴ�.");
		
		return "home";
	}
	
	/*
	 * ������ MVC���� Model(��)?
	 * - ��Ʈ�ѷ��� ���ؼ� �����Ͻ� ������ ������ �ǰ� ����
	 *   ��ü������ view page�� ������ �������� �������.
	 *   �̷��� �������� ������������ Model(��)�̶�� ��.
	 *   �� Model(����)�� view page�� ������ ��.
	 */
	
	@RequestMapping("/memberInfo")
	public String member(Model model) {
		model.addAttribute("name", "ȫ�浿");
		model.addAttribute("age", 27);
		model.addAttribute("addr", "��⵵ ���� �ϻ굿��");
		return "member";
	}
}
