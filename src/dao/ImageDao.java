package dao;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import lang.Lang;

public class ImageDao {
	
	public static String imageUpload(HttpServletRequest request, String dir, String field) {
		Lang lang = new Lang();
		String sp = File.separator;
		String path = request.getServletContext().getRealPath("") + sp + "View" + sp + "Image";
		if(!ServletFileUpload.isMultipartContent(request)) {
		    return null; 
		}
	    FileItemFactory itemfactory = new DiskFileItemFactory(); 
	    ServletFileUpload upload = new ServletFileUpload(itemfactory);
	    try{
	    	List<FileItem>  items = upload.parseRequest(request);
	    	for(FileItem item:items) {
	    		if(item.getFieldName().equals(field)) {
	    			String contentType = item.getContentType();
	    			if(contentType.equals("image/png")
	    					|| contentType.equals("image/jpg")
	    					|| contentType.equals("image/gif") 
	    					&& !(item.getSize()<=1024)) {			
		    			File uploadDir = new File(path + sp + dir);
		    			System.out.println(uploadDir);
		    			if(!uploadDir.exists()) {
		    				uploadDir.mkdirs();
		    			}
		    			File file = File.createTempFile("img","."+contentType.substring(contentType.length()-3),uploadDir);
		    			item.write(file);
		    			return file.getName();
	    			}
	    			else {
	    				System.out.println(contentType);
	    				request.setAttribute("error", lang.getValMsg("wrong_image"));
	    			}
	    		}   
	    	}
	    }
		catch(FileUploadException e) {
		    e.printStackTrace(); 		    
		}
	    catch(Exception ex){	     
	    	ex.printStackTrace();
	    }
		return null;
	}

	public static String imageLink(HttpServletRequest request, String dir, String name) {
		String path = request.getContextPath() + "/View/Image/";
		return path + dir + "/" + name;
	}
}
