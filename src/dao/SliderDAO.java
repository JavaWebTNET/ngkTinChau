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
import models.Slider;
import utils.ConnectDB;

public class SliderDAO {
	private PreparedStatement pre;
	private Connection connection;
	private ResultSet rs;
	
	public SliderDAO(){
		connection=ConnectDB.ConnectData();		
	}
	/*hàm lấy hết dữ liêu trong bang slider*/
	public Vector<Slider> allSlider() {
		Vector<Slider> vtsd=new Vector<Slider>();
		try {			
			String sql="SELECT id_sd,title,image FROM slider where delete_at is null";
			pre=connection.prepareStatement(sql);
			rs=pre.executeQuery();
			while(rs.next()){
				Slider sl=new Slider();
				sl.setId_sd(rs.getInt("id_sd"));
				sl.setTitle(rs.getString("title"));
				sl.setImage(rs.getString("image"));
				vtsd.add(sl);				
			}	
		}
		catch(SQLException ex) {			
				System.out.println("SQLException: " + ex.getMessage());			    
			    System.out.println(SliderDAO.class.getName()); 
			    ex.printStackTrace();	    		        
		} 
		finally {			
			ConnectDB.closeConnection(connection,pre, rs);					
		}	
			
		return vtsd;	
	}
	
/*	thêm một ảnh vào bảng slider*/
	public boolean addSlider(Slider sld) {		
		try {
			String sql="insert into slider(title,image,create_at) values(?,?,now())";
			pre=connection.prepareStatement(sql);
			pre.setString(1,sld.getTitle());
			pre.setString(2,sld.getImage());	
			return (pre.executeUpdate()>0);
		}
		catch(SQLException ex) {			
			System.out.println("SQLException: " + ex.getMessage());			    
		    System.out.println(SliderDAO.class.getName()); 
		    ex.printStackTrace();	    		        
		} 
		finally {			
			ConnectDB.closeConnection(connection,pre, rs);					
		}	
		return false;		
	}
	
	public boolean delSlider(int id){	
		try {
			String sql="update slider set delete_at=now() where id_sd=? and delete_at is null";
			pre=connection.prepareStatement(sql);
			pre.setInt(1,id);			
			return (pre.executeUpdate()>0);
		}
		catch(SQLException ex) {			
			System.out.println("SQLException: " + ex.getMessage());			    
		    System.out.println(SliderDAO.class.getName()); 
		    ex.printStackTrace();	    		        
		} 
		finally {			
			ConnectDB.closeConnection(connection,pre, rs);					
		}	
		return false;		
	}
	
	public boolean udtSlider(Slider sld) {
		try {
			String sql="update slider set title=?, image=?, update_at=now() where id_sd=? and delete_at is null";
			pre=connection.prepareStatement(sql);
			pre.setString(1,sld.getTitle());	
			pre.setString(2,sld.getImage());	
			pre.setInt(3,sld.getId_sd());			
			return (pre.executeUpdate()>0);
		}
		catch(SQLException ex) {			
			System.out.println("SQLException: " + ex.getMessage());			    
		    System.out.println(SliderDAO.class.getName()); 
		    ex.printStackTrace();	    		        
		} 
		finally {			
			ConnectDB.closeConnection(connection,pre, rs);					
		}	
		return false;
	}
	
	public Slider validAdd(HttpServletRequest request) throws IOException, ServletException {
		ArrayList<String> loi = new ArrayList<String>();
		Lang lang = new Lang();
		Part part = request.getPart("file-image");
		if(part.getSubmittedFileName().equals("")) {
			loi.add(lang.getValMsg("image_null"));
		}
		else {
			String image_slider = ImageDao.imageUpload(request, Slider.uploadDir, part);  
			Slider slider=new Slider();

			if(image_slider!=null) {
				 slider.setTitle(image_slider);
				 slider.setImage(image_slider);
				 return slider;					
			}
		}
		if(loi.size()>0)
			request.getSession().setAttribute("flash_valid", loi.toArray(new String[loi.size()]));
		return null;
	}
	
	public Slider validUdt(HttpServletRequest request, int id) throws IOException, ServletException {
		ArrayList<String> loi = new ArrayList<String>();
		Lang lang = new Lang();
		Part part = request.getPart("file-image");
		if(part.getSubmittedFileName().equals("")) {
			loi.add(lang.getValMsg("image_null"));
		}
		else {
			String image_slider = ImageDao.imageUpload(request, Slider.uploadDir, part);  
			Slider slider=new Slider();

			if(image_slider!=null) {
				 slider.setId_sd(id);
				 slider.setTitle(image_slider);
				 slider.setImage(image_slider);
				 return slider;					
			}
		}
		if(loi.size()>0)
			request.getSession().setAttribute("flash_valid", loi.toArray(new String[loi.size()]));
		return null;
	}
}
