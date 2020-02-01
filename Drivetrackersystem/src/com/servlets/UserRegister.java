package com.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DaoUtil;
import com.pojo.Drive;
import com.pojo.Register;
import com.utility.UtilityJson;

/**
 * Servlet implementation class UserRegister
 */
@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	BufferedReader br = request.getReader();
		String s = br.readLine();
        System.out.println(s);
		Register rp = (Register) UtilityJson.getObjectFromJSON(s, Register.class);


		Map<String, String> map = null;
		try {
			map = DaoUtil.registerData(rp);
		} catch (Exception e) {

		}

		String jsonstr = (String) UtilityJson.getJSONFromObject(map);

		PrintWriter pw = response.getWriter();

		pw.write(jsonstr);
	}

}
