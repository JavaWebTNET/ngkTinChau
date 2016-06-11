package models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TuyenDung {
	private int id;
	private String title;
	private String detail;
	private Date create_at;
	private Date update_at;
	
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
	
	public Date getCreate_at() {
		return create_at;
	}

	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}

	public Date getUpdate_at() {
		return update_at;
	}

	public void setUpdate_at(Date update_at) {
		this.update_at = update_at;
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
	
	public String createAt() {
		DateFormat df = new SimpleDateFormat("dd/MM/Y HH:mm:ss");
		return df.format(create_at);
	}
	
	public String updateAt() {
		DateFormat df = new SimpleDateFormat("dd/MM/Y HH:mm:ss");
		return df.format(update_at);
	}
}
