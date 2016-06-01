package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import models.DanhMuc;
import utils.ConnectDB;

public class DanhMucDAO {
	private PreparedStatement pre;
	private Connection connection;
	private ResultSet rs;
	
	public DanhMucDAO() {
		connection=ConnectDB.ConnectData();		 
	}	
	
	/*Lấy tất cả các danh mục trong db*/
	public Vector<DanhMuc> allDanhMuc() {
		Vector<DanhMuc> danhmucvt=new Vector<DanhMuc>();
		try {
			String sql="select id_dm,title,link,super_id from danhmuc where delete_at is null order by super_id";
			pre=connection.prepareStatement(sql);
			rs=pre.executeQuery();
			while(rs.next()) {
				DanhMuc dam=new DanhMuc();
				dam.setId(rs.getInt("id_dm"));
				dam.setLink(rs.getString("link"));
				dam.setTitle(rs.getString("title"));
				dam.setSuper_id(rs.getInt("super_id"));
				danhmucvt.add(dam);				
			}
			
		}
		catch(SQLException ex) {			
			System.out.println("SQLException: " + ex.getMessage());			    
		    System.out.println(DanhMucDAO.class.getName()); 
		    ex.printStackTrace();	    		        
		} 
		finally {			
			ConnectDB.closeConnection(connection,pre, rs);					
		}	
		
		return danhmucvt;	
	}
	
	/*Lấy dnh muc theo id*/
	public DanhMuc findDM(int id_dm) {	
		try {
			String sql="select id_dm,title,link,super_id from danhmuc where id_dm=? and delete_at is null";
			pre=connection.prepareStatement(sql);
			pre.setInt(1,id_dm);
			DanhMuc dam=new DanhMuc();
			rs=pre.executeQuery();
			if(rs.next()) {				
				dam.setId(rs.getInt("id_dm"));
				dam.setLink(rs.getString("link"));
				dam.setTitle(rs.getString("title"));
				dam.setSuper_id(rs.getInt("super_id"));
				return dam;			
			}		
		}
		catch(SQLException ex) {			
			System.out.println("SQLException: " + ex.getMessage());			    
		    System.out.println(DanhMucDAO.class.getName()); 
		    ex.printStackTrace();	    		        
		} 
		finally {			
			ConnectDB.closeConnection(connection,pre, rs);				
		}
		
		return null;		
	}

	/*Thêm một danh mục mới, tham số truyền vào là DanhMuc*/
	public boolean addDanhMuc(DanhMuc dam) {	
		try {
			String sql="insert into danhmuc(link,title,super_id,create_at) values(?,?,?,now())";		
			pre=connection.prepareStatement(sql);
			pre.setString(1,dam.getLink());
			pre.setString(2,dam.getTitle());
			pre.setInt(3,dam.getSuper_id());			
			return pre.executeUpdate()>0;			
		}
		catch(SQLException ex) {			
			System.out.println("SQLException: " + ex.getMessage());			    
		    System.out.println(DanhMucDAO.class.getName()); 
		    ex.printStackTrace();	    		        
		} 
		finally {			
			ConnectDB.closeConnection(connection,pre, rs);			
		}	
		
		return false;		
	}
	
	/*hàm xóa một danh mục theo id*/
	public boolean delDanhMuc(int id) {
		try {
			String sql="update danhmuc set delete_at=now() where id_dm=? and delete_at is null";
			pre=connection.prepareStatement(sql);
			pre.setInt(1,id);
			return pre.executeUpdate()>0;
		}
		catch(SQLException ex) {			
			System.out.println("SQLException: " + ex.getMessage());			    
		    System.out.println(DanhMucDAO.class.getName()); 
		    ex.printStackTrace();	    		        
		} 
		finally {			
			ConnectDB.closeConnection(connection,pre,rs);			
		}	
		return false;
	}
	
	/*Hàm sửa DanhMuc theo id,đối số truyền vào la object*/
	public boolean udtDanhMuc(DanhMuc dam) {
		try {
			String sql="update DanhMuc set link=?,title=?,super_id=?,update_at=now() where id_dm=? and delete_at is null";
			pre=connection.prepareStatement(sql);
			pre.setString(1,dam.getLink());
			pre.setString(2,dam.getTitle());
			pre.setInt(3,dam.getSuper_id());
			pre.setInt(4,dam.getId());
			return pre.executeUpdate()>0;
		}
		catch(SQLException ex) {			
			System.out.println("SQLException: " + ex.getMessage());			    
		    System.out.println(DanhMucDAO.class.getName()); 
		    ex.printStackTrace();	    		        
		} 
		finally {			
			ConnectDB.closeConnection(connection,pre,rs);			
		}	
			
		return false;
	}
	 
	public DanhMuc KiemTra(HttpServletRequest request) {
		String[] loi = {"loi"};
		request.setAttribute("loi", loi);
		return null;
	}
}
