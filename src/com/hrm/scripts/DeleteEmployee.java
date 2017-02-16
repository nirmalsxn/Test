package com.hrm.scripts;

import org.testng.annotations.Test;

import com.hrm.base.BaseTest;
import com.hrm.pages.DashboardPage;
import com.hrm.pages.EmpInfoPage;

import generics.Excel;

public class DeleteEmployee extends BaseTest
{
	@Test
	public void testDeleteEmployee()
	{
		int rc=Excel.getRowCount(INPUT_PATH, "DeleteEmployee");
		for(int i=1;i<=rc;i++)
		{
			String AEPage = Excel.getCellValue(INPUT_PATH, "DeleteEmployee", i, 0);
			String fn = Excel.getCellValue(INPUT_PATH, "DeleteEmployee", i, 1);

		
		DashboardPage dp= new DashboardPage(driver);
		dp.clickPIM_Menu();
		
		EmpInfoPage eiPage=new EmpInfoPage(driver);
		eiPage.verifyURLhas(AEPage);
		
		eiPage.clickEmpCheckbox(fn);
		
		eiPage.clickDelete();
		
		eiPage.clickOk();
		
		eiPage.verifyElementIsPresentOrNot(fn);
		}
		
	}

}
