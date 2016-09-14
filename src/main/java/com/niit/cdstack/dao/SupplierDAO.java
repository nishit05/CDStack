package com.niit.cdstack.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.cdstack.model.Supplier;

@Repository
public interface SupplierDAO {
	void addSupplier(Supplier c);
	List<Supplier> getAllSupplier();
	Supplier getSupplierById(int id);
	void deleteSupplier(int id);
	void updateSupplier(Supplier p);
}
