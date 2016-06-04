package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import lang.Lang;
import models.DichVu;
import utils.ConnectDB;

public class DichVuDAO {
	private PreparedStatement pre;
	private Connection connection;
	private ResultSet rs;
	public static int limit = 10;
	
	public DichVuDAO() { 
				 
	}	
	
	public Vector<DichVu> allDichVu() {
		connection=ConnectDB.ConnectData();
		Vector<DichVu> vtdv=new Vector<DichVu>();
		try {		
			String sql="SELECT id_dv,name_dv,image,detail from dichvu where delete_at is null";
			pre=connection.prepareStatement(sql);
			rs=pre.executeQuery();
			while(rs.next()) {
				DichVu dv=new DichVu();
				dv.setId_dv(rs.getInt("id_dv"));
				dv.setName_dv(rs.getString("name_dv"));
				dv.setImage(rs.getString("image"));
				dv.setDetail(rs.getString("detail"));
				vtdv.add(dv);
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
		return vtdv;	
	}
	
	public int offsets() {
		connection=ConnectDB.ConnectData();
		try {		
			String sql="SELECT count(id_dv) as offset from dichvu where delete_at is null";
			pre=connection.prepareStatement(sql);			
			rs=pre.executeQuery();
			if(rs.next()) {
				return rs.getInt("offset");
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
		return 0;
	}
	
	public Vector<DichVu> pageDichVu(int page) {
		connection=ConnectDB.ConnectData();
		Vector<DichVu> vtdv=new Vector<DichVu>();
		try {		
			String sql="SELECT id_dv,name_dv,image,detail from dichvu where delete_at is null limit ? offset ?";
			pre=connection.prepareStatement(sql);
			pre.setInt(1, limit);
			pre.setInt(2, (page-1)*limit);
			rs=pre.executeQuery();
			while(rs.next()) {
				DichVu dv=new DichVu();
				dv.setId_dv(rs.getInt("id_dv"));
				dv.setName_dv(rs.getString("name_dv"));
				dv.setImage(rs.getString("image"));
				dv.setDetail(rs.getString("detail"));
				vtdv.add(dv);
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
		return vtdv;	
	}
	
	public boolean addDichVu(DichVu dv) {	
		connection=ConnectDB.ConnectData();
		try {
			String sql="insert into dichvu(name_dv,image,detail,create_at) values(?,?,?,now())";
			pre=connection.prepareStatement(sql);
			
			pre.setString(1,dv.getName_dv());
			pre.setString(2,dv.getImage());
			pre.setString(3,dv.getDetail());
			
			return pre.executeUpdate()>0;
		}
		catch(SQLException ex) {			
			System.out.println("SQLException: " + ex.getMessage());			    
		    System.out.println(DichVuDAO.class.getName()); 
		    ex.printStackTrace();	    		        
		} 
		finally {			
			ConnectDB.closeConnection(connection,pre, rs);					
		}	
		return false;			
	}
	
	public DichVu findDV(int id) {
		connection=ConnectDB.ConnectData();
		try {		
			String sql="SELECT id_dv,name_dv,image,detail from dichvu where id_dv=? and delete_at is null";
			pre=connection.prepareStatement(sql);
			pre.setInt(1, id);
			rs=pre.executeQuery();
			if(rs.next()) {
				DichVu dv=new DichVu();
				dv.setId_dv(rs.getInt("id_dv"));
				dv.setName_dv(rs.getString("name_dv"));
				dv.setImage(rs.getString("image"));
				dv.setDetail(rs.getString("detail"));
				return dv;
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
	
	public boolean udtDichVu(DichVu dv) {
		connection=ConnectDB.ConnectData();
		try {		
			String sql="update dichvu set name_dv=?,image=?,detail=?,update_at=now() where id_dv=? and delete_at is null";
			pre=connection.prepareStatement(sql);
			pre.setString(1, dv.getName_dv());
			pre.setString(2, dv.getImage());
			pre.setString(3, dv.getDetail());
			pre.setInt(4, dv.getId_dv());
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
	
	public boolean delDichVu(int id) {
		connection=ConnectDB.ConnectData();
		try {		
			String sql="update dichvu set delete_at=now() where id_dv=? and delete_at is null";
			pre=connection.prepareStatement(sql);
			pre.setInt(1, id);
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
	
	public DichVu validAdd(HttpServletRequest request) throws IOException, ServletException {
		ArrayList<String> loi = new ArrayList<String>();
		Lang lang = new Lang();
		Part part = request.getPart("file-image");
		if(part.getSubmittedFileName().equals("")) {
			loi.add(lang.getValMsg("image_null"));
		}
		else {
			String image_dv = ImageDao.imageUpload(request, DichVu.uploadDir, part);
			DichVu dichvu = new DichVu();
			
			if(image_dv!=null) {
				dichvu.setName_dv(request.getParameter("name_dv"));
				dichvu.setDetail(request.getParameter("detail"));
				dichvu.setImage(image_dv);
				return dichvu;
			}
			
		}
		if(loi.size()>0)
			request.getSession().setAttribute("flash_valid", loi.toArray(new String[loi.size()]));
		return null;
	}
	
	public DichVu validUdt(HttpServletRequest request, int id) throws IOException, ServletException {
		Part part = request.getPart("file-image");
		String image_dv = null;
		if(!part.getSubmittedFileName().equals("")) {
			image_dv = ImageDao.imageUpload(request, DichVu.uploadDir, part);  
		}
		
		DichVu dichvu = findDV(id);
		dichvu.setName_dv(request.getParameter("name_dv"));
		dichvu.setDetail(request.getParameter("detail"));
		if(image_dv!=null)
			dichvu.setImage(image_dv);
		return dichvu;
	}
}
