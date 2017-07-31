package com.lendingtree.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.lendingtree.model.LoanApply;
import com.lendingtree.service.ApplyLoanService;
public class PDFBuilder extends AbstractITextPdfView{
	@Autowired
	private ApplyLoanService apploanService;
	@SuppressWarnings("unchecked")
	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			Document doc, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		// TODO Auto-generated method stub
		  // get data model which is passed by the Spring container
      /*  List<Book> listBooks = (List<Book>) model.get("listBooks");*/
		
		List<LoanApply> li = (List<LoanApply>)model.get("li");
		System.out.println(" Printing list is------------"+li);
		doc.add(new Paragraph("Customers Details are"));
         
        PdfPTable table = new PdfPTable(10);
        table.setWidthPercentage(100.0f);
        table.setWidths(new float[] {15.0f, 15.0f, 15.0f, 15.0f, 15.0f,15.0f,15.0f,15.0f,15.0f,15.0f});
        table.setSpacingBefore(15);
         
        // define font for table header row
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(BaseColor.WHITE);
         
        // define table header cell
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.BLUE);
        cell.setPadding(5);
         
        // write table header
        cell.setPhrase(new Phrase("Loan Id", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("User Id", font));
        table.addCell(cell);
 
        cell.setPhrase(new Phrase("First Name", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Loan Type", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Bank Type", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Interest", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Loan Amount", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Loan Applied Date", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Loan Sanction/Reject Date", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Status", font));
        table.addCell(cell);
         
        // write table row data
        for (LoanApply lp : li) {
            table.addCell(String.valueOf(lp.getId()));
            table.addCell(String.valueOf(lp.getRegid()));
            table.addCell(lp.getFirstname());
            table.addCell(lp.getLoantype());
            table.addCell(lp.getBanktype());
            table.addCell(lp.getInterestrate());
            table.addCell(lp.getLoanamount());
            table.addCell(lp.getLoanapplydate());
            table.addCell(lp.getLoanacceptdate());
            table.addCell(lp.getStatus());
        }
         
        doc.add(table);
         
    }
	}


