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

import lang.Lang;
import models.TinTuc;
import utils.ConnectDB;

public class TinTucDAO {
	private PreparedStatement pre;
	private Connection connection;
	private ResultSet rs;
	public static int limit = 10;
	
	public TinTucDAO() { 
				 
	}	
	
	public Vector<TinTuc> allTinTuc() {
		connection=ConnectDB.ConnectData();
		Vector<TinTuc> vttt=new Vector<TinTuc>();
		try {		
			String sql="SELECT id,title,detail from tintuc where delete_at is null";
			pre=connection.prepareStatement(sql);
			rs=pre.executeQuery();
			while(rs.next()) {
				TinTuc tt=new TinTuc();
				tt.setId(rs.getInt("id"));
				tt.setTitle(rs.getString("title"));
				tt.setDetail(rs.getString("detail"));
				vttt.add(tt);
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
		return vttt;	
	}
	
	public int offsets() {
		connection=ConnectDB.ConnectData();
		try {		
			String sql="SELECT count(id) as offset from tintuc where delete_at is null";
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
	
	public Vector<TinTuc> pageTinTuc(int page) {
		connection=ConnectDB.ConnectData();
		Vector<TinTuc> vttt=new Vector<TinTuc>();
		try {		
			String sql="SELECT id,title,detail,create_at,update_at from tintuc where delete_at is null order by update_at desc limit ? offset ?";
			pre=connection.prepareStatement(sql);
			pre.setInt(1, limit);
			pre.setInt(2, (page-1)*limit);
			rs=pre.executeQuery();
			while(rs.next()) {
				TinTuc tt=new TinTuc();
				tt.setId(rs.getInt("id"));
				tt.setTitle(rs.getString("title"));
				tt.setDetail(rs.getString("detail"));
				tt.setCreate_at(rs.getTimestamp("create_at"));
				tt.setUpdate_at(rs.getTimestamp("update_at"));
				vttt.add(tt);
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
		return vttt;	
	}
	
	public boolean addTinTuc(TinTuc tt) {	
		connection=ConnectDB.ConnectData();
		try {
			String sql="insert into tintuc(title,detail,create_at,update_at) values(?,?,now(),now())";
			pre=connection.prepareStatement(sql);
			pre.setString(1, tt.getTitle());
			pre.setString(2,tt.getDetail());
			
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
	
	public TinTuc findTT(int id) {
		connection=ConnectDB.ConnectData();
		try {		
			String sql="SELECT id,title,detail,create_at,update_at from tintuc where id=? and delete_at is null";
			pre=connection.prepareStatement(sql);
			pre.setInt(1, id);
			rs=pre.executeQuery();
			if(rs.next()) {
				TinTuc tt=new TinTuc();
				tt.setId(id);
				tt.setTitle(rs.getString("title"));
				tt.setDetail(rs.getString("detail"));
				tt.setCreate_at(rs.getTimestamp("create_at"));
				tt.setUpdate_at(rs.getTimestamp("update_at"));
				return tt;
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
	
	public boolean udtTinTuc(TinTuc tt) {
		connection=ConnectDB.ConnectData();
		try {		
			String sql="update tintuc set title=?,detail=?,update_at=now() where id=? and delete_at is null";
			pre=connection.prepareStatement(sql);
			pre.setString(1,tt.getTitle());
			pre.setString(2, tt.getDetail());
			pre.setInt(3, tt.getId());
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
	
	public boolean delTinTuc(int id) {
		connection=ConnectDB.ConnectData();
		try {		
			String sql="update tintuc set delete_at=now() where id=? and delete_at is null";
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
	
	public TinTuc validAdd(HttpServletRequest request) throws IOException, ServletException {
		ArrayList<String> loi = new ArrayList<String>();
		Lang lang = new Lang();
		TinTuc tintuc = new TinTuc();
		
		tintuc.setTitle(request.getParameter("title").trim());
		tintuc.setDetail(request.getParameter("detail"));
		if(tintuc.getTitle() == null || tintuc.getTitle().equals(""))
			loi.add(lang.getValMsg("title_require"));
		
		if(loi.size()>0) {
			request.getSession().setAttribute("flash_valid", loi.toArray(new String[loi.size()]));
			tintuc = null;
		}
		return tintuc;
	}
	
	public TinTuc validUdt(HttpServletRequest request, int id) throws IOException, ServletException {
		ArrayList<String> loi = new ArrayList<String>();
		Lang lang = new Lang();
		TinTuc tintuc = findTT(id);
		
		if(tintuc!=null) {
			tintuc.setTitle(request.getParameter("title"));
			tintuc.setDetail(request.getParameter("detail"));
			if(tintuc.getTitle() == null || tintuc.getTitle().equals(""))
				loi.add(lang.getValMsg("title_require"));
			
			if(loi.size()>0) {
				request.getSession().setAttribute("flash_valid", loi.toArray(new String[loi.size()]));
				tintuc = null;
			}
		}
		
		return tintuc;
	}
}
