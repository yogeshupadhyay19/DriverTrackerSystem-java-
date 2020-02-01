package com.servlets;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.pojo.Drive;

import com.utility.UtilityJson;

@WebServlet("/CreateDrive")
public class CreateDrive extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BufferedReader br = request.getReader();
		String s = br.readLine();

		Drive rp = (Drive) UtilityJson.getObjectFromJSON(s, Drive.class);


		Map<String, String> map = null;
		try {
			map = DaoUtil.addData(rp);
		} catch (Exception e) {

		}

		String jsonstr = (String) UtilityJson.getJSONFromObject(map);

		PrintWriter pw = response.getWriter();

		pw.write(jsonstr);

	}

}
