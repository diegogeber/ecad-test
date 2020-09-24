package br.com.ecad.sgaapi.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(content = Include.NON_NULL)
public class ObjectResponseDTO {

	private String userName;
	private String cpfCnpj;
	private String slipNumber;
	private String slipValue;
	private String occurrenceType;
	private Date occurrenceDate;
		
	public ObjectResponseDTO() {
		super();
	}
	
	public ObjectResponseDTO(String userName, String cpfCnpj, String slipNumber, String slipValue,
			String occurrenceType, Date occurrenceDate) {
		super();
		this.userName = userName;
		this.cpfCnpj = cpfCnpj;
		this.slipNumber = slipNumber;
		this.slipValue = slipValue;
		this.occurrenceType = occurrenceType;
		this.occurrenceDate = occurrenceDate;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	public String getSlipNumber() {
		return slipNumber;
	}
	public void setSlipNumber(String slipNumber) {
		this.slipNumber = slipNumber;
	}
	public String getSlipValue() {
		return slipValue;
	}
	public void setSlipValue(String slipValue) {
		this.slipValue = slipValue;
	}

	public String getOccurrenceType() {
		return occurrenceType;
	}

	public void setOccurrenceType(String occurrenceType) {
		this.occurrenceType = occurrenceType;
	}

	public Date getOccurrenceDate() {
		return occurrenceDate;
	}

	public void setOccurrenceDate(Date occurrenceDate) {
		this.occurrenceDate = occurrenceDate;
	}
}
