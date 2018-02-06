package com.demo.orgname.controller.brand;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.orgname.dao.brand.ProductType;
import com.demo.orgname.service.brand.ProductTypeServiceImpl;

@RestController
@RequestMapping("/type")
public class ProductTypeController {
	
	@Autowired
	private ProductTypeServiceImpl typeService;
	
	@RequestMapping(method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void save(@RequestBody ProductType brand) {
		typeService.saveType(brand);
    }
	
	@RequestMapping(method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<ProductType> getAll() {
		List<ProductType> brands = typeService.getAllTypes();
        return brands;
    }
	
	@RequestMapping(value="/{id}", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ProductType getById(@PathVariable String id) {
		return typeService.getType(id);
    }

}
