package net.spring.onlineshopping.controller;

import net.spring.onlineshopping.exception.ProductNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.shoppingbackend.dao.CategoryDAO;
import com.spring.shoppingbackend.dao.ProductDAO;
import com.spring.shoppingbackend.dto.Category;
import com.spring.shoppingbackend.dto.Product;


@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value = {"/","/home","/index"})
	public ModelAndView	 index(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Home");
		
		logger.info("pagecontrollerin index metodu - info ");
		logger.debug("pagecontrollerin index metodu - debug ");
		
		mv.addObject("categories",categoryDAO.list());
		mv.addObject("userClickHome",true);
		return mv;
	}
	
	@RequestMapping(value = "/about")
	public ModelAndView	 about(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","About Us");
		mv.addObject("userClickAbout",true);
		return mv;
	}
	
	@RequestMapping(value = "/contact")
	public ModelAndView	 contact(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Contact Us");
		mv.addObject("userClickContact",true);
		return mv;
	}
	
	//butun urunler ve category bazlı urunler
	
	@RequestMapping(value = {"/show/all/products"})
	public ModelAndView	 showAllProducts(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","All Products");
		mv.addObject("categories",categoryDAO.list());
		mv.addObject("userClickAllProducts",true);
		return mv;
	}
	
	@RequestMapping(value = {"/show/category/{id}/products"})
	public ModelAndView	 showCategoryProducts(@PathVariable("id") int id){
		ModelAndView mv = new ModelAndView("page");
		//tek bir category almak icin
		Category category = null;
		category = categoryDAO.get(id);
		mv.addObject("title",category.getName());
		mv.addObject("category",category);
		//categori listesi icin
		mv.addObject("categories",categoryDAO.list());
		mv.addObject("userClickCategoryProducts",true);
		return mv;
	}
	
	
	@RequestMapping(value = "/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException {
		
		ModelAndView mv = new ModelAndView("page");
		Product product = productDAO.get(id);

		if (product == null) throw new ProductNotFoundException();
		
		product.setViews(product.getViews()+1);
		productDAO.update(product);
		
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		mv.addObject("userClickShowProduct",true);
		
		return mv;
	}
	
	
}
