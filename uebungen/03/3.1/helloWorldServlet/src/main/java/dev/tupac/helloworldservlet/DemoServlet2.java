package dev.tupac.helloworldservlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DemoServlet2", value = "/hello-name")
public class DemoServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String param = request.getParameter("name");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("Hello "+param);
    }
}
