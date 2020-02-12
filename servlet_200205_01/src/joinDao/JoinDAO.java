package joinDao;

import static joinDb.JoinJdbcUtil.*;
import java.sql.*;
import javax.sql.*;
import dto.MemberDTO;


import java.util.*;

public class JoinDAO {
	private static JoinDAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public static JoinDAO getInstance() {
		if(dao == null) {
			dao = new JoinDAO();
		}
		return dao;
	}
	
	public void setConnection(Connection con) {
		this.con = con;
	}

	public int inputJoin(MemberDTO member) {
		String sql = "INSERT INTO MEMBER VALUES(?,?,?,?,?,?)";
		int joinResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getBirth());
			pstmt.setString(5, member.getGender());
			pstmt.setString(6, member.getEmail()+member.getEmail2());
			joinResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return joinResult;
	}
	
	public boolean memberLogin(String id, String password) {
		boolean login = false;
		String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PASSWORD = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			MemberDTO memberDTO = new MemberDTO();
			rs = pstmt.executeQuery();
			if(rs.next()) {
				login = true;
			} else {
				login = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return login;
	}

	public List<MemberDTO> memberList() {
		List<MemberDTO> memberList = new ArrayList<MemberDTO>();
		String sql = "SELECT * FROM MEMBER";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDTO memberDTO = new MemberDTO();
				memberDTO.setId(rs.getString("ID"));
				memberDTO.setPassword(rs.getString("PASSWORD"));
				memberDTO.setName(rs.getString("NAME"));
				memberDTO.setBirth(rs.getString("BIRTH"));
				memberDTO.setGender(rs.getString("GENDER"));
				memberDTO.setEmail(rs.getString("EMAIL"));
				memberList.add(memberDTO);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return memberList;
	}
	
	public MemberDTO memberview(String id){
		MemberDTO memberList = new MemberDTO();
		String sql = "SELECT * FROM MEMBER WHERE ID=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				memberList.setId(rs.getString("ID"));
				memberList.setPassword(rs.getString("PASSWORD"));
				memberList.setName(rs.getString("NAME"));
				memberList.setBirth(rs.getString("BIRTH"));
				memberList.setGender(rs.getString("GENDER"));
				memberList.setEmail(rs.getString("Email"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return memberList;
		
	}

	public int modify(String id, String password, String name, String email) {
		String sql = "UPDATE MEMBER SET PASSWORD=?, NAME=?, EMAIL=? WHERE ID = ?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setString(2, name);
			pstmt.setString(3, email);
			pstmt.setString(4, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int memberModify(MemberDTO member) {
		String sql = "UPDATE MEMBER SET NAME=?, EMAIL=? WHERE ID=?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getEmail());
			pstmt.setString(3, member.getId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int memberDelete(String id) {
		int result = 0;
		String sql = "DELETE FROM MEMBER WHERE ID=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
}