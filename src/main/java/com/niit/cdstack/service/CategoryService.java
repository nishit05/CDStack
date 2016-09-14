package com.niit.cdstack.service;

import java.util.List;

import com.niit.cdstack.model.Category;

public interface CategoryService {
	void addCategory(Category p);

	List<Category> getAllCategory();

	Category getCategoryById(int id);

	void deleteCategory(int id);
	
	void updateCategory(Category p);
}
