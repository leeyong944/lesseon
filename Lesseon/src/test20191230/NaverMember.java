package test20191230;

public class NaverMember {
	private String id;
	private String password;
	private String name;
	private String birth;
	private String gender;
	private String mail;
	private String phone;
	
	public NaverMember() {
		
	}
	
	
	public NaverMember(String id, String password, String name, String birth, String gender, String mail,
			String phone) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.mail = mail;
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "NaverMember [id=" + id + ", password=" + password + ", name=" + name + ", birth=" + birth + ", gender="
				+ gender + ", mail=" + mail + ", phone=" + phone + "]";
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBirth() {
		return birth;
	}


	public void setBirth(String birth) {
		this.birth = birth;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	
	
	

}
