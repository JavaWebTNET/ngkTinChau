package models;

public class SanPham {
	private int id;
	private String title;
	private String image;
	private int prominent;
	private String detail;
	private int super_id;
	
	 public SanPham(){}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getProminent() {
		return prominent;
	}
	public void setProminent(int prominent) {
		this.prominent = prominent;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getSuper_id() {
		return super_id;
	}
	public void setSuper_id(int super_id) {
		this.super_id = super_id;
	}
	
	

}
