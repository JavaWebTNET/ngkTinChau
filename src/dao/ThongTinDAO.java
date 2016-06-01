package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import utils.ConnectDB;
import models.ThongTin;;

public class ThongTinDAO {
	private PreparedStatement pre;
	private Connection connection;
	private ResultSet rs;
	
	public ThongTinDAO() {		
			
	}
	
	public ThongTin allThongTin() {	
		ThongTin thongtin=new ThongTin();
		try {		
			connection=ConnectDB.ConnectData();	
			String sql="select id_tt,type_company,name_company,add_company,tel,fax,email,hotline,slogan,word_run,logo from thongtin";
			pre=connection.prepareStatement(sql);
			
			rs=pre.executeQuery();
			if(rs.next()) {
			
				thongtin.setId_tt(rs.getInt("id_tt"));
				thongtin.setType_company(rs.getString("type_company"));
				thongtin.setName_company(rs.getString("name_company"));
				thongtin.setAdd_company(rs.getString("add_company"));
				thongtin.setTel(rs.getString("tel"));
				thongtin.setFax(rs.getString("fax"));
				thongtin.setEmail(rs.getString("email"));
				thongtin.setHotline(rs.getString("hotline"));
				thongtin.setSlogan(rs.getString("slogan"));
				thongtin.setWord_run(rs.getString("word_run"));
				thongtin.setLogo(rs.getString("logo"));
							
			}
		}
		catch(SQLException ex) {			
			System.out.println("SQLException: " + ex.getMessage());			    
		    System.out.println(ThongTinDAO.class.getName()); 
		    ex.printStackTrace();	    		        
		} 
		finally {			
			ConnectDB.closeConnection(connection,pre, rs);				
		}	
		
		return thongtin;	
	}
	
	public boolean udtThongTin(ThongTin thongtin) {
		try {
			connection=ConnectDB.ConnectData();	
			String sql="update thongtin set name_company=?,type_company=?,add_company=?,tel=?,fax=?,email=?,hotline=?,slogan=?,word_run=?,logo=? where id_tt=?";
			pre=connection.prepareStatement(sql);
			pre.setString(1,thongtin.getName_company());
			pre.setString(2,thongtin.getType_company());
			pre.setString(3,thongtin.getAdd_company());
			pre.setString(4,thongtin.getTel());
			pre.setString(5,thongtin.getFax());
			pre.setString(6,thongtin.getEmail());
			pre.setString(7,thongtin.getHotline());
			pre.setString(8,thongtin.getSlogan());
			pre.setString(9,thongtin.getWord_run());
			pre.setString(10,thongtin.getLogo());
			pre.setInt(11,thongtin.getId_tt());
			return pre.executeUpdate()>0;		
		}
		catch(SQLException ex) {			
			System.out.println("SQLException: " + ex.getMessage());			    
		    System.out.println(ThongTinDAO.class.getName()); 
		    ex.printStackTrace();	    		        
		} 	
		finally {			
			ConnectDB.closeConnection(connection,pre, rs);				
		}
		
		return false;	
	}
	
	/*thêm thông tin*/
	public boolean addThongTin(ThongTin thongtin) {
		try {
			connection=ConnectDB.ConnectData();	
			String sql="insert into thongtin(type_company,name_company,add_company,tel,fax,email,hotline,slogan,word_run,logo) "
					+ "values(?,?,?,?,?,?,?,?,?)";
			pre=connection.prepareStatement(sql);
			pre.setNString(1,thongtin.getType_company());
			pre.setNString(2,thongtin.getName_company());
			pre.setNString(3,thongtin.getAdd_company());
			pre.setString(4,thongtin.getTel());
			pre.setString(5,thongtin.getFax());
			pre.setString(6,thongtin.getEmail());
			pre.setString(7,thongtin.getHotline());
			pre.setNString(8,thongtin.getSlogan());
			pre.setNString(9,thongtin.getWord_run());
			pre.setNString(10,thongtin.getLogo());
			return pre.executeUpdate()>0;		
		}
		catch(SQLException ex) {			
			System.out.println("SQLException: " + ex.getMessage());			    
		    System.out.println(ThongTinDAO.class.getName()); 
		    ex.printStackTrace();	    		        
		} 
		finally {			
			ConnectDB.closeConnection(connection,pre, rs);				
		}	
		
		return false;	
	}
	
	public ThongTin validUdt(HttpServletRequest request) throws IOException, ServletException {
		Part part = request.getPart("file-image");
		String image_slider = null;
		System.out.println(part.getSize());
		if(!part.getSubmittedFileName().equals("")) {
			image_slider = ImageDao.imageUpload(request, ThongTin.uploadDir, part);  
		}
			
		ThongTin thongtin= allThongTin();
		
		thongtin.setName_company(request.getParameter("name_company"));
		thongtin.setType_company(request.getParameter("type_company"));
		thongtin.setAdd_company(request.getParameter("add_company"));
		thongtin.setEmail(request.getParameter("email"));
		thongtin.setFax(request.getParameter("fax"));
		thongtin.setHotline(request.getParameter("hotline"));
		thongtin.setSlogan(request.getParameter("slogan"));
		thongtin.setWord_run(request.getParameter("word_run"));
		thongtin.setTel(request.getParameter("tell"));

		if(image_slider!=null) {
			 thongtin.setLogo(image_slider);
		}
		return thongtin;
	}
}
