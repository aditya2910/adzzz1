package com.demo.orgname.service.supplier;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.orgname.dao.supplier.Supplier;
import com.demo.orgname.dao.supplier.SupplierRepository;


@Service
public class SupplierServiceImpl {
	
	@Autowired
	private SupplierRepository repository;

	public void saveSupplier(Supplier supplier) {
		repository.save(supplier);
	}

	public List<Supplier> getAllSuppliers() {
		List<Supplier> suppliers = new ArrayList<>();
		repository.findAll()
			.forEach(suppliers::add);
		return suppliers;
	}

}
