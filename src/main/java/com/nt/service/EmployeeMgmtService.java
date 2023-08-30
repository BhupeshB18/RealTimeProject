package com.nt.service;

import com.nt.dto.EmployeeDTO;
import com.nt.dao.IEmployeeDAO;
import com.nt.bo.EmployeeBO;
import com.nt.dao.EmployeeMySQLDAOImpl;
public final class EmployeeMgmtService implements IEmployeeMgmtService {
	
	private IEmployeeDAO dao;
	
	public EmployeeMgmtService(IEmployeeDAO dao) {
		System.out.println("EmployeeMgmtService:1-param-constructor");
		this.dao=dao;
	}
	
	@Override
	public String registerEmployee(EmployeeDTO dto)throws Exception{
		
		float grossSalary=dto.getBasicSalary()+dto.getBasicSalary()*0.0f;
		float netSalary=grossSalary-dto.getBasicSalary()*0.2f;
		
		EmployeeBO bo=new EmployeeBO();
		
		bo.setEname(dto.getEname());
		bo.setDesg(dto.getDesg());
		bo.setBasicSalary(dto.getBasicSalary());
		bo.setGrossSalary(grossSalary);
		bo.setNetSalary(netSalary);
		
		int count=dao.insertEmployee(bo);
		
		return count==1?"Employee registered with netSalary::"+netSalary:"Employee not registered with netSalary::"+netSalary;
			
	}
	
	

}
