package com.demo.orgname.controller.report.stockgodown;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.orgname.service.report.stockgodown.StockGodownServiceImpl;

@RestController
@RequestMapping("/report")
public class StockGodownController {
	
	@Autowired
	private StockGodownServiceImpl stockGodownService;

	@RequestMapping(value="/stockGodown/{fromDate}/{toDate}", method= RequestMethod.GET)
    public void getStockGodownReport(@PathVariable String fromDate, @PathVariable String toDate) {
		stockGodownService.getStockGodownReport(fromDate, toDate);
	}
}
