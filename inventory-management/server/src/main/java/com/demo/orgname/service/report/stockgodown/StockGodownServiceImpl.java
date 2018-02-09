package com.demo.orgname.service.report.stockgodown;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.orgname.dao.dataentry.contractorslipentry.ContractorSlipEntryRepository;
import com.demo.orgname.dao.dataentry.inwardofrawmaterial.RawMaterialInwardRepository;
import com.demo.orgname.dao.dataentry.rawmaterialissueforconsumption.RawMaterialIssueForConsumptiondRepository;
import com.demo.orgname.dao.dataentry.rawmaterialwarehousetransfer.RawMaterialWarehouseTransferRepository;

@Service
public class StockGodownServiceImpl {
	
	@Autowired
	private ContractorSlipEntryRepository contractorSlipEntryRepository;
	
	@Autowired
	private RawMaterialInwardRepository rawMaterialInwardRepository;
	
	@Autowired
	private RawMaterialIssueForConsumptiondRepository rawMaterialIssueForConsumptiondRepository;
	
	@Autowired
	private RawMaterialWarehouseTransferRepository rawMaterialWarehouseTransferRepository;

	public void getStockGodownReport(String fromDate, String toDate) {
		// TODO Auto-generated method stub
		
	}

}
