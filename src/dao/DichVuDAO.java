package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import models.DichVu;
import models.Slider;
import utils.ConnectDB;

public class DichVuDAO {
	private PreparedStatement pre;
	private Connection connection;
	private ResultSet rs;
	
	public DichVuDAO() { 
		connection=ConnectDB.ConnectData();		 
	}	
	
	public Vector<DichVu> AllDichVu(){
		Vector<DichVu> vtdv=new Vector<DichVu>();
		try{
		
		String sql="SELECT id_dv,name_dv,image,detail from dichvu";
		pre=connection.prepareStatement(sql);
		rs=pre.executeQuery();
		while(rs.next()){
			DichVu dv=new DichVu();
			dv.setId_dv(rs.getInt("id_dv"));
			dv.setName_dv(rs.getString("name_dv"));
			dv.setImage(rs.getString("image"));
			dv.setDetail(rs.getString("detail"));
			vtdv.add(dv);
		}		
		}catch(SQLException ex) {			
			System.out.println("SQLException: " + ex.getMessage());			    
		    System.out.println(DanhMucDAO.class.getName()); 
		    ex.printStackTrace();	    		        
		} 
		finally {			
			ConnectDB.closeConnection(connection,pre, rs);					
		}
		return vtdv;	
		
	

	}
	
		public boolean AddDichVu(DichVu dv){
			
			try {
				String sql="insert into dichvu(name_dv,image,detail) values(?,?,?)";
				pre=connection.prepareStatement(sql);
				
				pre.setString(1,dv.getName_dv());
				pre.setString(2,dv.getImage());
				pre.setString(3,dv.getDetail());
				
				return executeUpdateDM(pre);
			}catch(SQLException ex) {			
				System.out.println("SQLException: " + ex.getMessage());			    
			    System.out.println(DichVuDAO.class.getName()); 
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
		
		public static void main(String[] a){
			DichVu dv=new DichVu();
			DichVuDAO dvdao=new DichVuDAO();
			Vector<DichVu> vt=dvdao.AllDichVu();
			/*dv.setDetail("Với bề dày kinh nghiệm được tích lũy và không ngừng nâng cao chất lượng sản phẩm, công ty CPSX & TM TÍN CHÂU đến nay đã mở rộng hoạt động sản xuất kinh doanh trên nhiều lĩnh vực..");
			dv.setImage("/View/Image/anhsx.png");
			dv.setName_dv("Sản Xuất");
			boolean bl=dvdao.AddDichVu(dv);*/
			for(DichVu item:vt){
			System.out.println("ket qua cua truy van "+item.getImage());
			}
		}
 
}
