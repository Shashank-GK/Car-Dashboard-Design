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

public class UpdateCarServlet extends GenericServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// Extracting data from the UI
		int carId = Integer.parseInt(req.getParameter("carId"));
		String carModel=req.getParameter("carModel");
		String carBrand=req.getParameter("carBrand");
		int carPrice = Integer.parseInt(req.getParameter("carPrice"));

		//JDBC logic
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_cardb","root","120054");
			PreparedStatement pst = conn.prepareStatement("UPDATE car SET carModel =?,carPrice=? WHERE carId=?" );
			pst.setInt(3, carId);
			pst.setString(1, carModel);
			pst.setInt(2, carPrice);

			int rowsUpdated = pst.executeUpdate();

			PrintWriter out = res.getWriter();
			if(rowsUpdated>0) {
				out.print("<h1>"+rowsUpdated+"Data Updated Succesfully!! </h1>");
			}else {
				out.print("<h1>Data not updated! </h1>");
			}
		} catch (ClassNotFoundException | SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(conn!= null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

