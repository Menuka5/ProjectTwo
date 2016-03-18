package hsenid;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * This is the servlet class
 */

public class MyServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html"); // Set output as html
		PrintWriter out = resp.getWriter();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Boolean status = false;
		String username = req.getParameter("username"); // Getting parameters
														// from index.jsp
		String password = req.getParameter("password");

		RequestDispatcher view = req.getRequestDispatcher("/translate.jsp");

		try {
			DBConnector mydata = (DBConnector) getServletContext().getAttribute("Database"); // Receive
																								// the
																								// DBConnector
																								// object
																								// created
																								// in
																								// MyListener
																								// class
			Connection myconn = mydata.getConn();// Receiving the connection
			pst = myconn.prepareStatement("select * from users where username=? and password=?");
			Mapping data1 = new Mapping();
			String[] names = { "Menuka", "Ishan" };
			req.setAttribute("name", names);

			// HashMap<String, String> data = (HashMap<String,
			// String>)data1.GetData();
			// req.setAttribute("data", data);
			String[] keys = data1.sendKeys();
			req.setAttribute("keys", keys);

			pst.setString(1, username);
			pst.setString(2, password);
			rs = pst.executeQuery(); // executing the query
			status = rs.next();

			if (status) {
				view.forward(req, resp);
			} else {
				out.println("Failed!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
