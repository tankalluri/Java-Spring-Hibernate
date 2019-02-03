import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;


public class Part4 extends HttpServlet{

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Information Display</title>");
        out.println("</head>");
        out.println("<body>");
        Enumeration en=request.getParameterNames();	
		while(en.hasMoreElements())
		{
			Object objOri=en.nextElement();
			String param=(String)objOri;
			String value[]=request.getParameterValues(param);
            out.println("<p><b>Parameter Name: </b>"+param+"</p>");
            out.println("<ul>");
            for(int v=0;v<value.length;v++){
                out.println("<li><b>Parameter Value:</b>"+value[v]+"</li>");
            }
            out.println("</ul>");
            
        }
        out.println("</body>");
        out.println("</html>");
    }

}