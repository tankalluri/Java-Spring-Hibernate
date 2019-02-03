import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.Map;


public class Part6 extends HttpServlet{

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{

    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int t=0;
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Children Count Display</title>");
        out.println("</head>");
        out.println("<body>");
        String[] names=request.getParameterValues("child");
            out.println("<ul>");
            for(int i=0;i<names.length;i++){
                out.println("<li><b>Name of child "+(++t)+" :</b>"+names[i]+"</li>");
            }
            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");
    }

}