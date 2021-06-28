package com.sist.jdbc03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sist.model.MemberDAO;
import com.sist.model.MemberDTO;

@Controller
public class MemberController {

	@Autowired
	private MemberDAO dao;

	@RequestMapping("/member_list.do")
	public String list(Model model) {

		List<MemberDTO> list = this.dao.getMemberList();

		model.addAttribute("List", list);

		return "member_list";
	}

	@RequestMapping("/member_add.do")
	public String add() {

		return "member_add";
	}

	@RequestMapping("/member_addOk.do")
	public void addOk(MemberDTO dto, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");

		int result = this.dao.insertMember(dto);

		PrintWriter out = response.getWriter();

		if (result > 0) {
			out.println("<script>");
			out.println("alert('회원 등록 성공')");
			out.println("location.href='member_list.do'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('회원 등록 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
	}

	@RequestMapping("/member_cont.do")
	public String cont(@RequestParam("num") int num, Model model) {

		MemberDTO dto = this.dao.getMember(num);

		model.addAttribute("cont", dto);

		return "member_cont";
	}

	@RequestMapping("/member_update.do")
	public ModelAndView update(@RequestParam("num") int num) {
		MemberDTO dto = this.dao.getMember(num);

		ModelAndView mav = new ModelAndView();
		mav.addObject("cont", dto);
		mav.setViewName("member_update");

		return mav;
	}

	@RequestMapping("/member_updateOk.do")
	public void updateOk(MemberDTO dto, @RequestParam("dbpwd") String dbpwd, HttpServletResponse response)
			throws IOException {
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		if (dbpwd.equals(dto.getPwd())) { // 비밀번호가 같은 경우
			int result = this.dao.updateMember(dto);

			if (result > 0) {
				out.println("<script>");
				out.println("alert('회원정보 수정 성공')");
				out.println("location.href='member_cont.do?num=" + dto.getNum() + "'");
				out.println("</script>");
			} else {
				out.println("<script>");
				out.println("alert('회원정보 수정 실패')");
				out.println("history.back()");
				out.println("</script>");
			}
		} else { // 비밀번호가 다른 경우
			out.println("<script>");
			out.println("alert('비밀번호가 틀립니다.')");
			out.println("history.back()");
			out.println("</script>");
		}
	}

	@RequestMapping("/member_delete.do")
	public void delete(@RequestParam("num") int num, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");

		int result = this.dao.deleteMember(num);

		PrintWriter out = response.getWriter();

		if (result > 0) { // 회원 삭제 성공했을 때
			this.dao.updateSequence(num); // 게시물 번호들 수정

			out.println("<script>");
			out.println("alert('회원 삭제 성공')");
			out.println("location.href='member_list.do'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('회원 삭제 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
	}

	@RequestMapping("/member_search.do")
	public ModelAndView search(@RequestParam("field") String field, @RequestParam("keyword") String keyword) {

		List<MemberDTO> list = this.dao.searchList(field, keyword);

		ModelAndView mav = new ModelAndView();

		mav.addObject("searchList", list);
		mav.setViewName("member_search");

		return mav;
	}
}
