package com.spring.shoppingbackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.shoppingbackend.dao.CategoryDAO;
import com.spring.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.spring.shoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

//	@Test
//	public void testAddCategory() {
//		
//		category = new Category();
//		category.setName("Phone");
//		category.setDescription("Phone aciklama");
//		category.setImageURL("urlgir");
//		
//		assertEquals("Eklenirken Bir Hata Olustu ", true, categoryDAO.add(category));
//		
//	}

//	@Test
//	public void testAddCategory() {
//		
//		category = categoryDAO.get(1);		
//		assertEquals("successfully fetched", "Televizyon", category.getName()); 
//	}

//	@Test
//	public void testUpdateCategory() {
//		
//		category = categoryDAO.get(1);		
//		category.setName("TV");
//		assertEquals("successfully update",true, categoryDAO.update(category)); 
//	}

//	@Test
//	public void testDeleteCategory() {
//		
//		category = categoryDAO.get(1);
//		assertEquals("successfully update",true, categoryDAO.delete(category)); 
//	}

	@Test
	public void testListCategory() {
		assertEquals("successfully fetch the list",3, categoryDAO.list().size());
	}
//	
//	@Test
//	public void testCRUDCategory() {
//		
//		category = new Category();
//		category.setName("Phone");
//		category.setDescription("Phone aciklama");
//		category.setImageURL("urlgir");
//		
//		assertEquals("Eklenirken Bir Hata Olustu ", true, categoryDAO.add(category));
//		
//		category = new Category();
//		category.setName("Laptop");
//		category.setDescription("Laptop aciklama");
//		category.setImageURL("urlgir");
//		
//		assertEquals("Eklenirken Bir Hata Olustu ", true, categoryDAO.add(category));
//		
//		category = categoryDAO.get(2);
//		category.setName("TV");
//		assertEquals("Eklenirken Bir Hata Olustu ", true, categoryDAO.add(category));
//		
//		assertEquals("successfully update",true, categoryDAO.delete(category)); 
//		
//		assertEquals("successfully fetched", "Televizyon", category.getName());
		
		
	}
