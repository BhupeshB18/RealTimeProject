package com.nt.bo;

public class EmployeeBO {
	// optional for insert use case
	private String ename;
	private String desg;
	private Float basicSalary;
	private Float grossSalary;
	private Float netSalary;

	

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getDesg() {
		return desg;
	}

	public void setDesg(String desg) {
		this.desg = desg;
	}

	public Float getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(Float basicSalary) {
		this.basicSalary = basicSalary;
	}

	public Float getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(Float grossSalary) {
		this.grossSalary = grossSalary;
	}

	public Float getNetSalary() {
		return netSalary;
	}

	public void setNetSalary(Float netSalary) {
		this.netSalary = netSalary;
	}

}
