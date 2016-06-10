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
import models.SanPham;
import utils.ConnectDB;

public class SanPhamDAO {
	private PreparedStatement pre;
	private Connection connection;
	private ResultSet rs;
	public static int limit = 12;
	
	public SanPhamDAO() { 
				 
	}	
	
	public Vector<SanPham> allSanPham() {
		connection=ConnectDB.ConnectData();
		Vector<SanPham> vtsp=new Vector<SanPham>();
		try {		
			String sql="SELECT id_sp,title,image,prominent,super_ID from sanpham where delete_at is null";
			pre=connection.prepareStatement(sql);
			rs=pre.executeQuery();
			while(rs.next()) {
				SanPham sp=new SanPham();
				sp.setId(rs.getInt("id_sp"));
				sp.setTitle(rs.getString("title"));
				sp.setImage(rs.getString("image"));
				sp.setProminent(rs.getBoolean("prominent"));
				sp.setSuper_id(rs.getInt("super_ID"));
				vtsp.add(sp);
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
		return vtsp;	
	}
	
	public Vector<SanPham> allproSanPham() {
		connection=ConnectDB.ConnectData();
		Vector<SanPham> vtsp=new Vector<SanPham>();
		try {		
			String sql="SELECT id_sp,title,image,prominent,super_ID from sanpham where prominent=? and delete_at is null order by update_at desc";
			pre=connection.prepareStatement(sql);
			pre.setBoolean(1, true);
			rs=pre.executeQuery();
			while(rs.next()) {
				SanPham sp=new SanPham();
				sp.setId(rs.getInt("id_sp"));
				sp.setTitle(rs.getString("title"));
				sp.setImage(rs.getString("image"));
				sp.setProminent(rs.getBoolean("prominent"));
				sp.setSuper_id(rs.getInt("super_ID"));
				vtsp.add(sp);
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
		return vtsp;	
	}
	
	public int offsets() {
		connection=ConnectDB.ConnectData();
		try {		
			String sql="SELECT count(id_sp) as offset from sanpham where delete_at is null";
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
	
	public int offsets(int idDM) {
		connection=ConnectDB.ConnectData();
		try {		
			String sql="SELECT count(id_sp) as offset from sanpham where super_ID=? and delete_at is null";
			pre=connection.prepareStatement(sql);
			pre.setInt(1, idDM);
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
	
	public int offsetsAll(int idDM) {
		if(idDM == 0)
			return offsets();
		DanhMucDAO danhmucDao = new DanhMucDAO();
		ArrayList<Integer> subIdList = danhmucDao.subIdDanhMuc(idDM);
		subIdList.add(idDM);
		String subIds = subIdList.toString();
		connection=ConnectDB.ConnectData();
		try {		
			String sql="SELECT count(id_sp) as offset from sanpham where super_ID in (?) and delete_at is null";
			pre=connection.prepareStatement(sql);
			pre.setString(1, subIds.substring(1, subIds.length() -1));
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
	
	public Vector<SanPham> pageSanPham(int page) {
		connection=ConnectDB.ConnectData();
		Vector<SanPham> vtsp=new Vector<SanPham>();
		try {		
			String sql="SELECT id_sp,title,image,prominent,super_ID from sanpham where delete_at is null order by update_at desc limit ? offset ?";
			pre=connection.prepareStatement(sql);
			pre.setInt(1, limit);
			pre.setInt(2, (page-1)*limit);
			rs=pre.executeQuery();
			while(rs.next()) {
				SanPham sp=new SanPham();
				sp.setId(rs.getInt("id_sp"));
				sp.setTitle(rs.getString("title"));
				sp.setImage(rs.getString("image"));
				sp.setProminent(rs.getBoolean("prominent"));
				sp.setSuper_id(rs.getInt("super_ID"));
				vtsp.add(sp);
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
		return vtsp;	
	}
	
	public Vector<SanPham> pageSanPham(int page, int idDM) {
		connection=ConnectDB.ConnectData();
		Vector<SanPham> vtsp=new Vector<SanPham>();
		try {		
			String sql="SELECT id_sp,title,image,prominent,super_ID from sanpham where super_ID=? and delete_at is null limit ? offset ?";
			pre=connection.prepareStatement(sql);
			pre.setInt(1, idDM);
			pre.setInt(2, limit);
			pre.setInt(3, (page-1)*limit);
			rs=pre.executeQuery();
			while(rs.next()) {
				SanPham sp=new SanPham();
				sp.setId(rs.getInt("id_sp"));
				sp.setTitle(rs.getString("title"));
				sp.setImage(rs.getString("image"));
				sp.setProminent(rs.getBoolean("prominent"));
				sp.setSuper_id(rs.getInt("super_ID"));
				vtsp.add(sp);
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
		return vtsp;	
	}
	
	public Vector<SanPham> pageAllSanPham(int page, int idDM) {
		if(idDM==0)
			return pageSanPham(page);
		DanhMucDAO danhmucDao = new DanhMucDAO();
		ArrayList<Integer> subIdList = danhmucDao.subIdDanhMuc(idDM);
		subIdList.add(idDM);
		String subIds = subIdList.toString();
		subIds = subIds.substring(1, subIds.length() -1);
		connection=ConnectDB.ConnectData();
		Vector<SanPham> vtsp=new Vector<SanPham>();
		try {		
			String sql="SELECT id_sp,title,image,prominent,super_ID from sanpham where super_ID in ("+ subIds +") and delete_at is null order by update_at desc limit ? offset ?";
			pre=connection.prepareStatement(sql);
			pre.setInt(1, limit);
			pre.setInt(2, (page-1)*limit);
			rs=pre.executeQuery();
			while(rs.next()) {
				SanPham sp=new SanPham();
				sp.setId(rs.getInt("id_sp"));
				sp.setTitle(rs.getString("title"));
				sp.setImage(rs.getString("image"));
				sp.setProminent(rs.getBoolean("prominent"));
				sp.setSuper_id(rs.getInt("super_ID"));
				vtsp.add(sp);
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
		return vtsp;	
	}
	
	public boolean addSanPham(SanPham sp) {			
		connection=ConnectDB.ConnectData();
		try {
			String sql="insert into sanpham(title,image,prominent,super_ID,create_at) values(?,?,?,?,now())";
			pre=connection.prepareStatement(sql);
			
			pre.setString(1,sp.getTitle());
			pre.setString(2,sp.getImage());
			pre.setBoolean(3, sp.isProminent());
			pre.setInt(4, sp.getSuper_id());
			
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
	
	public SanPham findSP(int id) {
		connection=ConnectDB.ConnectData();
		try {		
			String sql="SELECT id_sp,title,image,prominent,super_ID from sanpham where id_sp=? and delete_at is null";
			pre=connection.prepareStatement(sql);
			pre.setInt(1, id);
			rs=pre.executeQuery();
			if(rs.next()) {
				SanPham sp=new SanPham();
				sp.setId(rs.getInt("id_sp"));
				sp.setTitle(rs.getString("title"));
				sp.setImage(rs.getString("image"));
				sp.setProminent(rs.getBoolean("prominent"));
				sp.setSuper_id(rs.getInt("super_ID"));
				return sp;
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
	
	public boolean udtSanPham(SanPham sp) {
		connection=ConnectDB.ConnectData();
		try {		
			String sql="update sanpham set title=?,image=?,update_at=now() where id_sp=? and delete_at is null";
			pre=connection.prepareStatement(sql);
			pre.setString(1, sp.getTitle());
			pre.setString(2, sp.getImage());
			pre.setInt(3, sp.getId());
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
	
	public boolean delSanPham(int id) {
		connection=ConnectDB.ConnectData();
		try {		
			String sql="update sanpham set delete_at=now() where id_sp=? and delete_at is null";
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
	
	public boolean proSanPham(int id) {
		connection=ConnectDB.ConnectData();
		try {		
			String sql="update sanpham set prominent=not prominent where id_sp=? and delete_at is null";
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
	
	public SanPham validAdd(HttpServletRequest request, int supID) throws IOException, ServletException {
		ArrayList<String> loi = new ArrayList<String>();
		Lang lang = new Lang();
		SanPham sanpham = new SanPham();
		
		sanpham.setTitle(request.getParameter("title").trim());
		sanpham.setSuper_id(supID);
		if(sanpham.getTitle() == null || sanpham.getTitle().equals(""))
			loi.add(lang.getValMsg("title_require"));
		
		Part part = request.getPart("file-image");
		if(part.getSubmittedFileName().equals("")) {
			loi.add(lang.getValMsg("image_null"));
		}
		else {
			String image_sp = ImageDao.imageUpload(request, SanPham.uploadDir, part);			
			if(image_sp!=null) {			
				sanpham.setImage(image_sp);
			}			
		}
		if(loi.size()>0) {
			request.getSession().setAttribute("flash_valid", loi.toArray(new String[loi.size()]));
			sanpham = null;
		}
		return sanpham;
	}
	
	public SanPham validUdt(HttpServletRequest request, int id) throws IOException, ServletException {
		ArrayList<String> loi = new ArrayList<String>();
		Lang lang = new Lang();
		SanPham sanpham = findSP(id);
		
		if(sanpham!=null) {
			sanpham.setTitle(request.getParameter("title"));
			if(sanpham.getTitle() == null || sanpham.getTitle().equals(""))
				loi.add(lang.getValMsg("title_require"));
			
			Part part = request.getPart("file-image");
			if(!part.getSubmittedFileName().equals("")) {
				String image_sp = ImageDao.imageUpload(request, SanPham.uploadDir, part);
				if(image_sp!=null)
					sanpham.setImage(image_sp);
			}
			if(loi.size()>0) {
				request.getSession().setAttribute("flash_valid", loi.toArray(new String[loi.size()]));
				sanpham = null;
			}
		}
		
		return sanpham;
	}
}
