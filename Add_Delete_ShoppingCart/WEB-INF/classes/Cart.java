import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;


public class Cart extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String op = request.getParameter("operation");
        HttpSession session = request.getSession();

        if(op.equalsIgnoreCase("viewCartItems")){

            Enumeration e = (Enumeration) (session.getAttributeNames());

            out.println("<html>");
            out.println("<body>");
            out.println("<h2>The following items have been added to your shopping cart successfully</h2>");
            out.println("<div>");

            while (e.hasMoreElements()) {
                String attribute = (String) e.nextElement();
                String[] arr = (String[]) session.getAttribute(attribute);

                for(String a : arr){
                    out.println(""+a);
                    out.println("<form method = 'post' action = 'cart?operation=delete&item="+a+"'>");
                    out.println("<input type='submit' value='Delete Item'><br/>");
                    out.println("</form>");
                }
            }

            out.println("</div>");
            out.println("</br></br>");
            out.println("<a href='Books.html'>[Go to Books Page]</a>");
            out.println("<a href='Music.html'>[Go to Music Page]</a>");
            out.println("<a href='Laptops.html'>[Go to Computers Page]</a>");
            out.println("</body>");
            out.println("</html>");
        }
        
        else if(op.equalsIgnoreCase("delete")){

            String item = request.getParameter("item");

            List<String> books = new ArrayList<String>();
            List<String> music = new ArrayList<String>();;
            List<String> laptops = new ArrayList<String>();;
            if(session.getAttribute("books") != null){
                books = new ArrayList<>(Arrays.asList( (String[]) session.getAttribute("books") ));
            }
            if(session.getAttribute("music") != null){
                music = new ArrayList<>(Arrays.asList( (String[]) session.getAttribute("music") ));
            }
            
            if(session.getAttribute("laptops") != null){
                laptops = new ArrayList<>(Arrays.asList( (String[]) session.getAttribute("laptops") ));
            }


            for(String book : books){
                if(book.equalsIgnoreCase(item)){
                    books.remove(book);
                    break;
                }
            }
            for(String m : music){
                if(m.equalsIgnoreCase(item)){
                    music.remove(m);
                    break;
                }
            }
            for(String comp : laptops){
                if(comp.equalsIgnoreCase(item)){
                    laptops.remove(comp);
                    break;
                }
            }

            String[] booksArr = (String[]) books.toArray(new String[books.size()]);
            String[] musicArr = (String[]) music.toArray(new String[music.size()]);
            String[] compArr = (String[]) laptops.toArray(new String[laptops.size()]);


            session.setAttribute("books", booksArr);
            session.setAttribute("music", musicArr);
            session.setAttribute("laptops", compArr);


            out.println("<html>");
            out.println("<body>");
            out.println("<h2>Item deleted successfully</h2>");
            out.println("</br></br>");
            out.println("<form action = 'cart?operation=viewCartItems' method = 'post'>");
            out.println("<input type='submit' value='View Cart'><br/><br/><br/>");
            out.println("</form>");
            out.println("<nav>");
            out.println("<a href='Books.html'>[Go to Books Page]</a>");
            out.println("<a href='Music.html'>[Go to Music Page]</a>");
            out.println("<a href='Laptops.html'>[Go to Computers Page]</a>");
            out.println("</nav>");
            out.println("</body>");
            out.println("</html>"); 
   }

   else if(op.equalsIgnoreCase("addItemToCart")){

    if(request.getParameterValues("books") != null){
        session.setAttribute("books", request.getParameterValues("books"));
    }

    if(request.getParameterValues("music") != null){
        session.setAttribute("music", request.getParameterValues("music"));
    }

    if(request.getParameterValues("laptops") != null){
        session.setAttribute("laptops", request.getParameterValues("laptops"));
    }

    out.println("<html>");
    out.println("<body>");
    out.println("<nav>");
    out.println("<a href='Books.html'>Books</a>&nbsp;&nbsp;&nbsp;");
    out.println("<a href='Music.html'>Music</a>&nbsp;&nbsp;&nbsp;");
    out.println("<a href='Laptops.html'>Computers</a>");
    out.println("</nav>");
     out.println("</body>");
    out.println("</html>");
    return;

    }

    }
}
