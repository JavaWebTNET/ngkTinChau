package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.ConnectDB;
import models.ThongTin;;

public class ThongTinDAO {
	private PreparedStatement pre;
	private Connection connection;
	private ResultSet rs;
	
	public ThongTinDAO() {		
			
	}
	
	public ThongTin AllThongTin() {	
		try {
			connection=ConnectDB.ConnectData();	
			String sql="select id_tt,type_company,name_company,add_company,tel,fax,email,hotline,slogan,word_run,logo from thongtin";
			pre=connection.prepareStatement(sql);
			rs=pre.executeQuery();
			if(rs.next()) {
				ThongTin thongtin=new ThongTin();
				thongtin.setId_tt(rs.getInt("id_tt"));
				thongtin.setType_company(rs.getString("type_company"));
				thongtin.setName_company(rs.getString("name_company"));
				thongtin.setAdd_company(rs.getString("add_company"));
				thongtin.setTel(rs.getString("tel"));
				thongtin.setFax(rs.getString("fax"));
				thongtin.setEmail(rs.getString("email"));
				thongtin.setHotline(rs.getString("hotline"));
				thongtin.setSlogan(rs.getString("slogan"));
				thongtin.setWord_run(rs.getString("word_run"));
				thongtin.setLogo(rs.getString("logo"));
				return thongtin;			
			}
		}
		catch(SQLException ex) {			
			System.out.println("SQLException: " + ex.getMessage());			    
		    System.out.println(ThongTinDAO.class.getName()); 
		    ex.printStackTrace();	    		        
		} 
		finally {			
			ConnectDB.closeConnection(connection,pre, rs);				
		}	
		
		return null;	
	}
	
	public boolean EditThongTin(ThongTin thongtin) {
		try {
			connection=ConnectDB.ConnectData();	
			String sql="update thongtin set name_company=?,type_company=?,add_company=?,tel=?,fax=?,email=?,hotline=?,slogan=?,word_run=? where id_tt=?";
			pre=connection.prepareStatement(sql);
			
			pre.setString(1,thongtin.getName_company());
			pre.setString(2,thongtin.getType_company());
			pre.setString(3,thongtin.getAdd_company());
			pre.setString(4,thongtin.getTel());
			pre.setString(5,thongtin.getFax());
			pre.setString(6,thongtin.getEmail());
			pre.setString(7,thongtin.getHotline());
			pre.setString(8,thongtin.getSlogan());
			pre.setString(9,thongtin.getWord_run());
			pre.setInt(10,thongtin.getId_tt());
			return executeUpdateDM(pre);		
		}
		catch(SQLException ex) {			
			System.out.println("SQLException: " + ex.getMessage());			    
		    System.out.println(ThongTinDAO.class.getName()); 
		    ex.printStackTrace();	    		        
		} 	
		finally {			
			ConnectDB.closeConnection(connection,pre, rs);				
		}
		
		return false;	
	}
	
	/*thêm thông tin*/
	public boolean AddThongTin(ThongTin thongtin) {
		try {
			connection=ConnectDB.ConnectData();	
			String sql="insert into thongtin(type_company,name_company,add_company,tel,fax,email,hotline,slogan,word_run) "
					+ "values(?,?,?,?,?,?,?,?,?)";
			pre=connection.prepareStatement(sql);
			pre.setString(1,thongtin.getType_company());
			pre.setString(2,thongtin.getName_company());
			pre.setString(3,thongtin.getAdd_company());
			pre.setString(4,thongtin.getTel());
			pre.setString(5,thongtin.getFax());
			pre.setString(6,thongtin.getEmail());
			pre.setString(7,thongtin.getHotline());
			pre.setString(8,thongtin.getSlogan());
			pre.setString(9,thongtin.getWord_run());		
			return executeUpdateDM(pre);		
		}
		catch(SQLException ex) {			
			System.out.println("SQLException: " + ex.getMessage());			    
		    System.out.println(ThongTinDAO.class.getName()); 
		    ex.printStackTrace();	    		        
		} 
		finally {			
			ConnectDB.closeConnection(connection,pre, rs);				
		}	
		
		return false;	
	}
	
	/*hàm xử lý các executeUpdate()*/
	private boolean executeUpdateDM(PreparedStatement pre) throws SQLException {
        if(pre != null) {	         
            int numRow = pre.executeUpdate();
            if(numRow>0) {                  
               return true;
            }	            
            return false;
        }
        return false;
    }
	
	public static void main(String[] a) {
		ThongTinDAO ttDAO=new ThongTinDAO();
		ThongTin tt=new ThongTin();
		tt.setId_tt(4);
		tt.setName_company("Skyline");
		tt.setType_company("CÔNG TY CỔ PHẦN SẢN XUẤT VÀ THƯƠNG MẠI");
		tt.setSlogan("Bền vững cánh cửa ngôi nhà");
		tt.setAdd_company("Địa chỉ: Lô 33C đường Mẹ Thứ, Phường Hòa Xuân, Quận Cẩm Lệ, Thành phố Đà Nẵng");
		tt.setEmail("tin.tinchauwindow@gmail.com");
		tt.setHotline("0935 443 117");
		tt.setFax("05113.663.117");
		tt.setTel("05113.663.117");
		tt.setWord_run("Công ty cổ phần sản xuất và thương mại Tín Châu - Chuyên sản xuất - tư vấn thiết kế - lắp đặt nhôm kính....!");
		//boolean hh=ttDAO.AddThongTin(tt);	
		
		/*tt=ttDAO.AllThongTin();
				if(tt==null){
					System.out.println("khong co gia tri trong data");
					return;
				}*/
		boolean sua=ttDAO.EditThongTin(tt);
		
		System.out.println("gia tri duoc in ra la"+sua);
	}
}
