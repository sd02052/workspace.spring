package com.spring.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.model.MemberDAO;
import com.spring.model.MemberDTO;

@Controller
public class MemberController {

	@Autowired
	private MemberDAO dao;

	@RequestMapping("member_list.do")
	public String list(Model model) {
		List<MemberDTO> list = this.dao.getMemberList();

		model.addAttribute("list", list);

		return "member_list";
	}

	@RequestMapping("member_insert.do")
	public String insert() {
		return "member_insert";
	}

	@RequestMapping("member_insert_ok.do")
	public void insertOk(MemberDTO dto, HttpServletResponse response) throws IOException {
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

	@RequestMapping("member_cont.do")
	public String cont(@RequestParam("num") int num, Model model) {

		MemberDTO dto = this.dao.getMember(num);

		model.addAttribute("dto", dto);

		return "member_cont";
	}

	@RequestMapping("member_update.do")
	public String update(@RequestParam("num") int num, Model model) {

		MemberDTO dto = this.dao.getMember(num);

		model.addAttribute("dto", dto);

		return "member_update";
	}

	@RequestMapping("member_update_ok.do")
	public void updateOk(@RequestParam("dbpwd") String dbpwd, MemberDTO dto, HttpServletResponse response)
			throws IOException {
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		if (dbpwd.equals(dto.getPwd())) {
			int result = this.dao.updateMember(dto);

			if (result > 0) {
				out.println("<script>");
				out.println("alert('회원 수정 성공')");
				out.println("location.href='member_cont.do?num=" + dto.getNum() + "'");
				out.println("</script>");
			} else {
				out.println("<script>");
				out.println("alert('회원 수정 실패')");
				out.println("history.back()");
				out.println("</script>");
			}
		} else {
			out.println("<script>");
			out.println("alert('비밀번호가 틀립니다.')");
			out.println("history.back()");
			out.println("</script>");
		}
	}

	@RequestMapping("member_delete.do")
	public void delete(@RequestParam("num") int num, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");

		int result = this.dao.deleteMember(num);

		PrintWriter out = response.getWriter();

		if (result > 0) {
			this.dao.reSequence(num);

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

	@RequestMapping("member_search.do")
	public String search(@RequestParam("field") String field, @RequestParam("keyword") String keyword, Model model) {

		List<MemberDTO> list = this.dao.searchMemberList(field, keyword);

		model.addAttribute("list", list);

		return "member_search";
	}
}
