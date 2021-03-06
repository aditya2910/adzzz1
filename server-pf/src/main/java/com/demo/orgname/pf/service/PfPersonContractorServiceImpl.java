package com.demo.orgname.pf.service;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.orgname.pf.dao.contractor.ContractorLabourWage;
import com.demo.orgname.pf.dao.contractor.ContractorLabourWageRepository;
import com.demo.orgname.pf.dao.person.MasterPfPerson;
import com.demo.orgname.pf.dao.person.MasterPfPersonRepository;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@Service
public class PfPersonContractorServiceImpl {
	
	@Autowired
	private MasterPfPersonRepository masterPfPersonRepository;
	
	@Autowired
	private ContractorLabourWageRepository contractorLabourWageRepository;
	
	public List<MasterPfPerson> getAllMasterPfPersons(String fileName){
		return getAllMasterPfPersonsFromMasterPfPersonsFile(fileName);
	}
	
	private List<MasterPfPerson> getAllMasterPfPersonsFromMasterPfPersonsFile(String fileName) {
		List<MasterPfPerson> persons = new ArrayList<>();
		try {
			FileInputStream file = new FileInputStream(new File(fileName));
			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);
			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				MasterPfPerson person = new MasterPfPerson();
				Row row = rowIterator.next();
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					// Check the cell type and format accordingly
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_NUMERIC:
						System.out.print(cell.getNumericCellValue() + " ");
						break;
					case Cell.CELL_TYPE_STRING:
						System.out.print(cell.getStringCellValue() + " ");
						System.out.print(cell.getColumnIndex() + " ");
						if(cell.getColumnIndex() == 1) {
							person.setPfPortalMemberId(cell.getStringCellValue());
						} else if(cell.getColumnIndex() == 2) {
							person.setUanNo(cell.getStringCellValue());
						} else if(cell.getColumnIndex() == 3) {
							person.setContractorCode(cell.getStringCellValue());
						} else if(cell.getColumnIndex() == 4) {
							person.setName(cell.getStringCellValue());
						} else if(cell.getColumnIndex() == 5) {
							person.setFatherOrHusbandName(cell.getStringCellValue());
						} else if(cell.getColumnIndex() == 6) {
							person.setDateOfBirth(cell.getStringCellValue());
						} else if(cell.getColumnIndex() == 7) {
							person.setDateOfJoining(cell.getStringCellValue());
						} else if(cell.getColumnIndex() == 8) {
							person.setGender(cell.getStringCellValue());
						} else if(cell.getColumnIndex() == 9) {
							person.setRelationship(cell.getStringCellValue());
						} else if(cell.getColumnIndex() == 10) {
							person.setMaritalStatus(cell.getStringCellValue());
						} else if(cell.getColumnIndex() == 11) {
							person.setMobileNo(cell.getStringCellValue());
						} else if(cell.getColumnIndex() == 12) {
							person.setBranchCode(cell.getStringCellValue());
						}
						break;
					}
				}
				System.out.println("");
				persons.add(person);
			}
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return persons;
	}

	public void savePfPerson(MasterPfPerson person) {
		masterPfPersonRepository.save(person);
	}

	public List<ContractorLabourWage> getAllContractorLabourWages(String fileName) {
		List<ContractorLabourWage> contractorLabourWages = new ArrayList<>();
		try {
			FileInputStream file = new FileInputStream(new File(fileName));
			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);
			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				ContractorLabourWage contractorLabourWage = new ContractorLabourWage();
				Row row = rowIterator.next();
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					// Check the cell type and format accordingly
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_NUMERIC:
						System.out.print(cell.getNumericCellValue() + " ");
						break;
					case Cell.CELL_TYPE_STRING:
						System.out.print(cell.getStringCellValue() + " ");
						System.out.print(cell.getColumnIndex() + " ");
						if(cell.getColumnIndex() == 0) {
							contractorLabourWage.setContractorCode(cell.getStringCellValue());
						} else if(cell.getColumnIndex() == 1) {
							contractorLabourWage.setContractorLabourGrossWage(cell.getStringCellValue());
							if(Double.parseDouble(cell.getStringCellValue()) == 0) {
								// TODO: set no. of days in current month to NCP days
								contractorLabourWage.setNcpDays(28);
							} else {
								contractorLabourWage.setNcpDays(0);
							}
						} else if(cell.getColumnIndex() == 2) {
							contractorLabourWage.setContractorLabourEpfWage(cell.getStringCellValue());
						}
						break;
					}
				}
				System.out.println("");
				contractorLabourWages.add(contractorLabourWage);
			}
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return contractorLabourWages;
	}

	public void saveContractorLabourWages(ContractorLabourWage contractorLabourWage) {
		contractorLabourWageRepository.save(contractorLabourWage);
	}

	public void saveForm10ToMasterPerson(String fileName) {
		try {
			FileInputStream file = new FileInputStream(new File(fileName));
			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);
			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				String pfPortalMemberId = null;
				String dateOfLeaving = null;
				String reasonOfLeaving = null;
				Row row = rowIterator.next();
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					// Check the cell type and format accordingly
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_NUMERIC:
						System.out.print(cell.getNumericCellValue() + " ");
						break;
					case Cell.CELL_TYPE_STRING:
						System.out.print(cell.getStringCellValue() + " ");
						System.out.print(cell.getColumnIndex() + " ");
						if(cell.getColumnIndex() == 0) {
							pfPortalMemberId = cell.getStringCellValue();
						} else if(cell.getColumnIndex() == 1) {
							dateOfLeaving = cell.getStringCellValue();
						} else if(cell.getColumnIndex() == 2) {
							reasonOfLeaving = cell.getStringCellValue();
						}
						break;
					}
				}
				System.out.println("");
				MasterPfPerson person = masterPfPersonRepository.findByPfPortalMemberId(pfPortalMemberId).get(0);
				person.setDateOfLeaving(dateOfLeaving);
				person.setReasonOfLeaving(reasonOfLeaving);
				person.setDateOfEntryForLeaving(getTodayDate());
				masterPfPersonRepository.save(person);
			}
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private String getTodayDate() {
		String PATTERN="dd-MMM-yy";
		SimpleDateFormat dateFormat=new SimpleDateFormat();
		dateFormat.applyPattern(PATTERN);
		return dateFormat.format(Calendar.getInstance().getTime());
	}
}
