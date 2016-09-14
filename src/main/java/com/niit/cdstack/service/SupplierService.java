package com.niit.cdstack.service;

import java.util.List;

import com.niit.cdstack.model.Supplier;

public interface SupplierService {
	void addSupplier(Supplier p);

	List<Supplier> getAllSupplier();

	Supplier getSupplierById(int id);

	void deleteSupplier(int id);
	
	void updateSupplier(Supplier p);
}
