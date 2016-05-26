package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.ConnectDB;

public class BaseDAO {
	
	 protected Connection connection;
	 
	 public BaseDAO() {
		 this.connection=ConnectDB.ConnectData();	 
	 }
	 
	 public ResultSet selectBase(PreparedStatement pre) throws SQLException {	      
	     return pre.executeQuery();	                   	          
	 }
}
