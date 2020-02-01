package com.dao;

import com.pojo.Drive;
import com.pojo.Register;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DaoUtil {
	final static String dbDriver = "com.mysql.cj.jdbc.Driver";
	final static String dbURL = "jdbc:mysql://localhost:3306/thinkquotienttracker?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

	final static String dbUsername = "root";
	final static String dbPassword = "root";

	public static Connection getDBConnection() throws SQLException, ClassNotFoundException {

		Class.forName(dbDriver);
		Connection con = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
		return con;
	}

	public static Map<String, String> addData(Drive rp) {

		Map<String, String> m = new HashMap<>();
		try (Connection con = DaoUtil.getDBConnection();
				PreparedStatement ps = con.prepareStatement(
						"insert into drive(company_name, noofresourses, exp_required, ctc, wposition, joining_criteria,edu_crt,follow_up,bond,gstnumber) values(?,?,?,?,?,?,?,?,?,?)")) {

			ps.setObject(1, rp.getCompany_name());
			ps.setObject(2, rp.getNoofresourses());
			ps.setObject(3, rp.getExp_required());
			ps.setObject(4, rp.getCtc());
			ps.setObject(5, rp.getWposition());
			ps.setObject(6, rp.getJoining_criteria());
			ps.setObject(7, rp.getEdu_crt());
			ps.setObject(8, rp.getFollow_up());
			ps.setObject(9, rp.getBond());
			ps.setObject(10, rp.getGstnumber());

			int status = ps.executeUpdate();

			if (status == 1) {
				m.put("Data", "succesfully register");
			} else {
				m.put("Data", "error");
			}
			System.out.println("map object=" + m);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return m;

	}

	public static ArrayList<Drive> getUserDataFromDB() {
		ArrayList<Drive> al = new ArrayList<>();
		try (Connection con = DaoUtil.getDBConnection();
				PreparedStatement ps = con.prepareStatement("select * from drive");
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				Drive rp = new Drive();
				rp.setDid(rs.getInt(1));
				rp.setCompany_name(rs.getString(2));
				rp.setNoofresourses(rs.getInt(3));
				rp.setExp_required(rs.getInt(4));
				rp.setCtc(rs.getInt(5));
				rp.setBond(rs.getFloat(6));
				rp.setWposition(rs.getInt(7));
				rp.setFollow_up(rs.getDate(8));
				rp.setEdu_crt(rs.getInt(9));
				rp.setJoining_criteria(rs.getInt(17));
				rp.setGstnumber(rs.getString(18));
				al.add(rp);
			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return al;

	}

	public static Map<String, String> updateData(Drive r) {

		Map<String, String> m = new HashMap<>();

		try (Connection con = DaoUtil.getDBConnection();
				PreparedStatement ps = con.prepareStatement(
						"update drive set  company_name=?, noofresourses=?, exp_required=?, ctc=?, wposition=?, joining_criteria=?,edu_crt=?,follow_up=?,bond=?,gstnumber=? where did=?")) {

			ps.setObject(1, r.getCompany_name());
			ps.setObject(2, r.getNoofresourses());
			ps.setObject(3, r.getExp_required());
			ps.setObject(4, r.getCtc());
			ps.setObject(5, r.getWposition());
			ps.setObject(6, r.getJoining_criteria());
			ps.setObject(7, r.getEdu_crt());
			ps.setObject(8, r.getFollow_up());
			ps.setObject(9, r.getBond());
			ps.setObject(10, r.getGstnumber());
			ps.setObject(11, r.getDid());
			

			int status = ps.executeUpdate();

			if (status == 1) {
				m.put("Data", "succesfully updated");
			} else {
				m.put("Data", "error");
			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return m;

	}

	public static Map<String, String> deleteData(String r) {
		Map<String, String> mp = new HashMap<>();
		try (Connection con = DaoUtil.getDBConnection();

				PreparedStatement ps = con.prepareStatement("delete from drive where did=?")) {

			ps.setObject(1, r);
			ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();

		}
		return mp;
	}

	public static Map<String, String> registerData(Register rp) {

		Map<String, String> m = new HashMap<>();
		try (Connection con = DaoUtil.getDBConnection();
				PreparedStatement ps = con.prepareStatement(
						"insert into registration(firstname,lastname,username,password) values(?,?,?,?)")) {

			ps.setObject(1, rp.getFirstname());
			ps.setObject(2, rp.getLastname());
			ps.setObject(3, rp.getUsername());
			ps.setObject(4, rp.getPassword());

			int status = ps.executeUpdate();

			if (status == 1) {
				m.put("Data", "succesfully register");
			} else {
				m.put("Data", "error");
			}
			System.out.println("map object=" + m);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return m;

	}

	public static Map<String, String> login(Register r) {

		Map<String, String> m = new HashMap<>();
		try (Connection con = DaoUtil.getDBConnection();
				PreparedStatement ps = con
						.prepareStatement("select * from registration where username=? and password=?");) {
			ps.setString(1, r.getUsername());
			ps.setString(2, r.getPassword());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				m.put("login", "successful");
			} else {
				m.put("login", "unsuccessful please enter valid username or password");
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return m;

	}
}
