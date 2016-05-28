package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

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
	public Vector<Slider> AllSlider(){
		Vector<Slider> vtsd=new Vector<Slider>();
		try {
			
			String sql="SELECT id_sd,title,image FROM slider";
			pre=connection.prepareStatement(sql);
			rs=pre.executeQuery();
			while(rs.next()){
				Slider sl=new Slider();
				sl.setId_sd(rs.getInt("id_sd"));
				sl.setTitle(rs.getString("title"));
				sl.setImage(rs.getString("image"));
				vtsd.add(sl);				
			}
			
			}catch(SQLException ex) {			
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
	public boolean AddSlider(Slider sld){
		
		try {
			String sql="insert into slider(title,image) values(?,?)";
			pre=connection.prepareStatement(sql);
			pre.setString(1,sld.getTitle());
			pre.setString(2,sld.getImage());
			return executeUpdateDM(pre);
		}catch(SQLException ex) {			
			System.out.println("SQLException: " + ex.getMessage());			    
		    System.out.println(SliderDAO.class.getName()); 
		    ex.printStackTrace();	    		        
		} 
		finally {			
			ConnectDB.closeConnection(connection,pre, rs);					
		}	
		return false;
		
	}
	
public boolean DelSlider(int id){
		
		try {
			String sql="delete from slider where id_sd=?";
			pre=connection.prepareStatement(sql);
			pre.setInt(1,id);			
			return executeUpdateDM(pre);
		}catch(SQLException ex) {			
			System.out.println("SQLException: " + ex.getMessage());			    
		    System.out.println(SliderDAO.class.getName()); 
		    ex.printStackTrace();	    		        
		} 
		finally {			
			ConnectDB.closeConnection(connection,pre, rs);					
		}	
		return false;
		
	}
	
	
	/*hàm xử lý các executeUpdate()*/
	private boolean executeUpdateDM(PreparedStatement pre) throws SQLException {
        if (pre != null) {	         
            int numRow = pre.executeUpdate();
            if (numRow>0) {                  
               return true;
            }	            
            return false;
        }
        return false;
	}
	
	/*public static void main(String[] a){
		
		Slider sl=new Slider();
		SliderDAO slDAO=new SliderDAO();
		sl.setTitle("anh 4");
		sl.setImage("/View/Image/slider4.jpg");
		
		boolean jj=slDAO.DelSlider(4);
		System.out.println("ket qua "+jj);
		
		Vector<Slider> vt=slDAO.AllSlider();
		for(Slider item:vt)
		{
			System.out.println("in ra gia tri duong dan anh "+item.getImage());
		}
		
		
	}*/

}
