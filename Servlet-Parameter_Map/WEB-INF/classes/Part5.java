import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.Map;


public class Part5 extends HttpServlet{

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Information Display</title>");
        out.println("</head>");
        out.println("<body>");
        Map<String,String[]> mapVal=request.getParameterMap();

        for(String param:mapVal.keySet()){
            String[] value=(String[])mapVal.get(param);
            out.println("<ul>");
            for(String val:value){
                out.println("<li><b>Parameter Value:</b>"+val+"</li>");
            } 
            out.println("</ul>");  
        }
            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");
    }

}