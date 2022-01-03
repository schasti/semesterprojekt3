import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name="HelloServlet",
        urlPatterns = ""
)

public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("LoginSide.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  {
    }
}

