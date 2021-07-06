package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dto.DocDto;
import utilities.ConnectionFactory;

public class DocDao {
	Connection cn=null;
	Statement st=null;
	ResultSet rs=null;
	PreparedStatement ps=null;
	String insert_sql="insert into registration values(?,?,?,?,?)";
//	String delete_sql="delete from registration where uname=?";
//	String update_sql="update registration set pass=? where uname=?";
//	String select_sql="select * from registration";
	public boolean insertData(DocDto rdto)throws SQLException
	{
		boolean f=false;
		try
		{
			ConnectionFactory con=new ConnectionFactory();
			cn=con.getConn();
			ps=cn.prepareStatement(insert_sql);
			ps.setString(1,rdto.getUname());
			ps.setString(2,rdto.getPass());
			ps.setString(3,rdto.getNm());
			ps.setString(4,rdto.getPhno());
			ps.setString(5,rdto.getEmail());
			ps.executeUpdate();
			f=true;
			
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		return f;
	}
	public boolean checkuser(DocDto rdto) throws SQLException {
		boolean f=false;
		
		try {
		ConnectionFactory con=new ConnectionFactory();
		cn=con.getConn();
		ps=cn.prepareStatement("select email from registration where uname=?");
		ps.setString(1,rdto.getUname());
		ps.executeQuery();
		
		rs = ps.executeQuery();
		if(rs.next()){
			return f;
		}
		else {
			f=true;
		}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		return f;
	}		
	
//	public void deleteData(DocDto rdto)
//	{
//		try
//		{
//			ConnectionFactory con=new ConnectionFactory();
//			cn=con.getConn();
//			ps=cn.prepareStatement(delete_sql);
//			ps.setString(1,rdto.getUname());
//			ps.executeUpdate();
//			cn.commit();
//		}
//		catch(SQLException se)
//		{
//			se.printStackTrace();
//		}
//	}
//	public void updateData(DocDto rdto)
//	{
//		try
//		{
//			ConnectionFactory con=new ConnectionFactory();
//			cn=con.getConn();
//			ps=cn.prepareStatement(update_sql);
//			ps.setString(1,rdto.getPass());
//			ps.setString(2,rdto.getUname());
//			ps.executeUpdate();
//			cn.commit();
//		}
//		catch(SQLException se)
//		{
//			se.printStackTrace();
//		}
//	}
//	public ResultSet getData()
//	{
//		try
//		{
//			ConnectionFactory con=new ConnectionFactory();
//			cn=con.getConn();
//			st=cn.createStatement();
//			rs=st.executeQuery(select_sql);
//		}
//		catch(SQLException se)
//		{
//			se.printStackTrace();
//		}
//		return rs;
//	}
	}
