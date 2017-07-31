package com.lendingtree.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.springframework.web.servlet.view.document.AbstractJExcelView;

import com.lendingtree.model.LoanApply;





public class ExcelBuilder extends AbstractJExcelView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			WritableWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		List<LoanApply> li = (List<LoanApply>) model.get("li");
	
			// create a new Excel sheet
			WritableSheet sheet = workbook.createSheet("LoanApply", 0);
			
			// create header row
			sheet.addCell(new Label(0, 0, "Id"));
			sheet.addCell(new Label(1, 0, "Reg Id"));
			sheet.addCell(new Label(2, 0, "First Name"));
			sheet.addCell(new Label(3, 0, "Loan Type"));
			sheet.addCell(new Label(4, 0, "Bank Type"));
			sheet.addCell(new Label(5, 0, "Interest"));
			sheet.addCell(new Label(6, 0, "Loan Amount"));
			sheet.addCell(new Label(7, 0, "Loan Applied Date"));
			sheet.addCell(new Label(8, 0, "Loan Sanction/Reject Date"));
			sheet.addCell(new Label(9, 0, "Status"));
			
			// create data rows
			int rowCount = 1;
			
			for (LoanApply lp : li) {
			System.out.println("excell data ");
				sheet.addCell(new jxl.write.Number(0, rowCount, lp.getId()));
				sheet.addCell(new jxl.write.Number(1, rowCount, lp.getRegid()));
				sheet.addCell(new Label(2, rowCount, lp.getFirstname()));
				sheet.addCell(new Label(3, rowCount, lp.getLoantype()));
				sheet.addCell(new Label(4, rowCount, lp.getBanktype()));
				sheet.addCell(new Label(5, rowCount, lp.getInterestrate()));
				sheet.addCell(new Label(6, rowCount, lp.getLoanamount()));
				sheet.addCell(new Label(7, rowCount, lp.getLoanapplydate()));
				sheet.addCell(new Label(8, rowCount, lp.getLoanacceptdate()));
				sheet.addCell(new Label(9, rowCount, lp.getStatus()));
				
			
				
				rowCount++;
			}
		
	}

	

	

}
