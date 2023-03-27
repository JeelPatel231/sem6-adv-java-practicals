package mypackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public final class Servlet2 extends HttpServlet {
  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String n = request.getParameter("userName");
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    out.println("Login Success! Welcome ");
    out.println(n);
  }

}
