package com.niit.cdstack.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.cdstack.model.Category;

@Repository
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addCategory(Category c) {
		// TODO Auto-generated method stub
		Session s=sessionFactory.openSession();
		s.saveOrUpdate(c);
		s.close();
	}

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		Session s=sessionFactory.openSession();
		List<Category>cl=s.createQuery("from Category").list();
		s.close();
		return cl;
	}

	@Override
	public Category getCategoryById(int id) {
		// TODO Auto-generated method stub
		Session s=sessionFactory.openSession();
		Transaction tr=s.beginTransaction();
		Category c=(Category) s.load(Category.class, new Integer(id));
		tr.commit();
		return c;
	}

	@Override
	public void deleteCategory(int id) {
		// TODO Auto-generated method stub
		Session s=this.sessionFactory.openSession();
		Transaction tr=s.beginTransaction();
		Category c=(Category) s.get(Category.class, new Integer(id));
		if(null!=c)
		{
			s.delete(c);
		}
		tr.commit();
		s.close();
	}

	@Override
	public void updateCategory(Category c) {
		// TODO Auto-generated method stub
		Session s=sessionFactory.openSession();
		Transaction t=s.beginTransaction();
		s.update(c);
		t.commit();
		s.close();
		System.out.println("Details Updated");
	}

}
