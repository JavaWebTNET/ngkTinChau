package models;

import javax.servlet.http.HttpServletRequest;

import dao.ImageDao;

public class Slider {	
	private int id_sd;
	private String title;
	private String image;
	public static String uploadDir = "slider";
	
	public Slider(){}
	
	public int getId_sd() {
		return id_sd;
	}
	
	public void setId_sd(int id_sd) {
		this.id_sd = id_sd;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public String imageLink(HttpServletRequest request) {
		return ImageDao.imageLink(request, Slider.uploadDir, this.getImage());
	}
}
