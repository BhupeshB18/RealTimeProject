package com.nt.test;

import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.controller.MainController;
import com.nt.vo.EmployeeVO;

public class RealtimeDITest {
	
	public static void main(String []args) {
		
		DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		
		MainController controller=factory.getBean("controller",MainController.class);
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Employee name");
		String name=sc.next();
		System.out.println("Enter desg name");
		String desg=sc.next();
		System.out.println("Enter basicSalary name");
		String basicSalary=sc.next();
		
		EmployeeVO vo=new EmployeeVO();
		
		vo.setEname(name);vo.setDesg(desg);vo.setBasicSalary(basicSalary);
		
		try {
			String result=controller.processEmployee(vo);
			System.out.println(result);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Internal Problem: "+e.getMessage());
			}
		
		
	}

}
