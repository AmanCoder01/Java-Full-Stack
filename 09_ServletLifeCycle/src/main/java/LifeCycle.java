import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class LifeCycle extends GenericServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("Init called- Servlet Initialization....");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("Service called- Handle service");
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("<h1>Hello Servlet lifecycle</h1>");
    }

    @Override
    public void destroy() {
        System.out.println("Destroy called- Servlet Destroy....");
    }
}
