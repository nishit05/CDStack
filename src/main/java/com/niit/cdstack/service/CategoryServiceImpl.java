package com.niit.cdstack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.cdstack.dao.CategoryDAO;
import com.niit.cdstack.model.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDAO categorydao;
	
	@Override
	public void addCategory(Category c) {
		// TODO Auto-generated method stub
		categorydao.addCategory(c);
	}

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return categorydao.getAllCategory();
	}

	@Override
	public Category getCategoryById(int id) {
		// TODO Auto-generated method stub
		return categorydao.getCategoryById(id);
	}

	@Override
	public void deleteCategory(int id) {
		// TODO Auto-generated method stub
		categorydao.deleteCategory(id);
	}

	@Override
	public void updateCategory(Category c) {
		// TODO Auto-generated method stub
		categorydao.updateCategory(c);
	}

}
