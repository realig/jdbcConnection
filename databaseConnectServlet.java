import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.HttpServlet.*;
import javax.HttpServletRequest.*;
import javax.HttpServletResponse,*;

public class MyServlet extends HttpServlet {

  public void doPost(HttpServletRequest req, HttpServletResponse res)
                                throws ServletException, IOException {
    res.setContentType("text/plain");
    PrintWriter out = res.getWriter();

    Connection con = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "user", "passwd");

      // set connect
      con.setAutoCommit(false);

      Statement stmt = con.createStatement();
      stmt.executeUpdate("UPDATE INVENTORY SET STOCK = (STOCK - 10) ");
      stmt.executeUpdate("UPDATE SHIPPING SET SHIPPED = (SHIPPED + 10)");

      con.commit();
      out.println(" successful!  Thanks!");
    }
    catch (Exception e) {
      // rollback for any error
      try {
        con.rollback();
      }
      catch (SQLException ignored) { }
      out.println(" failed. Please contact.");
    }
    finally {
      // Clean..
      try {
        if (con != null) con.close();
      }
      catch (SQLException ignored) { }
    }
  }
}
