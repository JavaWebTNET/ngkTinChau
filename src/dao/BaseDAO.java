package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.ConnectDB;

public class BaseDAO {
	
	 protected Connection connection;
	 
	 public BaseDAO(){
		 this.connection=ConnectDB.ConnectData();
		 
	 }
	 
	 public ResultSet get(PreparedStatement pre) {
	        try {
	            return pre.executeQuery();
	                   
	            }catch(SQLException ex){			
	    			System.out.println("SQLException: " + ex.getMessage());			    
	    		    System.out.println(ConnectDB.class.getName()); 
	    		    ex.printStackTrace();
	    		        
	    		}
	         
	        
	        return null;
	    }
}
