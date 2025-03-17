import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

@WebServlet("/StudentLoginServlet")
public class Log extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        JSONObject jsonResponse = new JSONObject();

        if ("sachin".equals(username) && "pass123".equals(password)) {
            jsonResponse.put("status", "success");
            jsonResponse.put("message", "Login successful");
        } else {
            jsonResponse.put("status", "error");
            jsonResponse.put("message", "Invalid username or password");
        }

        response.getWriter().write(jsonResponse.toString());
    }
}
