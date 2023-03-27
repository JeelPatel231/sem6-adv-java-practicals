package mypackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AuthFilter implements Filter {

  private String password;

  @Override
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
      throws ServletException, IOException {
    String pass = req.getParameter("password");
    if (!pass.equals(this.password)) {
      PrintWriter out = res.getWriter();
      out.println("Wrong Password");
      return;
    }
    chain.doFilter(req, res);
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    this.password = filterConfig.getInitParameter("password-param");
    System.out.println(this.password);
  }

}
