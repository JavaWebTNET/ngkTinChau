package dao;

import java.sql.Connection;

import utils.ConnectDB;

public class BaseDAO {
	
	 protected Connection connection;
	 
	 public BaseDAO(){
		 this.connection=ConnectDB.ConnectData();
		 
	 }

}
