/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author tankalluri
 */
@WebServlet(name = "ExcelExtraction", urlPatterns = {"/ExcelExtraction"})
public class ExcelExtraction extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        FileInputStream inputStream = new FileInputStream(new File("D:\\MSIS\\Web Tools\\Assignment-Questions\\store.xls"));
        File file=new File("D:\\MSIS\\Web Tools\\Assignment-Questions\\store.xls");
        System.out.println(file.getName());
        Workbook workbook = null;
        workbook = WorkbookFactory.create(file);
        Sheet firstSheet  = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();
         while (iterator.hasNext()) {    
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            out.println("<html>");
            out.println("<head>");
            out.println("<title>CSV Data from SalesOrder</title></head>");
            out.println("<body>");
	    out.println("<table border=1 align=\"center\">");
            out.println("<tr>");
            while (cellIterator.hasNext()) {
               
                Cell cell = cellIterator.next();
                switch (cell.getCellType()) {
                    case STRING:
                        out.println("<td width=\"60px\">"+cell.getStringCellValue()+"</td>");
                        break;
                    case BOOLEAN:
                        out.println("<td width=\"60px\">"+cell.getBooleanCellValue()+"</td>");
                        break;
                    case NUMERIC:
                        out.println("<td width=\"60px\">"+cell.getNumericCellValue()+"</td>");
                        break;
                    default:
                        break;
                }
                
            }
            out.println("</tr>");
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
         
        workbook.close();
        inputStream.close(); 
        
        }
    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
