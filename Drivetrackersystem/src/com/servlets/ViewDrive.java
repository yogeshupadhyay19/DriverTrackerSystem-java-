package com.servlets;
import com.pojo.Drive;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.dao.DaoUtil;

import com.utility.UtilityJson;
import com.pojo.Drive;

@WebServlet("/ViewDrive")
public class ViewDrive extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			ArrayList<Drive> al = DaoUtil.getUserDataFromDB();
			
			String responseData = (String) UtilityJson.getJSONFromObject(al);

			response.getWriter().write(responseData);

			response.flushBuffer();

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
			
}


