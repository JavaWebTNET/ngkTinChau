package models;

import javax.servlet.http.HttpServletRequest;

import dao.ImageDao;

public class DichVu {
	private int id_dv;
	private String name_dv;
	private String image;
	private String detail;
	public static String uploadDir = "dichvu";
	
	public int getId_dv() {
		return id_dv;
	}
	
	public void setId_dv(int id_dv) {
		this.id_dv = id_dv;
	}
	
	public String getName_dv() {
		return name_dv;
	}
	
	public void setName_dv(String name_dv) {
		this.name_dv = name_dv;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getDetail() {
		return detail;
	}
	
	public void setDetail(String detail) {
		this.detail = detail;
	}	
	
	public  String imageLink(HttpServletRequest request) {
		return ImageDao.imageLink(request, DichVu.uploadDir, this.getImage());
	}
	
	public String subDetail() {
		String plainDetail =detail.replaceAll("\\<.*?\\>", "");
		String[] arrDetail = plainDetail.split(" ");
		String subDetail = "";
		int i = 1;
		for(String word: arrDetail) {
			if(i>20) break;
			subDetail = subDetail + " " + word;
			i++;
		}
		return subDetail;
	}
}
