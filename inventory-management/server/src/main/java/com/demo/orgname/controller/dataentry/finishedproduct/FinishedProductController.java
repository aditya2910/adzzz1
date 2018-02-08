package com.demo.orgname.controller.dataentry.finishedproduct;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/finishedProduct")
public class FinishedProductController {
	
	@RequestMapping(value="/brandWiseLabelling/{date}/{productCode}/{quantity}", method= RequestMethod.GET)
    public void brandWiseLabelling(@PathVariable String date, @PathVariable String productCode, @PathVariable String quantity) {
		// productCode - e.g.- BR01
		// quantity - e.g.- BR01 is in some product godown and this no. of biris is getting added to it.
		System.out.println("date: " + date);
		System.out.println("productCode: " + productCode);
		System.out.println("quantity: " + quantity);
    }
	
	@RequestMapping(value="/storeRoomEntry/{date}/{productCode}/{godownCode}/{quantity}", method= RequestMethod.GET)
    public void storeRoomEntry(@PathVariable String date, @PathVariable String productCode,
    		@PathVariable String godownCode, @PathVariable String quantity) {
		// this is done brand godown
		// products from respective product brand godowns is sent to market after packing here
		// productCode - e.g.- BR01 -- biri brand code
		// godownCode - this is godown code of respective product/biri brand
		// quantity - e.g.- BR01 is in some product godown and this no. of biris is getting added to it.
		System.out.println("date: " + date);
		System.out.println("productCode: " + productCode);
		System.out.println("godownCode: " + godownCode);
		System.out.println("quantity: " + quantity);
		
		//return serial no. of bags to be populated with incremented value from last done
    }
}



