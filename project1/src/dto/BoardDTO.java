package dto;

public class BoardDTO {
	private int b_number;
	private String id;
	private String b_categori;
	private String b_contents;
	private String b_password;
	private String b_date;
	
	public String getB_categori() {
		return b_categori;
	}
	public void setB_categori(String b_categori) {
		this.b_categori = b_categori;
	}
	public int getB_number() {
		return b_number;
	}
	public void setB_number(int b_number) {
		this.b_number = b_number;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getB_contents() {
		return b_contents;
	}
	public void setB_contents(String b_contents) {
		this.b_contents = b_contents;
	}
	public String getB_password() {
		return b_password;
	}
	public void setB_password(String b_password) {
		this.b_password = b_password;
	}
	public String getB_date() {
		return b_date;
	}
	public void setB_date(String b_date) {
		this.b_date = b_date;
	}
	
	
}
