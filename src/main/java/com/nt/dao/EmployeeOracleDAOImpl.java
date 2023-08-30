package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.*;

import com.nt.bo.EmployeeBO;
public class EmployeeOracleDAOImpl implements IEmployeeDAO{
	
	//has-a-property
	private DataSource ds;
	private static final String EMP_INSERT_QUERY="INSERT INTO REALTIMEDI_SPRING_EMPLOYEES VALUES(?,?,?,?,?)";
	public EmployeeOracleDAOImpl(DataSource ds) {
		
		this.ds = ds;
	}
	
	
	@Override
	public int insertEmployee(EmployeeBO bo)throws Exception{
		int result=0;
		try(Connection con=ds.getConnection();
				PreparedStatement ps=con.prepareStatement(EMP_INSERT_QUERY);
				)
				{
			ps.setString(1,bo.getEname());
			ps.setString(2,bo.getDesg());
			ps.setFloat(3,bo.getBasicSalary());
			ps.setFloat(4, bo.getGrossSalary());
			ps.setFloat(5,bo.getNetSalary());
			
			result=ps.executeUpdate();
				}
		catch(SQLException se) {
			se.printStackTrace();
			throw se;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	
	/*@Override
	public int insertEmployee(EmployeeBO bo)throws Exception{
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(EMP_INSERT_QUERY);
			ps.setInt(1,bo.getEno());
			ps.setString(2,bo.getEname());
			ps.setString(3,bo.getDesg());
			ps.setFloat(4,bo.getBasicSalary());
			ps.setFloat(5, bo.getGrossSalary());
			ps.setFloat(6,bo.getNetSalary());
			
			result=ps.executeUpdate();
		}
		catch(SQLException se) {
			se.printStackTrace();
			throw se;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			try {
				if(ps!=null) {
					ps.close();
				}
			}catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null) {
					con.close();
				}
			}catch(SQLException se) {
				se.printStackTrace();
			}
		}
		return result;
	}*/


}
