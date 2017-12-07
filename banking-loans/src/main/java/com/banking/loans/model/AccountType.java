package com.banking.loans.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;

@Table(name="acc_types", schema="banking")
@Entity
public class AccountType {

	@Id
	@Column(name="acc_type_id",nullable=false,length=1)
	private Integer accTypeId;
	
	@Column(name="acc_type_desc",nullable=false,length=50)
	private String accTypeDescription;
	
	@Column(name="acc_type_code",nullable=false,length=4)
	private String accTypeCode;

	public Integer getAccTypeId() {
		return accTypeId;
	}

	public void setAccTypeId(Integer accTypeId) {
		this.accTypeId = accTypeId;
	}

	public String getAccTypeDescription() {
		return accTypeDescription;
	}

	public void setAccTypeDescription(String accTypeDescription) {
		this.accTypeDescription = accTypeDescription;
	}

	public String getAccTypeCode() {
		return accTypeCode;
	}

	public void setAccTypeCode(String accTypeCode) {
		this.accTypeCode = accTypeCode;
	}
		
}
