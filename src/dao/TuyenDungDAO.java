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
import models.TuyenDung;
import utils.ConnectDB;

public class TuyenDungDAO {
	private PreparedStatement pre;
	private Connection connection;
	private ResultSet rs;
	public static int limit = 10;
	
	public TuyenDungDAO() { 
				 
	}	
	
	public Vector<TuyenDung> allTuyenDung() {
		connection=ConnectDB.ConnectData();
		Vector<TuyenDung> vttd=new Vector<TuyenDung>();
		try {		
			String sql="SELECT id,title,detail from tuyendung where delete_at is null";
			pre=connection.prepareStatement(sql);
			rs=pre.executeQuery();
			while(rs.next()) {
				TuyenDung td=new TuyenDung();
				td.setId(rs.getInt("id"));
				td.setTitle(rs.getString("title"));
				td.setDetail(rs.getString("detail"));
				vttd.add(td);
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
		return vttd;	
	}
	
	public int offsets() {
		connection=ConnectDB.ConnectData();
		try {		
			String sql="SELECT count(id) as offset from tuyendung where delete_at is null";
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
	
	public Vector<TuyenDung> pageTuyenDung(int page) {
		connection=ConnectDB.ConnectData();
		Vector<TuyenDung> vttd=new Vector<TuyenDung>();
		try {		
			String sql="SELECT id,title,detail,create_at,update_at from tuyendung where delete_at is null order by update_at desc limit ? offset ?";
			pre=connection.prepareStatement(sql);
			pre.setInt(1, limit);
			pre.setInt(2, (page-1)*limit);
			rs=pre.executeQuery();
			while(rs.next()) {
				TuyenDung td=new TuyenDung();
				td.setId(rs.getInt("id"));
				td.setTitle(rs.getString("title"));
				td.setDetail(rs.getString("detail"));
				td.setCreate_at(rs.getTimestamp("create_at"));
				td.setUpdate_at(rs.getTimestamp("update_at"));
				vttd.add(td);
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
		return vttd;	
	}
	
	public boolean addTuyenDung(TuyenDung td) {	
		connection=ConnectDB.ConnectData();
		try {
			String sql="insert into tuyendung(title,detail,create_at,update_at) values(?,?,now(),now())";
			pre=connection.prepareStatement(sql);
			pre.setString(1, td.getTitle());
			pre.setString(2,td.getDetail());
			
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
	
	public TuyenDung findTD(int id) {
		connection=ConnectDB.ConnectData();
		try {		
			String sql="SELECT id,title,detail,create_at,update_at from tuyendung where id=? and delete_at is null";
			pre=connection.prepareStatement(sql);
			pre.setInt(1, id);
			rs=pre.executeQuery();
			if(rs.next()) {
				TuyenDung td=new TuyenDung();
				td.setId(id);
				td.setTitle(rs.getString("title"));
				td.setDetail(rs.getString("detail"));
				td.setCreate_at(rs.getTimestamp("create_at"));
				td.setUpdate_at(rs.getTimestamp("update_at"));
				return td;
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
	
	public boolean udtTuyenDung(TuyenDung td) {
		connection=ConnectDB.ConnectData();
		try {		
			String sql="update tuyendung set title=?,detail=?,update_at=now() where id=? and delete_at is null";
			pre=connection.prepareStatement(sql);
			pre.setString(1,td.getTitle());
			pre.setString(2, td.getDetail());
			pre.setInt(3, td.getId());
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
	
	public boolean delTuyenDung(int id) {
		connection=ConnectDB.ConnectData();
		try {		
			String sql="update tuyendung set delete_at=now() where id=? and delete_at is null";
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
	
	public TuyenDung validAdd(HttpServletRequest request) throws IOException, ServletException {
		ArrayList<String> loi = new ArrayList<String>();
		Lang lang = new Lang();
		TuyenDung tuyendung = new TuyenDung();
		
		tuyendung.setTitle(request.getParameter("title").trim());
		tuyendung.setDetail(request.getParameter("detail"));
		if(tuyendung.getTitle() == null || tuyendung.getTitle().equals(""))
			loi.add(lang.getValMsg("title_require"));
		
		if(loi.size()>0) {
			request.getSession().setAttribute("flash_valid", loi.toArray(new String[loi.size()]));
			tuyendung = null;
		}
		return tuyendung;
	}
	
	public TuyenDung validUdt(HttpServletRequest request, int id) throws IOException, ServletException {
		ArrayList<String> loi = new ArrayList<String>();
		Lang lang = new Lang();
		TuyenDung tuyendung = findTD(id);
		
		if(tuyendung!=null) {
			tuyendung.setTitle(request.getParameter("title"));
			tuyendung.setDetail(request.getParameter("detail"));
			if(tuyendung.getTitle() == null || tuyendung.getTitle().equals(""))
				loi.add(lang.getValMsg("title_require"));
			
			if(loi.size()>0) {
				request.getSession().setAttribute("flash_valid", loi.toArray(new String[loi.size()]));
				tuyendung = null;
			}
		}
		
		return tuyendung;
	}
}
