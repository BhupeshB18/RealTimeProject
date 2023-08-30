package com.nt.controller;
import com.nt.vo.EmployeeVO;
import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeMgmtService;
import com.nt.service.IEmployeeMgmtService;
public class MainController {
	
	private IEmployeeMgmtService service;
	
	public MainController(EmployeeMgmtService service) {
		this.service=service;
	}
	public String processEmployee(EmployeeVO vo) throws Exception{
		
		EmployeeDTO dto=new EmployeeDTO();
		
		dto.setEname(vo.getEname());
		dto.setDesg(vo.getDesg());
		dto.setBasicSalary(Float.parseFloat(vo.getBasicSalary()));
		
		String result=service.registerEmployee(dto);
		return result;
	}

}

