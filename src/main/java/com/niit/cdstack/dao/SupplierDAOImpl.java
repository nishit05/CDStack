package com.niit.cdstack.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.cdstack.model.Supplier;

@Repository
@Transactional
public class SupplierDAOImpl implements SupplierDAO {


	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addSupplier(Supplier sp) {
		// TODO Auto-generated method stub
		Session s=sessionFactory.openSession();
		s.saveOrUpdate(sp);
		s.close();
	}

	@Override
	public List<Supplier> getAllSupplier() {
		// TODO Auto-generated method stub
		Session s=sessionFactory.openSession();
		List<Supplier>spl=s.createQuery("from Supplier").list();
		s.close();
		return spl;
	}

	@Override
	public Supplier getSupplierById(int id) {
		// TODO Auto-generated method stub
		Session s=sessionFactory.openSession();
		Transaction tr=s.beginTransaction();
		Supplier sp=(Supplier) s.load(Supplier.class, new Integer(id));
		tr.commit();
		return sp;
	}

	@Override
	public void deleteSupplier(int id) {
		// TODO Auto-generated method stub
		Session s=this.sessionFactory.openSession();
		Transaction tr=s.beginTransaction();
		Supplier sp=(Supplier) s.get(Supplier.class, new Integer(id));
		if(null!=sp)
		{
			s.delete(sp);
		}
		tr.commit();
		s.close();
	}

	@Override
	public void updateSupplier(Supplier sp) {
		// TODO Auto-generated method stub
		Session s=sessionFactory.openSession();
		Transaction t=s.beginTransaction();
		s.update(sp);
		t.commit();
		s.close();
		System.out.println("Details Updated");
	}

}
