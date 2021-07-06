package com.board.mybatis04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.model.BoardDAO;
import com.board.model.BoardDTO;
import com.board.model.PageDTO;

@Controller
public class BoardController {

	@Autowired
	private BoardDAO dao;

	private int totalRecord = 0;
	private final int rowsize = 3;

	@RequestMapping("board_list.do")
	public String list(HttpServletRequest request, Model model) {

		int page = 0; // 현재 페이지 변수

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		} else {
			page = 1; // 처음으로 "게시물 전체 목록" 태그를 클릭한 경우
		}

		// DB 상의 전체 게시물의 수를 확인하는 작업.
		totalRecord = this.dao.getListCount();

		PageDTO dto = new PageDTO(page, rowsize, totalRecord);

		// 페이지에 해당하는 게시물을 가져오는 메서드 호출
		List<BoardDTO> pageList = this.dao.getBoardList(dto);

		model.addAttribute("list", pageList);
		model.addAttribute("Paging", dto);

		return "board_list";
	}

	@RequestMapping("board_write.do")
	public String write() {
		return "board_writeForm";
	}

	@RequestMapping("board_write_ok.do")
	public void writeOk(BoardDTO dto, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");

		int result = this.dao.insertBoard(dto);

		PrintWriter out = response.getWriter();

		if (result > 0) {
			out.println("<script>");
			out.println("alert('게시물 등록 성공.')");
			out.println("location.href='board_list.do'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('게시물 등록 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
	}

	@RequestMapping("board_cont.do")
	public String cont(@RequestParam("no") int board_no, @RequestParam("page") int page, Model model) {

		this.dao.readCount(board_no); // 조회수 증가

		BoardDTO dto = this.dao.boardCont(board_no);

		model.addAttribute("cont", dto);
		model.addAttribute("page", page);

		return "board_content";
	}

	@RequestMapping("board_update.do")
	public String update(@RequestParam("no") int board_no, @RequestParam("page") int page, Model model) {

		BoardDTO dto = this.dao.boardCont(board_no);

		model.addAttribute("dto", dto);
		model.addAttribute("page", page);

		return "board_updateForm";
	}

	@RequestMapping("board_update_ok.do")
	public void updateOk(@RequestParam("page") int page, @RequestParam("dbpwd") String dbpwd, BoardDTO dto,
			HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		if (dbpwd.equals(dto.getBoard_pwd())) { // 입력한 비밀번호가 같을때
			int result = this.dao.updateBoard(dto);

			if (result > 0) {
				out.println("<script>");
				out.println("alert('게시물 수정 성공.')");
				out.println("location.href='board_cont.do?no=" + dto.getBoard_no() + "&page=" + page + "'");
				out.println("</script>");
			} else {
				out.println("<script>");
				out.println("alert('게시물 수정 실패')");
				out.println("history.back()");
				out.println("</script>");
			}
		} else {
			out.println("<script>");
			out.println("alert('비밀번호가 다릅니다.')");
			out.println("history.back()");
			out.println("</script>");
		}
	}

	@RequestMapping("board_delete.do")
	public void deleteOk(@RequestParam("page") int page, @RequestParam("no") int board_no, HttpServletResponse response)
			throws IOException {
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		int result = this.dao.deleteBoard(board_no);

		if (result > 0) {
			this.dao.reSequence(board_no);
			out.println("<script>");
			out.println("alert('게시물 삭제 성공.')");
			out.println("location.href='board_list.do?page=" + page + "'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('게시물 삭제 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
	}

	@RequestMapping("board_search.do")
	public String search(@RequestParam("field") String field, @RequestParam("keyword") String keyword,
			Model model, HttpServletRequest request) {
		
		int page = 0; // 현재 페이지 변수

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		} else {
			page = 1; // 처음으로 "게시물 전체 목록" 태그를 클릭한 경우
		}
		
		// 검색분류와 검색어에 해당하는 게시글의 갯수를 DB에서 확인하는 작업
		totalRecord = this.dao.searchBoardCount(field, keyword);
		PageDTO dto = new PageDTO(page, rowsize, totalRecord, field, keyword);

		// 페이지에 해당하는 게시물을 가져오는 메서드 호출
		List<BoardDTO> pageList = this.dao.searchBoardList(dto);

		model.addAttribute("list", pageList);
		model.addAttribute("Paging", dto);
		model.addAttribute("field", field);
		model.addAttribute("keyword", keyword);

		return "board_search";
	}

}
