import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CountServlet", urlPatterns = "/count")
public class CountServlet extends HttpServlet {

    public static int count;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        String reset = req.getParameter("reset");
        PrintWriter out = res.getWriter();

        if(reset != null && reset.equalsIgnoreCase("true")) {
            count = 1;
        } else {
            count++;
        }

        out.println("<h1>You are visitor number: " + count + "</h1>");
    }
}