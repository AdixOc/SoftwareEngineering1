package dev.tupac.helloworldservlet;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "demoServlet1", value = "")
public class DemoServlet1 extends HttpServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("Hello World");
        System.out.println("Hello World");
    }

    public void destroy() {
    }
}