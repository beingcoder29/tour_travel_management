package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import dto.PackageDto;

import utilities.ConnectionFactory;

public class PackageDao {
	Connection cn=null;
	Statement st=null;
	ResultSet rs=null;
	PreparedStatement ps=null;
	String select_sql="select * from package";
	String insert_sql="insert into package values(?,?,?,?,?,?,?,?)";
	String delete_sql="delete from package where packageid=?";
	String update_sql="update package set days=?,date=?,packagecost=? where packageid=?";
	
	public boolean insertData(PackageDto rdto)throws SQLException
	{
		boolean f=false;
		try
		{
			ConnectionFactory con=new ConnectionFactory();
			cn=con.getConn();
			ps=cn.prepareStatement(insert_sql);
			ps.setString(1,rdto.getPackageid());
			ps.setString(2,rdto.getPackagenm());
			ps.setString(3,rdto.getPlace1());
			ps.setString(4,rdto.getPlace2());
			ps.setString(5,rdto.getPlace3());
			ps.setInt(6,rdto.getDays());
			ps.setString(7,rdto.getDate());
			ps.setString(8,rdto.getPackagecost());
			ps.executeUpdate();
			f=true;
			
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		return f;
	}
	public boolean checkpackage(PackageDto rdto) throws SQLException {
		boolean f=true;
		
		try {
		ConnectionFactory con=new ConnectionFactory();
		cn=con.getConn();
		ps=cn.prepareStatement("select packageid from package where packageid=?");
		ps.setString(1,rdto.getPackageid());
		
		
		rs = ps.executeQuery();
		if(rs.next()){
			f=false;
			
		}
		
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		return f;
	}	
	public void deleteData(PackageDto rdto)
	{
		try
		{
			ConnectionFactory con=new ConnectionFactory();
			cn=con.getConn();
			ps=cn.prepareStatement(delete_sql);
			ps.setString(1,rdto.getPackageid());
			ps.executeUpdate();
			
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
	}
	public boolean updateData(PackageDto rdto)
	{
		boolean f=false;
		try
		{
			ConnectionFactory con=new ConnectionFactory();
			cn=con.getConn();
			ps=cn.prepareStatement(update_sql);
			ps.setString(4,rdto.getPackageid());
			ps.setInt(1,rdto.getDays());
			ps.setString(2,rdto.getDate());
			ps.setString(3,rdto.getPackagecost());			
			ps.executeUpdate();
			f=true;
			
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		return f;
	}
	public ResultSet getTourDetails(String packageid)
	{
		
		String sql="select * from package where packageid='"+packageid+"'";
	
		try
		{
			ConnectionFactory con=new ConnectionFactory();
			cn=con.getConn();
			st=cn.createStatement();
			rs=st.executeQuery(sql);
//			while(rs.next())
//			{
//				PackageDto rdto=new PackageDto();
//				//rdto.setTourid(rs.getString(1));
//				rdto.setPackagenm(rs.getString(2));
//				rdto.setPlace1(rs.getString(3));
//				rdto.setPlace2(rs.getString(4));
//				rdto.setPlace3(rs.getString(5));
//				rdto.setDays(rs.getInt(6));
//				rdto.setDate(rs.getString(7));
//				rdto.setPackagecost(rs.getString(8));
//				
//				
//				
//			}
		}
		
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		return rs;
	}
	//public ResultSet getData()
	public ResultSet getData()
	{
		
		try
		{
			ConnectionFactory con=new ConnectionFactory();
			cn=con.getConn();
			st=cn.createStatement();
			rs=st.executeQuery(select_sql);
//			while(rs.next())
//			{
//				PackageDto rdto=new PackageDto();
//				rdto.setPackageid(rs.getString(1));
//				rdto.setPackagenm(rs.getString(2));
//				rdto.setPlace1(rs.getString(3));
//				rdto.setPlace2(rs.getString(4));
//				rdto.setPlace3(rs.getString(5));
//				rdto.setDays(rs.getInt(6));
//				rdto.setDate(rs.getString(7));
//				rdto.setPackagecost(rs.getString(8));
//				
//				return rdto;
				
	//		}
		}
		
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		return rs;
	
	}
}
