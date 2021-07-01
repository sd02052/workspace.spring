package com.spring.mybatis02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.model.CategoryDTO;
import com.spring.model.ProductsDAO;
import com.spring.model.ProductsDTO;

@Controller
public class ProductController {

	@Autowired
	private ProductsDAO dao;

	@RequestMapping("/products_list.do")
	public String list(Model model) {
		List<ProductsDTO> list = this.dao.getProductsList();

		model.addAttribute("list", list);

		return "products_list";
	}

	@RequestMapping("/products_insert.do")
	public String insert(Model model) {

		List<CategoryDTO> list = this.dao.getCateList();
		model.addAttribute("list", list);

		return "products_insert";
	}

	@RequestMapping("/products_insert_ok.do")
	public void insertOk(ProductsDTO dto, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");

		int result = this.dao.insertProducts(dto);

		PrintWriter out = response.getWriter();

		if (result > 0) {
			out.println("<script>");
			out.println("alert('제품 등록 성공')");
			out.println("location.href='products_list.do'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('제품 등록 실패')");
			out.println("hisotry.back()");
			out.println("</script>");
		}
	}

	@RequestMapping("/products_cont.do")
	public String cont(@RequestParam("pnum") int pnum, Model model) {

		ProductsDTO dto = this.dao.getProductsCont(pnum);

		model.addAttribute("cont", dto);

		return "products_cont";
	}

	@RequestMapping("/products_update.do")
	public String update(@RequestParam("pnum") int pnum, Model model) {

		ProductsDTO dto = this.dao.getProductsCont(pnum);
		List<CategoryDTO> list = this.dao.getCateList();

		model.addAttribute("cont", dto);
		model.addAttribute("list", list);

		return "products_update";
	}

	@RequestMapping("/products_update_ok.do")
	public void updateOk(ProductsDTO dto, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");

		int result = this.dao.updateProducts(dto);

		PrintWriter out = response.getWriter();

		if (result > 0) {
			out.println("<script>");
			out.println("alert('제품 수정 성공')");
			out.println("location.href='products_cont.do?pnum=" + dto.getPnum() + "'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('제품 수정 실패')");
			out.println("hisotry.back()");
			out.println("</script>");
		}
	}

	@RequestMapping("/products_delete.do")
	public void delete(@RequestParam("pnum") int pnum, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");

		int result = this.dao.deleteProducts(pnum);

		PrintWriter out = response.getWriter();

		if (result > 0) {
			this.dao.updateProductsNum(pnum);
			
			out.println("<script>");
			out.println("alert('제품 삭제 성공')");
			out.println("location.href='products_list.do'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('제품 삭제 실패')");
			out.println("hisotry.back()");
			out.println("</script>");
		}
	}

	@RequestMapping("/products_search.do")
	public String search(@RequestParam("field") String field, @RequestParam("keyword") String keyword, Model model) {

		List<ProductsDTO> list = this.dao.searchList(field, keyword);

		model.addAttribute("list", list);

		return "products_search";
	}
}
