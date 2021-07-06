package dao;

import java.sql.*;

import utilities.ConnectionFactory;

public class LoginDao {
	Connection cn = null;
	Statement st = null;
	ResultSet rs = null;

	public boolean checkLogin(String uname, String pass) {
		String sql = "select * from registration where uname='" + uname + "' and pass='" + pass + "'";
		boolean flag = false;
		try {
			ConnectionFactory con = new ConnectionFactory();
			cn = con.getConn();
			st = cn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				flag = true;
			}

		} catch (SQLException se) {
			se.printStackTrace();
		}
		return flag;
	}
}
