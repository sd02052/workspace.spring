package com.sist.jdbc04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sist.model.BoardDAO;
import com.sist.model.BoardDTO;

@Controller
public class BoardController {

	@Autowired
	private BoardDAO dao;

	@RequestMapping("/board_list.do")
	public String list(Model model, @RequestParam("page") String this_page) {
		// 페이징 작업
		int rowsize = 5; // 한 페이지당 보여질 게시물의 수
		int block = 3; // 아래에 보여질 페이지의 최대 수 - 예) [1][2][3] / [4][5][6]
		int totalRecord = 0; // DB 상의 게시물 전체 수
		int allPage = 0; // 전체 페이지 수

		int page = 0; // 현재 페이지 변수

		if (this_page != null) {
			page = Integer.parseInt(this_page);
		} else {
			page = 1; // 처음으로 "전체 게시물" a태그를 클릭한 경우
		}

		// 해당 페이지에서 시작 번호
		int startNo = (page * rowsize) - (rowsize - 1);

		// 해당 페이지에서 마지막 번호
		int endNo = (page * rowsize);

		// 해당 페이지의 시작 블럭
		int startBlock = (((page - 1) / block) * block) + 1;

		// 해당 페이지의 마지막 블럭
		int endBlock = (((page - 1) / block) * block) + block;

		// DB상의 전체 게시물 수를 확인하는 메서드
		totalRecord = this.dao.getListCount();

		// 전체 게시물의 수를 한 페이지당 보여질 게시물의 수로 나누어 주어야 함.
		// 이 과정을 거치면 전체 페이지 수가 나오게 됨.
		// 전체 페이지 수가 나올 때 나머지가 있으면 무조건 페이지 수를 하나 올려주어야 함.
		allPage = (int) (Math.ceil(totalRecord / (double) rowsize));

		if (endBlock > allPage) {
			endBlock = allPage;
		}
		List<BoardDTO> list = this.dao.getBoardList(startNo, endNo);

		model.addAttribute("page", page);
		model.addAttribute("rowsize", rowsize);
		model.addAttribute("block", block);
		model.addAttribute("totalrecord", totalRecord);
		model.addAttribute("allPage", allPage);
		model.addAttribute("startNo", startNo);
		model.addAttribute("endNo", endNo);
		model.addAttribute("startBlock", startBlock);
		model.addAttribute("endBlock", endBlock);
		model.addAttribute("list", list);

		return "board_list";
	}

	@RequestMapping("/board_insert.do")
	public String insert(Model model) {
		return "board_insert";
	}

	@RequestMapping("/board_insertOk.do")
	public void insertok(BoardDTO dto, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");

		int result = this.dao.insertBoard(dto);

		PrintWriter out = response.getWriter();

		if (result > 0) {
			out.println("<script>");
			out.println("alert('게시물 등록 성공')");
			out.println("location.href='board_list.do?page=1'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('게시물 등록 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
	}

	@RequestMapping("/board_cont.do")
	public String cont(@RequestParam("board_no") int board_no, @RequestParam("page") String page, Model model) {
		this.dao.hitBoard(board_no);
		BoardDTO dto = this.dao.getBoardCont(board_no);
		model.addAttribute("cont", dto);
		model.addAttribute("page", page);

		return "board_cont";
	}

	@RequestMapping("/board_edit.do")
	public String edit(@RequestParam("board_no") int board_no, Model model) {
		BoardDTO dto = this.dao.getBoardCont(board_no);

		model.addAttribute("edit", dto);

		return "board_edit";
	}

	@RequestMapping("/board_editOk.do")
	public void editOk(BoardDTO dto, @RequestParam("dbpwd") String dbpwd, HttpServletResponse response)
			throws IOException {
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		if (dbpwd.equals(dto.getBoard_pwd())) {
			int result = this.dao.updateBoard(dto);

			if (result > 0) {
				out.println("<script>");
				out.println("alert('게시물 수정 성공')");
				out.println("location.href='board_cont.do?board_no=" + dto.getBoard_no() + "'");
				out.println("</script>");
			} else {
				out.println("<script>");
				out.println("alert('게시물 수정 실패')");
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

	@RequestMapping("/board_delete.do")
	public void delete(@RequestParam("board_no") int board_no, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		int result = this.dao.deleteBoard(board_no);

		if (result > 0) {
			this.dao.updateBoardNo(board_no);
			out.println("<script>");
			out.println("alert('게시물 삭제 성공')");
			out.println("location.href='board_list.do?page=1'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('게시물 삭제 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
	}

	@RequestMapping("/board_search.do")
	public String search(@RequestParam("field") String field, @RequestParam("keyword") String keyword, Model model) {
		List<BoardDTO> list = this.dao.searchBoardList(field, keyword);

		model.addAttribute("search", list);

		return "board_search";
	}
}
