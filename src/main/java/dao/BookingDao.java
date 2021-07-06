package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dto.BookingDto;

import utilities.ConnectionFactory;

public class BookingDao {
	Connection cn=null;
	Statement st=null;
	ResultSet rs=null;
	PreparedStatement ps=null;
	
	String insert_sql="insert into booking values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	
	public boolean insertData(BookingDto rdto)throws SQLException
	{
		boolean f=false;
		try
		{
			ConnectionFactory con=new ConnectionFactory();
			cn=con.getConn();
			ps=cn.prepareStatement(insert_sql);
			ps.setString(1,rdto.getBookingid());
			ps.setString(2,rdto.getPackageid());
			ps.setString(3,rdto.getPackagenm());
			ps.setString(4,rdto.getPlace1());
			ps.setString(5,rdto.getPlace2());
			ps.setString(6,rdto.getPlace3());
			ps.setString(7,rdto.getHotelname1());
			ps.setString(8,rdto.getHotelname2());
			ps.setString(9,rdto.getHotelname3());
			ps.setInt(10,rdto.getDays());
			ps.setInt(11,rdto.getPackagecost());
			ps.setString(12,rdto.getDate());
			ps.setString(13,rdto.getBdate());
			ps.setInt(14,rdto.getNum_of_persons());
			ps.setString(15,rdto.getRoom_type());
			ps.setString(16,rdto.getUsername());
			ps.setString(17,rdto.getBank());
			ps.setString(18,rdto.getCardno());
			ps.setString(19,rdto.getPassword());
			ps.setString(20,rdto.getDoe());
			ps.setString(21,rdto.getCvv());
			ps.setDouble(22,rdto.getTotal_price());

			ps.executeUpdate();
			f=true;
			
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		return f;
	}
	public boolean check(BookingDto rdto) throws SQLException {
		boolean f=false;
		
		try {
		ConnectionFactory con=new ConnectionFactory();
		cn=con.getConn();
		ps=cn.prepareStatement("select uname from registration where uname=?");
		ps.setString(1,rdto.getUsername());
		
		
		rs = ps.executeQuery();
		if(rs.next()){
			f=true;
			
		}
		
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		return f;
	}	
	public ResultSet getDataclient(String username) {
		//String sql="select * from booking where username='"+username+"'";
		String select_sql="select * from booking where username='"+username+"'";
			System.out.print(username);
				try
				{
					ConnectionFactory con=new ConnectionFactory();
					cn=con.getConn();
					st=cn.createStatement();
					
					rs=st.executeQuery(select_sql);
					
				}
				catch(SQLException se)
				{
					se.printStackTrace();
				}
				return rs;
			}
	public ResultSet getDataadmin() {
		String select_sql="select * from booking";
		
			
				try
				{
					ConnectionFactory con=new ConnectionFactory();
					cn=con.getConn();
					st=cn.createStatement();
					
					rs=st.executeQuery(select_sql);
				}
				catch(SQLException se)
				{
					se.printStackTrace();
				}
				return rs;
			}
		
}
