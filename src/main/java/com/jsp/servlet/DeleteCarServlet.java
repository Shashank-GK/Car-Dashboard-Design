package com.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DeleteCarServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// Extract carId from request
		int carId = Integer.parseInt(req.getParameter("carId"));
		
		// Set response content type
		res.setContentType("text/html");

		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_cardb", "root", "120054");

			PreparedStatement pst = conn.prepareStatement("DELETE FROM car WHERE carId = ?");

			pst.setInt(1, carId);

			int rowsDeleted = pst.executeUpdate();
			PrintWriter out = res.getWriter();

			if (rowsDeleted > 0) {
				out.println("<h1>" + rowsDeleted + " record(s) deleted successfully!</h1>");
			} else {
				out.println("<h1>Record not found or unable to delete.</h1>");
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
