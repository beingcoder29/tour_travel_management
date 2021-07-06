package dao;
import java.sql.*;
import dto.AllotDto;
import utilities.ConnectionFactory;
public class AllotDao {
	Connection cn=null;
			Statement st=null;
			ResultSet rs=null;
			ResultSet rs1=null;
			PreparedStatement ps=null;
			PreparedStatement ps1=null;
			String insert_sql="insert into allot values(?,?)";
			
			
			public boolean allotData(AllotDto rdto)throws SQLException
			{
				boolean f=false;
				try
				{
					ConnectionFactory con=new ConnectionFactory();
					cn=con.getConn();
					ps=cn.prepareStatement(insert_sql);
					ps.setString(1,rdto.getPackageid());
					ps.setString(2,rdto.getHotelid());
			
					ps.executeUpdate();
					f=true;
					
				}
				catch(SQLException se)
				{
					se.printStackTrace();
				}
				return f;
			}
			public boolean check(AllotDto rdto) throws SQLException {
				boolean f=false;
				
				try {
				ConnectionFactory con=new ConnectionFactory();
				cn=con.getConn();
				ps=cn.prepareStatement("select packageid from package where packageid=?");
				ps1=cn.prepareStatement("select hotelid from hotel where hotelid=?");
				
				
				ps.setString(1,rdto.getPackageid());
				ps1.setString(1,rdto.getHotelid());
				
				rs = ps.executeQuery();
				rs1=ps1.executeQuery();
				if(rs.next()){
					if(rs1.next())
					   f=true;
				}
				
				}
				catch(SQLException se)
				{
					se.printStackTrace();
				}
				return f;
			}
			public ResultSet getData() {
				String select_sql="select p.packageid,p.packagenm,p.days,p.date,p.packagecost,h.hotelid,h.hotelnm,h.place from package p,hotel h,allot a where p.packageid=a.packageid and a.hotelid=h.hotelid";
				
					
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


