package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import lang.Lang;
import models.DanhMuc;
import utils.ConnectDB;

public class DanhMucDAO {
	private PreparedStatement pre;
	private Connection connection;
	private ResultSet rs;
	
	public DanhMucDAO() {
				 
	}	
	
	/*Lấy tất cả các danh mục trong db*/
	public Vector<DanhMuc> allDanhMuc() {
		connection=ConnectDB.ConnectData();
		Vector<DanhMuc> danhmucvt=new Vector<DanhMuc>();
		try {
			String sql="select id_dm,title,super_id from danhmuc where delete_at is null order by super_id, id_dm";
			pre=connection.prepareStatement(sql);
			rs=pre.executeQuery();
			while(rs.next()) {
				DanhMuc dam=new DanhMuc();
				dam.setId(rs.getInt("id_dm"));
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
	
	public Vector<DanhMuc> allDanhMuc(int superID) {
		connection=ConnectDB.ConnectData();
		Vector<DanhMuc> danhmucvt=new Vector<DanhMuc>();
		try {
			String sql="select id_dm,title,super_id from danhmuc where super_id=? and delete_at is null";
			pre=connection.prepareStatement(sql);
			pre.setInt(1, superID);
			rs=pre.executeQuery();
			while(rs.next()) {
				DanhMuc dam=new DanhMuc();
				dam.setId(rs.getInt("id_dm"));
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
	
	public ArrayList<Integer> subIdDanhMuc(int id) {
		connection=ConnectDB.ConnectData();
		ArrayList<Integer> subIdList = new ArrayList<Integer>();
		try {
			String sql="select id_dm from danhmuc where super_id=? and delete_at is null";
			pre=connection.prepareStatement(sql);
			pre.setInt(1, id);
			rs=pre.executeQuery();
			while(rs.next()) {
				subIdList.add(rs.getInt("id_dm"));
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
		ArrayList<Integer> subIdList0 = new ArrayList<Integer>();
		ArrayList<Integer> subIdList1;
		if(subIdList.size()>0)for(Integer subId: subIdList) {
			subIdList0.add(subId);
			subIdList1 = subIdDanhMuc(subId);
			if(subIdList1.size()>0) for(Integer subId1: subIdList1) {
				subIdList0.add(subId1);		
			}
		}
		return subIdList0;
	}
	
	/*Lấy dnh muc theo id*/
	public DanhMuc findDM(int id_dm) {	
		connection=ConnectDB.ConnectData();
		try {
			String sql="select id_dm,title,detail,super_id from danhmuc where id_dm=? and delete_at is null";
			pre=connection.prepareStatement(sql);
			pre.setInt(1,id_dm);
			DanhMuc dam=new DanhMuc();
			rs=pre.executeQuery();
			if(rs.next()) {				
				dam.setId(rs.getInt("id_dm"));
				dam.setTitle(rs.getString("title"));
				dam.setDetail(rs.getString("detail"));
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
		connection=ConnectDB.ConnectData();
		try {
			String sql="insert into danhmuc(title,detail,super_id,create_at) values(?,?,?,now())";		
			pre=connection.prepareStatement(sql);
			pre.setString(1,dam.getTitle());
			pre.setString(2, dam.getDetail());
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
		connection=ConnectDB.ConnectData();
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
		connection=ConnectDB.ConnectData();
		try {
			String sql="update danhmuc set title=?,detail=?,update_at=now() where id_dm=? and delete_at is null";
			pre=connection.prepareStatement(sql);
			pre.setString(1,dam.getTitle());
			pre.setString(2, dam.getDetail());
			pre.setInt(3,dam.getId());
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
	 
	public DanhMuc validAdd(HttpServletRequest request, int supID) {
		Lang lang = new Lang();
		ArrayList<String> loi = new ArrayList<String>();
		DanhMuc danhmuc = new DanhMuc();
		danhmuc.setTitle(request.getParameter("title"));
		danhmuc.setDetail(request.getParameter("detail"));
		danhmuc.setSuper_id(supID);
		if(danhmuc.getTitle() == null || danhmuc.getTitle().equals("")) {
			loi.add(lang.getValMsg("title_require"));
		}
		if(loi.size()>0) {
			request.getSession().setAttribute("flash_valid", loi.toArray(new String[loi.size()]));
			danhmuc = null;
		}
		return danhmuc;
	}
	
	public DanhMuc validUdt(HttpServletRequest request, int id) {
		Lang lang = new Lang();
		ArrayList<String> loi = new ArrayList<String>();
		DanhMuc danhmuc = findDM(id);
		if(danhmuc!=null) {
			danhmuc.setTitle(request.getParameter("title").trim());
			danhmuc.setDetail(request.getParameter("detail"));
			if(danhmuc.getTitle() == null || danhmuc.getTitle().equals("")) {
				loi.add(lang.getValMsg("title_require"));
			}
			if(loi.size()>0) {
				request.getSession().setAttribute("flash_valid", loi.toArray(new String[loi.size()]));
				danhmuc = null;
			}
		}	

		return danhmuc;
	}
	
	public boolean canAddDM(int supID) {
		int d = 0;
		DanhMuc danhmuc = findDM(supID);
		if(danhmuc!=null) {
			while(danhmuc.getSuper_id()>0) {
				d++;
				danhmuc = findDM(danhmuc.getSuper_id());
			}
			return d<2;
		}
		return supID == 0;
	}
}
