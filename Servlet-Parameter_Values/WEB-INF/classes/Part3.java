import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Part3 extends HttpServlet{

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String c = request.getParameter("country");
        String[] hobby = request.getParameterValues("hobby");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String cpass = request.getParameter("cpass");
        String pic = request.getParameter("pic");
        String[] gender = request.getParameterValues("gen");
        String add= request.getParameter("add");
        String g="";
        for(String ge: gender){
            if(ge.equals("f"))
            g="Female";
            else
            g="Male";
        }
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Information Display</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p><b>Email:</b> " + email +"</p>");
        out.println("<p><b>Password: </b>" + pass +"</p>");
        out.println("<p><b>Retyped Password: </b>" + cpass +"</p>");
        out.println("<p><b>Picture path: </b>" + pic +"</p>");
        out.println("<p><b>Gender: </b>" + g +"</p>");
        out.println("<p><b>Address:</b> " + add +"</p>");
        out.println("<p><b>Country: </b>"+c+"</p>");
        out.println("<p><b>Hobbies: </b></p>");
        out.println("<ul>");
        for(String h: hobby){
            out.println("<li>"+h+"</li>");
        }
        out.println("</body>");
        out.println("</html>");
    }

}