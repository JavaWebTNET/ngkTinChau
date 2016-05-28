package models;

public class ThongTin {
	private int id_tt;
	private String type_company;
	private String name_company ;
	private String add_company;
	private String tel;
	private String fax;
	private String email;
	private String hotline;
	private String slogan;
	private String word_run;
	private String logo;
	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public ThongTin(){}
	
	public int getId_tt() {
		return id_tt;
	}
	
	public void setId_tt(int id_tt) {
		this.id_tt = id_tt;
	}
	
	public String getType_company() {
		return type_company;
	}
	
	public void setType_company(String type_company) {
		this.type_company = type_company;
	}
	
	public String getName_company() {
		return name_company;
	}
	
	public void setName_company(String name_company) {
		this.name_company = name_company;
	}
	
	public String getAdd_company() {
		return add_company;
	}
	
	public void setAdd_company(String add_company) {
		this.add_company = add_company;
	}
	
	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getFax() {
		return fax;
	}
	
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getHotline() {
		return hotline;
	}
	
	public void setHotline(String hotline) {
		this.hotline = hotline;
	}
	
	public String getSlogan() {
		return slogan;
	}
	
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
	
	public String getWord_run() {
		return word_run;
	}
	
	public void setWord_run(String word_run) {
		this.word_run = word_run;
	}
}
