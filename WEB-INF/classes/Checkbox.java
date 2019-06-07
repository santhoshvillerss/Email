import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import javax.servlet.http.*; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Checkbox")
public class Checkbox extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			HttpSession session=request.getSession(false); 
			String name=(String)session.getAttribute("uname");  
			if(name==null)
			{
				response.sendRedirect("index.jsp");
			}
			String id = request.getParameter("reference2");
			db.database.connection();
			db.database.checkbox(id);
			db.database.close();
		}
		catch(Exception e){}
	}
}