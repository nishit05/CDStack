package com.niit.cdstack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.cdstack.dao.SupplierDAO;
import com.niit.cdstack.model.Supplier;

@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierDAO supplierdao;

	@Override
	public void addSupplier(Supplier sp) {
		// TODO Auto-generated method stub
		supplierdao.addSupplier(sp);
	}

	@Override
	public List<Supplier> getAllSupplier() {
		// TODO Auto-generated method stub
		return supplierdao.getAllSupplier();
	}

	@Override
	public Supplier getSupplierById(int id) {
		// TODO Auto-generated method stub
		return supplierdao.getSupplierById(id);
	}

	@Override
	public void deleteSupplier(int id) {
		// TODO Auto-generated method stub
		supplierdao.deleteSupplier(id);
	}

	@Override
	public void updateSupplier(Supplier sp) {
		// TODO Auto-generated method stub
		supplierdao.updateSupplier(sp);
	}

}
