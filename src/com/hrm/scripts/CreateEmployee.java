package com.hrm.scripts;

import org.testng.annotations.Test;

import com.hrm.base.BaseTest;
import com.hrm.pages.AddEmpPage;
import com.hrm.pages.DashboardPage;
import com.hrm.pages.EmpPersonalDetailsPage;

import generics.Excel;

public class CreateEmployee extends BaseTest 
{
	 @Test
	 public void testCreateEmployee()
	 {	
	 int rc=Excel.getRowCount(INPUT_PATH, "CreateEmployee");
	 System.out.println(rc);
	 for(int i=1;i<=rc;i++)
	 {
		 
	 String aepURL=Excel.getCellValue(INPUT_PATH,"CreateEmployee",i,0);
	 String fn=Excel.getCellValue(INPUT_PATH,"CreateEmployee",i,1);
	 String ln=Excel.getCellValue(INPUT_PATH,"CreateEmployee",i,2);
	 String vdpURL=Excel.getCellValue(INPUT_PATH,"CreateEmployee",i,3);


	 

		 //click on PIM
		 DashboardPage dbPage=new DashboardPage(driver);
		 dbPage.clickPIM_Menu();
		 //click on Add Emp
		 dbPage.clickAddEmp_Menu();
		 //verify AddEmpPage
		 AddEmpPage aePage=new AddEmpPage(driver);
		 aePage.verifyURLhas(aepURL);
		 //enter valid FN
		 aePage.setFirstName(fn);
		 //enter valid LN
		 aePage.setLastName(ln);
		 //click on Save
		 aePage.clickSubmit();
		 //verify Emp Personal Details page
	 EmpPersonalDetailsPage epdPage=new EmpPersonalDetailsPage(driver);
		 epdPage.verifyURLhas(vdpURL);
		 //verify the FN
		 epdPage.verifyFirstName(fn);
	 }
}
}





