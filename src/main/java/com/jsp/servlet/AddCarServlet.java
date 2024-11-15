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

public class AddCarServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int carId=Integer.parseInt(req.getParameter("carId"));
		String carBrand=req.getParameter("carBrand");
		String carModel=req.getParameter("carModel");
		int carPrice=Integer.parseInt(req.getParameter("carPrice"));

		// jdbc logic
		Connection  conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_cardb","root","120054");

			PreparedStatement pst = conn.prepareStatement("insert into car values(?,?,?,?)");

			pst.setInt(1, carId);
			pst.setString(2, carBrand);
			pst.setString(3, carModel);
			pst.setInt(4, carPrice);

			int rowsInserted=pst.executeUpdate();
			PrintWriter out=res.getWriter();
			if(rowsInserted>0) {
				out.println("<h1> "+rowsInserted+" data added successfully</h1>");
			} else {
				out.println("<h1> data not added </h1>");
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
