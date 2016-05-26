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
	public Vector<DanhMuc> AllDanhMuc() {
		Vector<DanhMuc> danhmucvt=new Vector<DanhMuc>();
		try {
			String sql="select id_dm,title,link,super_id from danhmuc order by super_id";
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
			return danhmucvt;
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
	
	/*Lấy dnh muc theo id*/
	public DanhMuc DanhMuc_ID(int id_dm) {	
		try {
			String sql="select id_dm,title,link,super_id from danhmuc where id_dm=?";
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
	public boolean AddDanhMuc(DanhMuc dam) {	
		try {
			String sql="insert into danhmuc(link,title,super_id) values(?,?,?)";		
			pre=connection.prepareStatement(sql);
			pre.setString(1,dam.getLink());
			pre.setString(2,dam.getTitle());
			pre.setInt(3,dam.getSuper_id());			
			return executeUpdateDM(pre);			
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
	public boolean DelDanhMuc(int id) {
		try {
			String sql="delete from danhmuc where id_dm=?";
			pre=connection.prepareStatement(sql);
			pre.setInt(1,id);
			return executeUpdateDM(pre);
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
	public boolean editDanhMuc(DanhMuc dam) {
		try {
			String sql="update DanhMuc set link=?,title=?,super_id=? where id_dm=?";
			pre=connection.prepareStatement(sql);
			pre.setString(1,dam.getLink());
			pre.setString(2,dam.getTitle());
			pre.setInt(3,dam.getSuper_id());
			pre.setInt(4,dam.getId());
			return executeUpdateDM(pre);
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
	
	/*hàm xử lý các executeUpdate()*/
	private boolean executeUpdateDM(PreparedStatement pre) throws SQLException {
        if (pre != null) {	         
            int numRow = pre.executeUpdate();
            if (numRow>0) {                  
               return true;
            }	            
            return false;
        }
        return false;
	}
	 
	public DanhMuc KiemTra(HttpServletRequest request) {
		String[] loi = {"loi"};
		request.setAttribute("loi", loi);
		return null;
	}
	
	/*public static void main(String[] a) {
		DanhMucDAO dmdao=new DanhMucDAO();
		DanhMuc dam=new DanhMuc();
		dam.setLink("javascript:void(0");
		dam.setTitle("Cửa đi 4 cánh mở quay");
		dam.setSuper_id(7);
		dam.setId(14);
//		boolean bo=dmdao.AddDanhMuc(dam);
		//boolean bo=dmdao.DellDanhMuc(12);
		//boolean bo=dmdao.editDanhMuc(dam);
		//System.out.println("add ?"+bo);
		
		
		Vector<DanhMuc> vt=dmdao.AllDanhMuc();
//		if(vt.size()==0){
//			System.out.println("khong co gia tri");
//		}
	//	DanhMuc vt=dmdao.DanhMuc_ID(11);
		for(DanhMuc item:vt){
			System.out.println(item.getSuper_id());
		}
		
		if(vt!=null){
		System.out.println("dsds"+vt.getTitle());
		}
		
	}
*/
}
