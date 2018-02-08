package com.demo.orgname.controller.brand;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.orgname.dao.brand.ProductBrand;
import com.demo.orgname.service.brand.ProductBrandServiceImpl;

@RestController
@RequestMapping("/brand")
public class ProductBrandController {
	
	@Autowired
	private ProductBrandServiceImpl brandService;
	
	@RequestMapping(method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void save(@RequestBody ProductBrand brand) {
		brandService.saveBrand(brand);
    }
	
	@RequestMapping(method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<ProductBrand> getAll() {
		return brandService.getAllBrands();
    }
	
	@RequestMapping(value="/{id}", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ProductBrand getById(@PathVariable String id) {
		return brandService.getBrand(id);
    }
	
	@RequestMapping(value="/count", method= RequestMethod.GET)
    public int getCount() {
		return brandService.getBrandsCount();
    }
	
	@RequestMapping(method= RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void update(@RequestBody ProductBrand brand) {
		brandService.updateBrand(brand);
    }

}
