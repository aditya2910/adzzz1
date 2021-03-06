package com.demo.orgname.pf.dao.person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "master_pf_person", catalog = "org_pf")
public class MasterPfPerson {
	// TODO: create a seperate autoGen for this table id as it means company account no.
	@Id
	@TableGenerator(name = "TABLE_GEN", table = "T_GENERATOR", pkColumnName = "GEN_KEY", pkColumnValue = "MONITOR2012.T_JUST_FOR_TEST", valueColumnName = "GEN_VALUE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
	@Column(name = "id", nullable = false)
	private long id;
	
	private String name;
	@Column(unique=true, nullable = false)
	private String pfPortalMemberId; // TODO: part of company account id
	private String relationship;
	private String fatherOrHusbandName;
	private String gender;
	private String contractorCode;
	private String dateOfBirth;
	private String maritalStatus;
	private String mobileNo;
	private String address;
	@Column(unique=true, nullable = false)
	private String uanNo;
	private String pensionNo;
	private String dateOfJoining;
	private String dateOfLeaving;
	private String reasonOfLeaving;
	private String dateOfEntryForLeaving;
	private String schemeCertificateNo;
	private String ppoNo;
	private String education;
	private String branchCode;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPfPortalMemberId() {
		return pfPortalMemberId;
	}
	public void setPfPortalMemberId(String pfPortalMemberId) {
		this.pfPortalMemberId = pfPortalMemberId;
	}
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	public String getFatherOrHusbandName() {
		return fatherOrHusbandName;
	}
	public void setFatherOrHusbandName(String fatherOrHusbandName) {
		this.fatherOrHusbandName = fatherOrHusbandName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getContractorCode() {
		return contractorCode;
	}
	public void setContractorCode(String contractorCode) {
		this.contractorCode = contractorCode;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUanNo() {
		return uanNo;
	}
	public void setUanNo(String uanNo) {
		this.uanNo = uanNo;
	}
	public String getPensionNo() {
		return pensionNo;
	}
	public void setPensionNo(String pensionNo) {
		this.pensionNo = pensionNo;
	}
	public String getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getDateOfLeaving() {
		return dateOfLeaving;
	}
	public void setDateOfLeaving(String dateOfLeaving) {
		this.dateOfLeaving = dateOfLeaving;
	}
	public String getReasonOfLeaving() {
		return reasonOfLeaving;
	}
	public void setReasonOfLeaving(String reasonOfLeaving) {
		this.reasonOfLeaving = reasonOfLeaving;
	}
	public String getDateOfEntryForLeaving() {
		return dateOfEntryForLeaving;
	}
	public void setDateOfEntryForLeaving(String dateOfEntryForLeaving) {
		this.dateOfEntryForLeaving = dateOfEntryForLeaving;
	}
	public String getSchemeCertificateNo() {
		return schemeCertificateNo;
	}
	public void setSchemeCertificateNo(String schemeCertificateNo) {
		this.schemeCertificateNo = schemeCertificateNo;
	}
	public String getPpoNo() {
		return ppoNo;
	}
	public void setPpoNo(String ppoNo) {
		this.ppoNo = ppoNo;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	
	
}
