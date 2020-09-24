package br.com.ecad.sgaapi.dto;

import java.util.Date;

import br.com.ecad.sgaapi.integration.ReturnBradescoDTO;

public class BradescoControl {
	
	private ReturnBradescoDTO ret;
	private String slipNumber;
	private String userBean;
	private Date competenceDate;
	
	public BradescoControl() {}
	public BradescoControl(ReturnBradescoDTO ret,String slipNumber, String userBean, Date competenceDate) {
		super();
		this.slipNumber = slipNumber;
		this.userBean = userBean;
		this.competenceDate = competenceDate;
		this.ret = ret;
	}
		
	public ReturnBradescoDTO getRet() {
		return ret;
	}
	public void setRet(ReturnBradescoDTO ret) {
		this.ret = ret;
	}
	public String getSlipNumber() {
		return slipNumber;
	}

	public void setSlipNumber(String slipNumber) {
		this.slipNumber = slipNumber;
	}

	public String getUserBean() {
		return userBean;
	}

	public void setUserBean(String userBean) {
		this.userBean = userBean;
	}

	public Date getCompetenceDate() {
		return competenceDate;
	}

	public void setCompetenceDate(Date competenceDate) {
		this.competenceDate = competenceDate;
	}
	
	public BradescoControl getBradescoControl(ReturnBradescoDTO ret) {
		BradescoControl bc = new BradescoControl();
		bc.setRet(ret);
		bc.setSlipNumber(ret.getId().toString());
		return bc;
	}
}
