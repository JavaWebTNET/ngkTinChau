package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.ImageDao;
import dao.ThongTinDAO;

import models.ThongTin;

/**
 * Servlet implementation class SuaThongTinController
 */
@WebServlet("/admin/suathongtin")

public class SuaThongTinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaThongTinController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	ThongTinDAO thongtinDAO=new ThongTinDAO();
	ThongTin thongtin=thongtinDAO.AllThongTin();
	
	request.setAttribute("thongtinsua",thongtin);
	RequestDispatcher rq=request.getRequestDispatcher("/View/admin/Suathongtin.jsp");
	rq.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");	
		PrintWriter out = response.getWriter(); 
		FileItemFactory itemfactory = new DiskFileItemFactory(); 
	    ServletFileUpload upload = new ServletFileUpload(itemfactory);	
	    Hashtable<String,String> params = new Hashtable<String,String>();	    
	    String name_logo=null;  
			try {
				request.setCharacterEncoding("UTF-8");
				List<FileItem> items = upload.parseRequest(request);
				
				for( FileItem uploadItem : items )
				{			
					 if (uploadItem.isFormField()) {
	                     params.put(uploadItem.getFieldName(), uploadItem.getString("UTF-8"));
	                 }
					 else{
						
						 if(uploadItem.getFieldName().equals("file-image")&& uploadItem.getName().length()>0){							 
							String name_image=ImageDao.Uploadimage(request,ThongTin.uploadDir,uploadItem);
							 if(name_image==null){
									request.getSession().setAttribute("flash_error", "File ảnh upload không thành công,sửa thất bại..!"+uploadItem.getString()+"đs");
									response.sendRedirect(request.getRequestURI());
									return;
							 }
							 name_logo=name_image;
						 }
					 }
					
				}			
				ThongTinDAO thongtinDAO=new ThongTinDAO();
				ThongTin thongtin= thongtinDAO.AllThongTin();
				thongtin.setName_company((String)params.get("name_company"));
				thongtin.setType_company((String)params.get("type_company"));
				thongtin.setAdd_company((String)params.get("add_company"));
				thongtin.setEmail((String)params.get("email"));
				thongtin.setFax((String)params.get("fax"));
				thongtin.setHotline((String)params.get("hotline"));
				thongtin.setSlogan((String)params.get("slogan"));
				thongtin.setWord_run((String)params.get("word_run"));
				thongtin.setTel((String)params.get("tell"));
				if(name_logo!=null){
					thongtin.setLogo(name_logo);
				}		
				
				System.out.println("ten cty tren contr "+thongtin.getName_company());				
				boolean result=thongtinDAO.EditThongTin(thongtin);
				 if(result==true){
					 request.getSession().setAttribute("flash_success", "Thông tin đã được cập nhật thành công..!");
					 response.sendRedirect(request.getRequestURI());
				 }
				 else{
					 request.getSession().setAttribute("flash_success", "Thông tin cập nhật thất bại..!");
					 response.sendRedirect(request.getRequestURI());
				 }		
				
			} catch (FileUploadException e) {
				
				 request.getSession().setAttribute("flash_success", "Thông tin cập nhật thất bại..!");
				 response.sendRedirect(request.getRequestURI());
			}
			

		// Process the uploaded items
			
		
		/*String logo=ImageDao.imageUpload(re,ThongTin.uploadDir,"file");
		out.print("vao post"+logo+"\n");
		Hashtable<String,String> params = new Hashtable<String,String>();		
		FileItemFactory itemfactory = new DiskFileItemFactory(); 
	    ServletFileUpload upload = new ServletFileUpload(itemfactory);
	   	  try {
	   		
	   		 
	   			List<FileItem>  items = upload.parseRequest(request);
	   		  
			
			
			for( FileItem uploadItem : items )
			{
				
				 if (uploadItem.isFormField()) {
                     params.put(uploadItem.getFieldName(), uploadItem.getString());
                 }
				
				
			}
	   		  
	   		
		} catch (FileUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
		}
		
	   	  
	   	ThongTin thongtin=new ThongTin();
		thongtin.setName_company((String)params.get("name_company"));
		thongtin.setType_company((String)params.get("type_company"));
		thongtin.setAdd_company((String)params.get("add_company"));
		thongtin.setEmail((String)params.get("email"));
		thongtin.setFax((String)params.get("fax"));
		thongtin.setHotline((String)params.get("hotline"));
		
		
		out.print("vao post"+thongtin.getAdd_company());
		//thongtin.setId_tt(Integer.parseInt(params.get("id_tt")));
	   	  
			/*if(!ServletFileUpload.isMultipartContent(request)) {
			    return; 
			}
			 String logo="";
			 request.setCharacterEncoding("UTF-8");
			Hashtable<String,String> params = new Hashtable<String,String>();		
			FileItemFactory itemfactory = new DiskFileItemFactory(); 
		    ServletFileUpload upload = new ServletFileUpload(itemfactory);
		   	  try {
				List<FileItem>  items = upload.parseRequest(request);
				
				for( FileItem uploadItem : items )
				{
					
					 if (uploadItem.isFormField()) {
	                     params.put(uploadItem.getFieldName(), uploadItem.getString());
	                 }
					 else{
					logo=ImageDao.imageUpload(request,ThongTin.uploadDir,"file");
					 }
					
				}
				
			} catch (FileUploadException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			ThongTin thongtin=new ThongTin();
			thongtin.setName_company((String)params.get("name_company"));
			thongtin.setType_company((String)params.get("type_company"));
			thongtin.setAdd_company((String)params.get("add_company"));
			thongtin.setEmail((String)params.get("email"));
			thongtin.setFax((String)params.get("fax"));
			thongtin.setHotline((String)params.get("hotline"));
			thongtin.setId_tt(Integer.parseInt(params.get("id_tt")));
			thongtin.setSlogan((String)params.get("slogan"));
			thongtin.setWord_run((String)params.get("word_run"));
			thongtin.setTel((String)params.get("tell"));
			
			thongtin.setLogo(logo);
			
			ThongTinDAO thongtinDAO=new ThongTinDAO();
			boolean result=thongtinDAO.EditThongTin(thongtin);
			if(result){
				PrintWriter out = response.getWriter();  
				out.print("vao post"+result+"\n"+logo); 
			}
			else{
				PrintWriter out = response.getWriter();  
				out.print("vao post"+result); 
			}
		*/
	}

}
