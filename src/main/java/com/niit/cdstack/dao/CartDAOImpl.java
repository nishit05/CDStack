package com.niit.cdstack.dao;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.cdstack.model.Cart;
import com.niit.cdstack.model.Products;

@Repository
@Transactional
public class CartDAOImpl implements CartDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void addToCart(Cart ct) {
		// TODO Auto-generated method stub
		Session s=sessionFactory.openSession();
		Transaction t=s.beginTransaction();
		int id=ct.getPid();
		Products p=(Products) s.get(Products.class, id);
		double price=p.getPrice();
		ct.setPname(p.getPname());
		ct.setPrice(price);
		s.saveOrUpdate(ct);
		t.commit();
		s.close();
	}

	@Override
	public List<Cart> cartList(int id){
		// TODO Auto-generated method stub
		Session s=sessionFactory.openSession();
		Criteria c=s.createCriteria(Cart.class);
		c.add(Restrictions.eq("u_id", id));
		List<Cart>cl=c.list();
		s.close();
		return cl;
	}

	@Override
	public void deleteFromCart(String id) {
		// TODO Auto-generated method stub
		Session s=sessionFactory.openSession();
		Transaction t=s.beginTransaction();
		Cart c=(Cart) s.load(Cart.class,id);
		if(c!=null)
			s.delete(c);
		t.commit();
		s.close();
	}

	@Override
	public Cart getCartById(String id) {
		// TODO Auto-generated method stub
		Session s=sessionFactory.openSession();
		Transaction t=s.beginTransaction();
		System.out.println("Get Cart by Id calling");
		Cart c=(Cart) s.load(Cart.class, id);
		t.commit();
		s.close();
		return c;
		
	}


	public void updateCart(int qty,int id,int uid) {
		// TODO Auto-generated method stub
		Session s=sessionFactory.openSession();
		Transaction t=s.beginTransaction();
		String qu="update Cart set qty="+qty+" where pid="+id+"and u_id="+uid;
		Query q= s.createQuery(qu);
		int p=q.executeUpdate();
		System.out.println("Cart updated rows affected is "+p);
		t.commit();
		s.close();
	}

	
}
