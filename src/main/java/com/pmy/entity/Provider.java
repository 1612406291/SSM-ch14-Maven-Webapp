package com.pmy.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * SmbmsProvider entity. @author MyEclipse Persistence Tools
 */

public class Provider {

	// Fields

	private Long id;
	private String proCode;
	private String proName;
	private String proDesc;
	private String proContact;
	private String proPhone;
	private String proAddress;
	private String proFax;
	private Long createdBy;
	private Timestamp creationDate;
	private Timestamp modifyDate;
	private Long modifyBy;
	private String  companyLicPicPath;//营业执照存储路径
	private List<Bill> bills=new ArrayList<Bill>();
	// Constructors

	/** default constructor */
	public Provider() {
	}


	public List<Bill> getBills() {
		return bills;
	}


	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getProCode() {
		return proCode;
	}


	public void setProCode(String proCode) {
		this.proCode = proCode;
	}


	public String getProName() {
		return proName;
	}


	public void setProName(String proName) {
		this.proName = proName;
	}


	public String getProDesc() {
		return proDesc;
	}


	public void setProDesc(String proDesc) {
		this.proDesc = proDesc;
	}


	public String getProContact() {
		return proContact;
	}


	public void setProContact(String proContact) {
		this.proContact = proContact;
	}


	public String getProPhone() {
		return proPhone;
	}


	public void setProPhone(String proPhone) {
		this.proPhone = proPhone;
	}


	public String getProAddress() {
		return proAddress;
	}


	public void setProAddress(String proAddress) {
		this.proAddress = proAddress;
	}


	public String getProFax() {
		return proFax;
	}


	public void setProFax(String proFax) {
		this.proFax = proFax;
	}


	public Long getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}


	public Timestamp getCreationDate() {
		return creationDate;
	}


	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}


	public Timestamp getModifyDate() {
		return modifyDate;
	}


	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}


	public Long getModifyBy() {
		return modifyBy;
	}


	public void setModifyBy(Long modifyBy) {
		this.modifyBy = modifyBy;
	}


	public String getCompanyLicPicPath() {
		return companyLicPicPath;
	}


	public void setCompanyLicPicPath(String companyLicPicPath) {
		this.companyLicPicPath = companyLicPicPath;
	}


	public Provider(Long id, String proCode, String proName, String proDesc,
			String proContact, String proPhone, String proAddress,
			String proFax, Long createdBy, Timestamp creationDate,
			Timestamp modifyDate, Long modifyBy, String companyLicPicPath,
			List<Bill> bills) {
		super();
		this.id = id;
		this.proCode = proCode;
		this.proName = proName;
		this.proDesc = proDesc;
		this.proContact = proContact;
		this.proPhone = proPhone;
		this.proAddress = proAddress;
		this.proFax = proFax;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.modifyDate = modifyDate;
		this.modifyBy = modifyBy;
		this.companyLicPicPath = companyLicPicPath;
		this.bills = bills;
	}
	@Override
	public String toString() {
		return "Provider [id=" + id + ", proCode=" + proCode + ", proName="
				+ proName + ", proDesc=" + proDesc + ", proContact="
				+ proContact + ", proPhone=" + proPhone + ", proAddress="
				+ proAddress + ", proFax=" + proFax + ", createdBy="
				+ createdBy + ", creationDate=" + creationDate
				+ ", modifyDate=" + modifyDate + ", modifyBy=" + modifyBy
				+ ", companyLicPicPath=" + companyLicPicPath + ", bills="
				+ bills + "]";
	}

}