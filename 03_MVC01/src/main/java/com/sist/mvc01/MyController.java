package com.sist.mvc01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

	/*
	 * ModelAndView ��ü��?
	 * - ModelAndView ��ü�� ��Ʈ�ѷ��� ���ؼ�
	 *   �����Ͻ� ������ ������ �ǰ� ���� ��ü������ 
	 *   ����ڿ��� ��ȯ�Ǿ� �������� ������ �������� ���������.
	 *   �� �� ������� ������ view page�� �Ѱ��� ��
	 *   ������ �� view page ������ ������ ���� 
	 *   �Ѳ����� �����Ͽ� �Ѱ��� �� �����.
	 */
	@RequestMapping("/info")
	public ModelAndView aaa() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("email", "hong@naver.com"); // ����(Model) ����
		mav.setViewName("member/email");
		
		return mav;
		
	}
}
