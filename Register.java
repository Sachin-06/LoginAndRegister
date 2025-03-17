import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

@WebServlet("/StudentRegisterServlet")
public class Register extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String type = request.getParameter("type");

        JSONObject jsonResponse = new JSONObject();

        if (name != null && email != null && password != null && type != null) {
            jsonResponse.put("status", "success");
            jsonResponse.put("message", "User registered successfully");
        } else {
            jsonResponse.put("status", "error");
            jsonResponse.put("message", "All fields are required");
        }

        response.getWriter().write(jsonResponse.toString());
    }
}
