package com.spring.mybatis01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.model.DeptDTO;
import com.spring.model.EmpDAO;
import com.spring.model.EmpDTO;

@Controller
public class EmpController {

	@Autowired
	private EmpDAO dao;

	@RequestMapping("/emp_list.do")
	public String list(Model model) {

		List<EmpDTO> list = this.dao.getEmpList();

		model.addAttribute("List", list);

		return "emp_list";
	}

	@RequestMapping("/emp_insert.do")
	public String insert(Model model) {
		List<DeptDTO> deptList = this.dao.getDeptList();
		List<EmpDTO> mgrList = this.dao.getMgrList();

		model.addAttribute("deptList", deptList);
		model.addAttribute("mgrList", mgrList);

		return "emp_insert";
	}

	@RequestMapping("/emp_insert_ok.do")
	public void insertOk(EmpDTO dto, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");

		int result = this.dao.insertEmp(dto);

		PrintWriter out = response.getWriter();

		if (result > 0) {
			out.println("<script>");
			out.println("alert('사원 등록 성공')");
			out.println("location.href='emp_list.do'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('사원 등록 실패')");
			out.println("hisotry.back()");
			out.println("</script>");
		}
	}

	@RequestMapping("/emp_cont.do")
	public String cont(@RequestParam("empno") int empno, Model model) {

		EmpDTO dto = this.dao.getCont(empno);

		model.addAttribute("cont", dto);

		return "emp_cont";
	}

	@RequestMapping("/emp_update.do")
	public String update(@RequestParam("empno") int empno, Model model) {

		EmpDTO dto = this.dao.getCont(empno);
		List<DeptDTO> deptList = this.dao.getDeptList();
		List<EmpDTO> mgrList = this.dao.getMgrList();

		model.addAttribute("cont", dto);
		model.addAttribute("deptList", deptList);
		model.addAttribute("mgrList", mgrList);

		return "emp_update";
	}

	@RequestMapping("/emp_update_ok.do")
	public void updateOk(EmpDTO dto, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");

		int result = this.dao.updateEmp(dto);

		PrintWriter out = response.getWriter();

		if (result > 0) {
			out.println("<script>");
			out.println("alert('사원 정보 수정 성공')");
			out.println("location.href='emp_cont.do?empno=" + dto.getEmpno() + "'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('사원 정보 수정 실패')");
			out.println("hisotry.back()");
			out.println("</script>");
		}
	}

	@RequestMapping("/emp_delete.do")
	public void delete(@RequestParam("empno") int empno, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");

		int result = this.dao.deleteEmp(empno);

		PrintWriter out = response.getWriter();

		if (result > 0) {
			out.println("<script>");
			out.println("alert('사원 삭제 성공')");
			out.println("location.href='emp_list.do'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('사원 삭제 실패')");
			out.println("hisotry.back()");
			out.println("</script>");
		}
	}

}
