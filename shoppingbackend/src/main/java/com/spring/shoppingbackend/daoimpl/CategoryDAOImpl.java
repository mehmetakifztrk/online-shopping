package com.spring.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.shoppingbackend.dao.CategoryDAO;
import com.spring.shoppingbackend.dto.Category;


@Repository("categoriDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<Category>();
	
	static{
		Category category = new Category();
		category.setId(1);
		category.setName("Televizyon");
		category.setDescription("TV acıklaması");
		category.setImageURL("img1.png");
		categories.add(category);
		
		category = new Category();
		category.setId(2);
		category.setName("Telefon");
		category.setDescription("Telefon acıklaması");
		category.setImageURL("img2.png");
		categories.add(category);
		
		category = new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("Laptop acıklaması");
		category.setImageURL("img3.png");
		categories.add(category);
	}
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {
		for(Category category : categories){
			if(category.getId() == id) return category;
		}
		return null;
	}

}
