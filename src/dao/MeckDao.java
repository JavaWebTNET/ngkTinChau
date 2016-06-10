package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import utils.ConnectDB;

public class MeckDao {
	public static HashMap<String, Integer> getMecks(HttpServletRequest request) {
		init(request);
		HashMap<String, Integer> mecks = new HashMap<String, Integer>();
		mecks.put("online", online());
		mecks.put("visit_today", visitToday());
		mecks.put("visit_yesterday", visitYesterday());
		mecks.put("visit_month", visitMonth());
		mecks.put("visit_year", visitYear());
		mecks.put("visit_total", visitTotal());
		mecks.put("hits_today", hitsToday());
		mecks.put("hits_total", hitsTotal());
		return mecks;
	}
	
	private static String getClientIpAddr(HttpServletRequest request) {  
        String ip = request.getHeader("X-Forwarded-For");  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("WL-Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_CLIENT_IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getRemoteAddr();  
        }  
        return ip;  
    }
	
	private static void init(HttpServletRequest request) {
		Connection connection=ConnectDB.ConnectData();
		String ip = getClientIpAddr(request);
		Date today = new Date();
		try {
			String sql="select count(ip) as count from meck where ip = ? and visit_date = ?";
			PreparedStatement pre=connection.prepareStatement(sql);
			pre.setString(1, ip);
			pre.setDate(2, new java.sql.Date(today.getTime()));
			ResultSet rs = pre.executeQuery();
			if(rs.next()) {
				int count = rs.getInt("count");
				ConnectDB.closeConnection(connection, pre, rs);
				if(count==0) insertIP(ip, today);
				else updateIP(ip, today);
			}
		}
		catch (Exception ex) {
			ConnectDB.closeConnection(connection, null, null);
			ex.printStackTrace();
		}		
	}
	
	private static void insertIP(String ip, Date today) {
		Connection connection=ConnectDB.ConnectData();
		try {
			String sql="insert into meck(ip, visit_date, hits, onl) values(?,?,?,?)";
			PreparedStatement pre=connection.prepareStatement(sql);
			pre.setString(1, ip);
			pre.setDate(2, new java.sql.Date(today.getTime()));
			pre.setInt(3, 1);
			pre.setLong(4, today.getTime());
			pre.executeUpdate();
			ConnectDB.closeConnection(connection, pre, null);
		}
		catch (Exception ex) {
			ConnectDB.closeConnection(connection, null, null);
			ex.printStackTrace();
		}
	}
	
	private static void updateIP(String ip, Date today) {
		Connection connection=ConnectDB.ConnectData();
		try {
			String sql="update meck set hits=hits+1, onl=? where ip=? and visit_date=?";
			PreparedStatement pre=connection.prepareStatement(sql);
			pre.setLong(1, today.getTime());
			pre.setString(2, ip);
			pre.setDate(3, new java.sql.Date(today.getTime()));		
			pre.executeUpdate();
			ConnectDB.closeConnection(connection, pre, null);
		}
		catch (Exception ex) {
			ConnectDB.closeConnection(connection, null, null);
			ex.printStackTrace();
		}
	}
		
	private static int online() {
		Connection connection=ConnectDB.ConnectData();
		Date today = new Date();
		try {
			String sql="select count(ip) as count from meck where onl>?";
			PreparedStatement pre=connection.prepareStatement(sql);
			pre.setLong(1, today.getTime() - 300000);	
			ResultSet rs = pre.executeQuery();
			if(rs.next()) {
				int count = rs.getInt("count");
				ConnectDB.closeConnection(connection, pre, rs);
				return count;
			}
		}
		catch (Exception ex) {
			ConnectDB.closeConnection(connection, null, null);
			ex.printStackTrace();
		}
		return 0;
	}
	
	private static int visitToday() {
		Connection connection=ConnectDB.ConnectData();
		Date today = new Date();
		try {
			String sql="select count(ip) as count from meck where visit_date=? group by ip";
			PreparedStatement pre=connection.prepareStatement(sql);
			pre.setDate(1, new java.sql.Date(today.getTime()));	
			ResultSet rs = pre.executeQuery();
			if(rs.next()) {
				int count = rs.getInt("count");
				ConnectDB.closeConnection(connection, pre, rs);
				return count;
			}
		}
		catch (Exception ex) {
			ConnectDB.closeConnection(connection, null, null);
			ex.printStackTrace();
		}
		return 0;
	}
	
	private static int visitYesterday() {
		Connection connection=ConnectDB.ConnectData();
		Date today = new Date();
		try {
			String sql="select count(ip) as count from meck where visit_date=subdate(?,1) group by ip";
			PreparedStatement pre=connection.prepareStatement(sql);
			pre.setDate(1, new java.sql.Date(today.getTime()));	
			ResultSet rs = pre.executeQuery();
			if(rs.next()) {
				int count = rs.getInt("count");
				ConnectDB.closeConnection(connection, pre, rs);
				return count;
			}
		}
		catch (Exception ex) {
			ConnectDB.closeConnection(connection, null, null);
			ex.printStackTrace();
		}
		return 0;
	}
	
	private static int visitMonth() {
		Connection connection=ConnectDB.ConnectData();
		Date today = new Date();
		DateFormat df = new SimpleDateFormat("%Y-MM%");
		String thismonth = df.format(today);
		try {
			String sql="select count(ip) as count from meck where visit_date like ? group by ip";
			PreparedStatement pre=connection.prepareStatement(sql);
			pre.setString(1, thismonth);
			ResultSet rs = pre.executeQuery();
			if(rs.next()) {
				int count = rs.getInt("count");
				ConnectDB.closeConnection(connection, pre, rs);
				return count;
			}
		}
		catch (Exception ex) {
			ConnectDB.closeConnection(connection, null, null);
			ex.printStackTrace();
		}
		return 0;
	}
	
	private static int visitYear() {
		Connection connection=ConnectDB.ConnectData();
		Date today = new Date();
		DateFormat df = new SimpleDateFormat("%Y%");
		String thisyear = df.format(today);
		try {
			String sql="select count(ip) as count from meck where visit_date like ? group by ip";
			PreparedStatement pre=connection.prepareStatement(sql);
			pre.setString(1, thisyear);
			ResultSet rs = pre.executeQuery();
			if(rs.next()) {
				int count = rs.getInt("count");
				ConnectDB.closeConnection(connection, pre, rs);
				return count;
			}
		}
		catch (Exception ex) {
			ConnectDB.closeConnection(connection, null, null);
			ex.printStackTrace();
		}
		return 0;
	}
	
	private static int visitTotal() {
		Connection connection=ConnectDB.ConnectData();
		try {
			String sql="select count(ip) as count from meck group by ip";
			PreparedStatement pre=connection.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			if(rs.next()) {
				int count = rs.getInt("count");
				ConnectDB.closeConnection(connection, pre, rs);
				return count;
			}
		}
		catch (Exception ex) {
			ConnectDB.closeConnection(connection, null, null);
			ex.printStackTrace();
		}
		return 0;
	}
	
	private static int hitsToday() {
		Connection connection=ConnectDB.ConnectData();
		Date today = new Date();
		try {
			String sql="select sum(hits) as count from meck where visit_date=? group by visit_date";
			PreparedStatement pre=connection.prepareStatement(sql);
			pre.setDate(1, new java.sql.Date(today.getTime()));	
			ResultSet rs = pre.executeQuery();
			if(rs.next()) {
				int count = rs.getInt("count");
				ConnectDB.closeConnection(connection, pre, rs);
				return count;
			}
		}
		catch (Exception ex) {
			ConnectDB.closeConnection(connection, null, null);
			ex.printStackTrace();
		}
		return 0;
	}
	
	private static int hitsTotal() {
		Connection connection=ConnectDB.ConnectData();
		try {
			String sql="select sum(hits) as count from meck";
			PreparedStatement pre=connection.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			if(rs.next()) {
				int count = rs.getInt("count");
				ConnectDB.closeConnection(connection, pre, rs);
				return count;
			}
		}
		catch (Exception ex) {
			ConnectDB.closeConnection(connection, null, null);
			ex.printStackTrace();
		}
		return 0;
	}
}
