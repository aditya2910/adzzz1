package com.demo.orgname.pf.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.orgname.pf.dao.contractor.ContractorLabourWage;
import com.demo.orgname.pf.dao.contractor.ContractorLabourWageRepository;
import com.demo.orgname.pf.dao.person.MasterPfPerson;
import com.demo.orgname.pf.dao.person.MasterPfPersonRepository;
import com.demo.orgname.pf.dao.report.wagespf.MasterPfPersonWagesPf;
import com.demo.orgname.pf.dao.report.wagespf.MasterPfPersonWagesPfRepository;
import com.demo.orgname.pf.util.Constants;
import com.demo.orgname.pf.util.EcrReportWageAndPf;

@Service
public class PfServiceImpl {
	
	@Autowired
	private ContractorLabourWageRepository contractorLabourWageRepository;
	
	@Autowired
	private MasterPfPersonRepository masterPfPersonRepository;
	
	@Autowired
	private MasterPfPersonWagesPfRepository masterPfPersonWagesPfRepository;

	public void saveConsolidatedPersonWithWageAndPfDistribution() {
		List<ContractorLabourWage> contractorLabourWages = getContractorsCodeWithGrossAndEpfWage();
		
		List<MasterPfPerson> persons = (List<MasterPfPerson>) masterPfPersonRepository.findAll();
		for (MasterPfPerson person : persons) {
			MasterPfPersonWagesPf personWagesPf = new MasterPfPersonWagesPf();
			personWagesPf.setName(person.getName());
			personWagesPf.setReportGenDate(new Date().toString());
			personWagesPf.setUanNo(person.getUanNo());
			
			EcrReportWageAndPf ecrReportWage = getEcrReportWage(person, contractorLabourWages);
			if(ecrReportWage == null) {
				System.out.println("ERROR: NO MATCHING CONTRACTOR FOUND FOR EMPLOYEE HAVING UAN: " + person.getUanNo());
			}
			personWagesPf.setGrossWage(ecrReportWage.getGrossWage());
			personWagesPf.setEpfWage(ecrReportWage.getEpfWage());
			personWagesPf.setEpsWage(ecrReportWage.getEpsWage());
			personWagesPf.setEdliWage(ecrReportWage.getEdliWage());
			personWagesPf.setEePf(ecrReportWage.getEePf());
			personWagesPf.setEpsPf(ecrReportWage.getEpsPf());
			personWagesPf.setErPf(ecrReportWage.getErPf());
			personWagesPf.setNcpDays(String.valueOf(ecrReportWage.getNcpDays()));
			personWagesPf.setRefunds("0");

			masterPfPersonWagesPfRepository.save(personWagesPf);
		}
	}

	private EcrReportWageAndPf getEcrReportWage(MasterPfPerson person, List<ContractorLabourWage> contractorLabourWages) {
		EcrReportWageAndPf ecrReportWageAndPf = new EcrReportWageAndPf();
		for (ContractorLabourWage contractorLabourWage : contractorLabourWages) {
			if(person.getContractorCode().equalsIgnoreCase(contractorLabourWage.getContractorCode())) {
				ecrReportWageAndPf.setGrossWage(contractorLabourWage.getContractorLabourGrossWage());
				ecrReportWageAndPf.setEpfWage(contractorLabourWage.getContractorLabourEpfWage());
				ecrReportWageAndPf.setEpsWage(contractorLabourWage.getContractorLabourEpfWage());
				ecrReportWageAndPf.setEdliWage(contractorLabourWage.getContractorLabourEpfWage());
				
				ecrReportWageAndPf.setEePf(getEePfContribution(contractorLabourWage.getContractorLabourEpfWage()));
				ecrReportWageAndPf.setEpsPf(getEpsPfContribution(contractorLabourWage.getContractorLabourEpfWage()));
				ecrReportWageAndPf.setErPf(String.valueOf(Integer.parseInt(getEePfContribution(contractorLabourWage.getContractorLabourEpfWage()))
						- Integer.parseInt(getEpsPfContribution(contractorLabourWage.getContractorLabourEpfWage()))));
				
				ecrReportWageAndPf.setNcpDays(contractorLabourWage.getNcpDays());
				
				return ecrReportWageAndPf;
			}
		}
		return null;
	}

	

	private String getEpsPfContribution(String epfWage) {
		logErrorIfEpfWageIsNull(epfWage);
		double epsWageContriDouble = (Integer.parseInt(epfWage) * Constants.EPS_CONTRI_PERCENT_ON_EPF_WAGE) / 100;
		int epsWageContri = (int) Math.round(epsWageContriDouble);
		System.out.println("epsWageContri: " + epsWageContri);
		return String.valueOf(epsWageContri);
	}

	private String getEePfContribution(String epfWage) {
		logErrorIfEpfWageIsNull(epfWage);
		double eeWageContriDouble = ((Integer.parseInt(epfWage) * Constants.EE_CONTRI_PERCENT_ON_EPF_WAGE) / 100);
		int eeWageContri = (int) Math.round(eeWageContriDouble);
		System.out.println("eeWageContri: " + eeWageContri);
		return String.valueOf(eeWageContri);
	}

	private void logErrorIfEpfWageIsNull(String epfWage) {
		if(epfWage == null) {
			System.out.println("ERROR: EPF Wage is null. Please make sure that the given wages excel was having text type for all the cell in the file.");
		}
	}

	private List<ContractorLabourWage> getContractorsCodeWithGrossAndEpfWage() {
		return (List<ContractorLabourWage>) contractorLabourWageRepository.findAll();
	}

	public void createECRReport(String filePath) {
		List<MasterPfPersonWagesPf> sasterPfPersonWagesPfReports = (List<MasterPfPersonWagesPf>) masterPfPersonWagesPfRepository.findAll();
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filePath), false));
			// TODO: check date of leaving before appending the employee to ECR report
			for (MasterPfPersonWagesPf reportRow : sasterPfPersonWagesPfReports) {
				String ecrRecordRow = "".concat(reportRow.getUanNo()).concat(Constants.ECR_FILE_DELIMITER).concat(reportRow.getName().trim()).concat(Constants.ECR_FILE_DELIMITER)
					.concat(reportRow.getGrossWage()).concat(Constants.ECR_FILE_DELIMITER)
					.concat(reportRow.getEpfWage()).concat(Constants.ECR_FILE_DELIMITER).concat(reportRow.getEpsWage()).concat(Constants.ECR_FILE_DELIMITER)
					.concat(reportRow.getEdliWage()).concat(Constants.ECR_FILE_DELIMITER)
					.concat(reportRow.getEePf()).concat(Constants.ECR_FILE_DELIMITER).concat(reportRow.getEpsPf()).concat(Constants.ECR_FILE_DELIMITER)
					.concat(reportRow.getErPf()).concat(Constants.ECR_FILE_DELIMITER).concat(reportRow.getNcpDays()).concat(Constants.ECR_FILE_DELIMITER)
					.concat(reportRow.getRefunds());
				bw.write(ecrRecordRow);
				bw.newLine();
			}
			
			
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
