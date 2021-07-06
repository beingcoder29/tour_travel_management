package dao;


import java.sql.*;


import dto.HotelDto;
import utilities.ConnectionFactory;

public class HotelDao {
	
		Connection cn=null;
		Statement st=null;
		ResultSet rs=null;
		PreparedStatement ps=null;
		String insert_sql="insert into hotel values(?,?,?)";
		String delete_sql="delete from hotel where hotelid=?";
		String update_sql="update hotel set hotelnm=?,place=? where hotelid=?";
		String check_id="select hotelid from hotel where hotelid=?";
		
		public boolean insertData(HotelDto rdto)throws SQLException
		{
			boolean f=false;
			try
			{
				ConnectionFactory con=new ConnectionFactory();
				cn=con.getConn();
				ps=cn.prepareStatement(insert_sql);
				ps.setString(1,rdto.getHotelid());
				ps.setString(2,rdto.getHotelnm());
				ps.setString(3,rdto.getPlace());
			
				ps.executeUpdate();
				f=true;
				
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			return f;
		}
		public boolean checkhotel(HotelDto rdto) throws SQLException {
			boolean f=true;
			
			try {
			ConnectionFactory con=new ConnectionFactory();
			cn=con.getConn();
			
			ps=cn.prepareStatement("select hotelid from hotel where hotelid=?");
			ps.setString(1,rdto.getHotelid());
			
			
			rs=ps.executeQuery();
			
			while(rs.next()){
				f=false;
			}
			
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			return f;
		}	
		public boolean deleteData(HotelDto rdto)
		{
			boolean f=false;
			try
			{
				ConnectionFactory con=new ConnectionFactory();
				cn=con.getConn();
				ps=cn.prepareStatement(delete_sql);
				ps.setString(1,rdto.getHotelid());
				ps.executeUpdate();
				f=true;
				
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			return f;
		}
		public boolean updateData(HotelDto rdto)
		{
			boolean f=false;
			try
			{
				ConnectionFactory con=new ConnectionFactory();
				cn=con.getConn();
				ps=cn.prepareStatement(update_sql);
				ps.setString(3,rdto.getHotelid());
				ps.setString(1,rdto.getHotelnm());
				ps.setString(2,rdto.getPlace());		
				ps.executeUpdate();
				f=true;
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			return f;
		}
	
public String getHotelName(String place1)
{
	System.out.print(place1);
	String sql="select hotelnm from hotel where place='"+place1+"'";
	String hotelnm=null;
	try
	{
		ConnectionFactory con=new ConnectionFactory();
		cn=con.getConn();
		st=cn.createStatement();
		rs=st.executeQuery(sql);
		while(rs.next())
		{
			hotelnm=rs.getString(1);	
			
		}
	}
	
	catch(SQLException se)
	{
		se.printStackTrace();
	}
	return hotelnm;
}
public ResultSet getData()
{
	String select_sql="select * from hotel order by hotelid";
	
	try
	{
		ConnectionFactory con=new ConnectionFactory();
		cn=con.getConn();
		st=cn.createStatement();
		rs=st.executeQuery(select_sql);
		while(rs.next())
		{
			HotelDto hdto=new HotelDto();
			hdto.setHotelid(rs.getString(1));
			hdto.setHotelnm(rs.getString(2));
			hdto.setPlace(rs.getString(3));
			
			
			
		}
	}
	
	catch(SQLException se)
	{
		se.printStackTrace();
	}
	return rs;

}
}

