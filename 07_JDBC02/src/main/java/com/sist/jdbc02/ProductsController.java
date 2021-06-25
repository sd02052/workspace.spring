package com.sist.jdbc02;

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

import com.sist.model.CategoryDTO;
import com.sist.model.ProductsDAO;
import com.sist.model.ProductsDTO;

@Controller
public class ProductsController {

	@Autowired
	private ProductsDAO dao;

	@RequestMapping("/product_list.do")
	public String list(Model model) {
		List<ProductsDTO> list = this.dao.getProductList();

		model.addAttribute("pList", list);

		return "product_list";
	}

	@RequestMapping("/product_insert.do")
	public String insert(Model model) {

		List<CategoryDTO> list = this.dao.getCategoryList();

		model.addAttribute("cList", list);

		return "product_insertForm";
	}

	@RequestMapping("/product_insertOk.do")
	public void inserOk(ProductsDTO dto, HttpServletResponse response) throws IOException {

		int result = this.dao.insertProduct(dto);

		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset=UTF-8");

		if (result > 0) {
			out.println("<script>");
			out.println("alert('제품 등록 성공')");
			out.println("location.href='product_list.do'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('제품 등록 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
	}

	@RequestMapping("/product_cont.do")
	public ModelAndView content(@RequestParam("pnum") int pnum) {

		ProductsDTO dto = this.dao.getProductCont(pnum);
		ModelAndView mav = new ModelAndView();
		mav.addObject("cont", dto);
		mav.setViewName("product_content");

		return mav;
	}

	@RequestMapping("/product_modify.do")
	public ModelAndView modify(@RequestParam("pnum") int pnum) {

		ProductsDTO dto = this.dao.getProductCont(pnum);
		List<CategoryDTO> list = this.dao.getCategoryList();

		ModelAndView mav = new ModelAndView();

		mav.addObject("modify", dto);
		mav.addObject("cList", list);

		mav.setViewName("product_modify");

		return mav;
	}

	@RequestMapping("/product_modifyOk.do")
	public void modifyOk(ProductsDTO dto, HttpServletResponse response) throws IOException {

		int result = this.dao.updateProduct(dto);

		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		if (result > 0) {
			out.println("<script>");
			out.println("alert('제품 수정 성공')");
			out.println("location.href='product_cont.do?pnum=" + dto.getPnum() + "'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('제품 수정 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
	}
}
