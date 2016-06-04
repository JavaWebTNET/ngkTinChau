package models;

public class DanhMuc {
	private int id;
	private String title;
	private int super_id;
	private String detail;
	
	public DanhMuc() {
		
	}
	
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
