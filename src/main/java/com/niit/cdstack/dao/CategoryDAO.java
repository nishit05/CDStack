package com.niit.cdstack.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.cdstack.model.Category;

@Repository
public interface CategoryDAO {
	void addCategory(Category c);
	List<Category> getAllCategory();
	Category getCategoryById(int id);
	void deleteCategory(int id);
	void updateCategory(Category p);
}
