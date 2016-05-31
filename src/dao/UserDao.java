package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.BCrypt;
import utils.ConnectDB;

public class UserDao {

	public static int login(String user, String pass) {
		Connection connection = ConnectDB.ConnectData();
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			String sql="select id, pass from users where username=?";
			pre=connection.prepareStatement(sql);
			pre.setString(1, user);
			rs=pre.executeQuery();
			if(rs.next()) {				
				int id = rs.getInt("id");
				String rspass = rs.getString("pass");
				if(BCrypt.checkpw(pass, rspass))
					return id;
				else return 0;
			}		
		}
		catch(SQLException ex) {			
			System.out.println("SQLException: " + ex.getMessage());			    
		    System.out.println(UserDao.class.getName()); 
		    ex.printStackTrace();	    		        
		} 
		finally {			
			ConnectDB.closeConnection(connection,pre, rs);				
		}
		return 0;
	}
	
	public static boolean isUser(int id) {
		Connection connection = ConnectDB.ConnectData();
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			String sql="select id from users where id=?";
			pre=connection.prepareStatement(sql);
			pre.setInt(1, id);
			rs=pre.executeQuery();
			if(rs.next()) {				
				return true;
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
		return false;
	}
	

	
	public static boolean changepw(int id, String pass, String newpass) {
		Connection connection = ConnectDB.ConnectData();
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			String sql="select pass from users where id=?";
			pre=connection.prepareStatement(sql);
			pre.setInt(1, id);
			rs=pre.executeQuery();
			if(rs.next()) {				
				String rspass = rs.getString("pass");
				if(BCrypt.checkpw(pass, rspass)) {
					sql="update users set pass=? where id=?";
					pre.close();
					pre=connection.prepareStatement(sql);
					pre.setString(1, BCrypt.hashpw(newpass, BCrypt.gensalt()));
					pre.setInt(2, id);
					return (pre.executeUpdate()>0);
				}
				else return false;
			}		
		}
		catch(SQLException ex) {			
			System.out.println("SQLException: " + ex.getMessage());			    
		    System.out.println(UserDao.class.getName()); 
		    ex.printStackTrace();	
		    
		} 
		finally {			
			ConnectDB.closeConnection(connection,pre, rs);				
		}
		return false;
	}
	
	/*public static void text(){
	System.out.println(""+BCrypt.checkpw("1234","$2a$10$zMDwHrewWvprL4S9oai4jeS8KVoIusJLiMx4BSwaEwnGWT/8u.mUu"));
	$2a$10$zMDwHrewWvprL4S9oai4jeS8KVoIusJLiMx4BSwaEwnGWT/8u.mUu

	}
	
	public static void main(String[] a){
		UserDao.text();
	}*/
}
