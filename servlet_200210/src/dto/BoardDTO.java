package dto;

import java.sql.Date;

public class BoardDTO {
	private int boardnum;
	private String title;
	private String name;
	private String contents;
	private Date datetime;
	private String password;
	private int hit;
	
	private String bFile;
	
	
	public BoardDTO(int boardnum, String title, String name, String contents, Date datetime, String password, int hit, String bFile) {
		this.boardnum = boardnum;
		this.title = title;
		this.name = name;
		this.contents = contents;
		this.datetime = datetime;
		this.password = password;
		this.hit = hit;
		this.bFile = bFile;
	}

	public BoardDTO() {
		
	}

	public int getBoardnum() {
		return boardnum;
	}

	public void setBoardnum(int boardnum) {
		this.boardnum = boardnum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getbFile() {
		return bFile;
	}

	public void setbFile(String bFile) {
		this.bFile = bFile;
	}

	
	
	
	
	
}
