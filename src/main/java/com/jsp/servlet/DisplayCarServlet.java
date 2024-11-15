package com.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DisplayCarServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int carId = Integer.parseInt(req.getParameter("carId"));
		
		// jdbc logic
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_cardb", "root", "120054");

			PreparedStatement pst = conn.prepareStatement("SELECT * FROM car WHERE car_id = ?");
			pst.setInt(1, carId);

			ResultSet rs = pst.executeQuery();
			res.setContentType("text/html");
			PrintWriter out = res.getWriter();

			while (rs.next()) {
				out.println("<h1>Car Id: " + rs.getInt(1) + "</h1>");
				out.println("<h1>Car Brand: " + rs.getString(2) + "</h1>");
				out.println("<h1>Car Model: " + rs.getString(3) + "</h1>");
				out.println("<h1>Car Price: " + rs.getInt(4) + "</h1>");
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
