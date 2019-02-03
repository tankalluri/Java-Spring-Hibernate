import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.util.Enumeration;

public class Part2 extends HttpServlet{
	PrintWriter out;

    @Override
    public void init(){
        
    }
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/html");
	out= response.getWriter();
	System.out.println("Part 1 - Servlet to show Request Headers");
	Enumeration<String> headerNames= request.getHeaderNames();
	out.println("<html>");
        out.println("<head>");
        out.println("<title>Part 1 - Servlet-Request Headers</title></head>");
        out.println("<body>");
	out.println("<h2 style=\"text-align:center;\">Servlet to show Request Headers and their corresponding values</h2>");
	out.println("<table border=1 align=\"center\">");
        out.println("<th>Request Header Name</th>");
	out.println("<th>Request Header Value</th>");
	
	while(headerNames.hasMoreElements()){
		String val = headerNames.nextElement();
		out.write("<tr><td>"+val+"</td><td>"+request.getHeader(val)+"</td></tr>"); 
		}
	out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
	
	@Override
	public void destroy(){
	out.close();
	}
}