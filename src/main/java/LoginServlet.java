import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    // When user visits /login...

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get session info, store as variable "session"
        HttpSession session = request.getSession();

        // Check if the user is already signed in and redirect to profile page if they visit /login if they are
        if(session.getAttribute("user") != null) {
            response.sendRedirect("/profile");
        }

        // Display the login JSP page if they are not already logged in
        else {
            request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
        }
    }


    //  When "submit" is clicked on login page...

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // Get session info, store as variable "session"
        HttpSession session = request.getSession();

        // Store username as string
        String username = request.getParameter("username");

        // Store password as string
        String password = request.getParameter("password");
        boolean validAttempt = username.equals("admin") && password.equals("password");


        // Check if login attempt is valid. If so, set session key of "user" to their username. If not, redirect to the login page.
        if (validAttempt) {
            session.setAttribute("user", username);
            response.sendRedirect("/profile");
        } else {
            response.sendRedirect("/login");
        }
    }
}
