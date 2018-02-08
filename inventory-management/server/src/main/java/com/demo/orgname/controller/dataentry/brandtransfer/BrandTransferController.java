package com.demo.orgname.controller.dataentry.brandtransfer;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * http://localhost:8082/brandTransfer/neatToChhat/26-01-2018/5111
 * @author adityakumar
 *
 */
@RestController
@RequestMapping("/brandTransfer")
public class BrandTransferController {

	@RequestMapping(value="/neatToChhat/{date}/{quantity}", method= RequestMethod.GET)
    public void transferNeatBrandToChhatInProductGodown(@PathVariable String date, @PathVariable String quantity) {
		System.out.println("date: " + date);
		System.out.println("quantity: " + quantity);
    }
	
	@RequestMapping(value="/chaatToNeat/{date}/{quantity}", method= RequestMethod.GET)
    public void transferChhatBrandToNeatInProductGodown(@PathVariable String date, @PathVariable String quantity) {
		System.out.println("date: " + date);
		System.out.println("quantity: " + quantity);
    }
	
}
