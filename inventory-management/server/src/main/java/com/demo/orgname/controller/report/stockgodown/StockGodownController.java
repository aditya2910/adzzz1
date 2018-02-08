package com.demo.orgname.controller.report.stockgodown;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
public class StockGodownController {

	@RequestMapping(value="/stockGodown/{fromDate}/{toDate}", method= RequestMethod.GET)
    public void getStockGodownReport(@PathVariable String fromDate, @PathVariable String toDate) {
		
	}
}
