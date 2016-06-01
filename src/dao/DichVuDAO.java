package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import models.DichVu;
import utils.ConnectDB;

public class DichVuDAO {
	private PreparedStatement pre;
	private Connection connection;
	private ResultSet rs;
	
	public DichVuDAO() { 
		connection=ConnectDB.ConnectData();		 
	}	
	
	public Vector<DichVu> allDichVu() {
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
	
	public boolean addDichVu(DichVu dv) {			
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
}
