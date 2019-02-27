package com.spring.shoppingbackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.shoppingbackend.dao.ProductDAO;
import com.spring.shoppingbackend.dto.Product;
import org.junit.runners.JUnit4;

public class ProductTestCase {
	private static AnnotationConfigApplicationContext context;

	private static ProductDAO productDAO;

	private Product product;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.spring.shoppingbackend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
	}

/*	@Test
	public void testCRUDProduct() {
		product = new Product();
		
		product.setName("xiaomi mi mix2");
		product.setBrand("xiaomi");
		product.setDescription("smart phone");
		product.setUnitPrice(3000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
			assertEquals("hata",true,productDAO.add(product));
		
		product = productDAO.get(3);
		product.setName("samsun galaxy s3adqasda");
		assertEquals("update sırasında hata olustu",true,productDAO.update(product));
		
		assertEquals("delete sırasında hata olustu",true,productDAO.delete(product));
		
		assertEquals("update sırasında hata olustu",6,productDAO.list().size());


	}
*/
	@Test
	public void testListActiveProducts() {
	//	assertEquals("yanlis sayi",5,productDAO.listActiveProducts().size());
		
	//	assertEquals("yanlis sayi",2,productDAO.listActiveProductsByCategory(1).size());
		
		assertEquals("yanlis sayi",2,productDAO.getLatestActiveProducts(2).size());
	}
}
