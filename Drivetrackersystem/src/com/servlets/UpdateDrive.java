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

@WebServlet("/UpdateDrive")
public class UpdateDrive extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("hi i am post");
		BufferedReader br = request.getReader();
		String s = br.readLine();
		Drive r = (Drive) UtilityJson.getObjectFromJSON(s, Drive.class);
		System.out.println("javaobject" + r);
		Map<String, String> map = null;
		try {
			map = DaoUtil.updateData(r);
		} catch (Exception e) {

		}

		String jsonstr = (String) UtilityJson.getJSONFromObject(map);

		System.out.println("json string=" + jsonstr);

		PrintWriter pw = response.getWriter();

		pw.write(jsonstr);

	}

}
