package com.servlets;

import com.pojo.Drive;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.dao.DaoUtil;
import com.utility.UtilityJson;

/**
 * Servlet implementation class DeleteData
 */
@WebServlet("/DeleteDrive")
public class DeleteDrive extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("hi i am post");
		BufferedReader br = request.getReader();
		String s = br.readLine();

		try {
			Map<String, String> map = DaoUtil.deleteData(s);

			String responseData = (String) UtilityJson.getJSONFromObject(map);

			response.getWriter().write(responseData);

			response.flushBuffer();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
