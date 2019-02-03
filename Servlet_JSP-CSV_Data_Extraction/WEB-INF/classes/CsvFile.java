import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.relique.jdbc.csv.CsvDriver;


public class CsvFile extends HttpServlet{

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String fileName="";
        fileName= request.getParameter("fileName");
        String path = "D:\\MSIS\\Web Tools\\Assignment-Questions";
        Class.forName("org.relique.jdbc.csv.CsvDriver");
        Connection con= DriverManager.getConnection("jdbc:relique:csv:"+path);
        Statement stmt= con. createStatement();
        ResultSet rs= stmt.executeQuery("select * from "+fileName);
        out.println("<html>");
        out.println("<head>");
        out.println("<title>CSV Data from SalesOrder</title></head>");
        out.println("<body>");
	    out.println("<table border=1 align=\"center\">");
        out.println("<th>SalesOrderId</th>");
        out.println("<th>RevisionNumber</th>");
        out.println("<th>OrderDate</th>");
        out.println("<th>DueDate</th>");
        out.println("<th>ShipDate</th>");
        out.println("<th>Status</th>");
        out.println("<th>OnlineOrderFlag</th>");
        out.println("<th>SalesOrderNumber</th>");
        out.println("<th>PurchaseOrderNumber</th>");
        out.println("<th>AccountNumber</th>");
        out.println("<th>CustomerID</th>");
        out.println("<th>SalesPersonID</th>");
        out.println("<th>TerritoryID</th>");
        out.println("<th>BillToAddressID</th>");
        out.println("<th>ShipToAddressId</th>");
        out.println("<th>ShipMethodID</th>");
        out.println("<th>CreditCardID</th>");
        out.println("<th>CreditCardApprovalCode</th>");
        out.println("<th>SubTotal</th>");
        out.println("<th>TaxAmt</th>");
        out.println("<th>Freight</th>");
        out.println("<th>TotalDue</th>");
        out.println("<th>Comment</th>");
        out.println("<th>ModifiedDate</th>");
        while(rs.next()){
            out.println("<tr>");
            out.println("<td>"+rs.getString("SalesOrderId")+"</td>");
            out.println("<td>"+rs.getString("RevisionNumber")+"</td>");
            out.println("<td>"+rs.getString("OrderDate")+"</td>");
            out.println("<td>"+rs.getString("DueDate")+"</td>");
            out.println("<td>"+rs.getString("ShipDate")+"</td>");
            out.println("<td>"+rs.getString("Status")+"</td>");
            out.println("<td>"+rs.getString("OnlineOrderFlag")+"</td>");
            out.println("<td>"+rs.getString("SalesOrderNumber")+"</td>");
            out.println("<td>"+rs.getString("PurchaseOrderNumber")+"</td>");
            out.println("<td>"+rs.getString("AccountNumber")+"</td>");
            out.println("<td>"+rs.getString("CustomerID")+"</td>");
            out.println("<td>"+rs.getString("SalesPersonID")+"</td>");
            out.println("<td>"+rs.getString("TerritoryID")+"</td>");
            out.println("<td>"+rs.getString("BillToAddressID")+"</td>");
            out.println("<td>"+rs.getString("ShipToAddressId")+"</td>");
            out.println("<td>"+rs.getString("ShipMethodID")+"</td>");
            out.println("<td>"+rs.getString("CreditCardID")+"</td>");
            out.println("<td>"+rs.getString("CreditCardApprovalCode")+"</td>");
            out.println("<td>"+rs.getString("SubTotal")+"</td>");
            out.println("<td>"+rs.getString("TaxAmt")+"</td>");
            out.println("<td>"+rs.getString("Freight")+"</td>");
            out.println("<td>"+rs.getString("TotalDue")+"</td>");
            out.println("<td>"+rs.getString("Comment")+"</td>");
            out.println("<td>"+rs.getString("ModifiedDate")+"</td>");
            out.println("</tr>");
        }
	    out.println("</table>");
        out.println("</body>");
        out.println("</html>");
        
        out.println("Welcome home");
        
    }
    catch(Exception e){

    }
}

}