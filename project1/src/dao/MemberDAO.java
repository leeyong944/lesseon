package dao;

import static db.JdbcUtil.*;
import java.sql.*;
import java.util.*;

import dto.MemberDTO;

public class MemberDAO {
	private static MemberDAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public static MemberDAO getInstance() {
		if(dao == null) {
			dao = new MemberDAO();
		}
		return dao;
	}
	
	public void setConnection(Connection con) {
		this.con = con;
	}

	public int memberJoin(MemberDTO memberDTO) {
		int result = 0;
		String sql = "INSERT INTO MEMBER VALUES(?,?,?,?,?,?,?,?,DEFAULT)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getId());
			pstmt.setString(2, memberDTO.getPw());
			pstmt.setString(3, memberDTO.getName());
			pstmt.setString(4, memberDTO.getAddress1()+"/"+memberDTO.getAddress2()+"/"+memberDTO.getAddress3()+"/"+memberDTO.getAddress4()+"/"+memberDTO.getAddress5());
			pstmt.setString(5, memberDTO.getBirth());
			pstmt.setString(6, memberDTO.getTel());
			pstmt.setString(7, memberDTO.getGender());
			pstmt.setString(8, memberDTO.getEmail());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
		
	}

	public boolean memberLogin(String id, String pw) {
		boolean result = false;
		String sql = "SELECT * FROM MEMBER WHERE M_ID = ? AND M_PW = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = true;
			}else {
				result = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return result;
	}

	public List<MemberDTO> memberList() {
		List<MemberDTO> memberList = new ArrayList<MemberDTO>();
		MemberDTO memberDTO = null;
		String sql = "SELECT * FROM MEMBER";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				memberDTO = new MemberDTO();
				memberDTO.setId(rs.getString("M_ID"));
				memberDTO.setPw(rs.getString("M_PW"));
				memberDTO.setName(rs.getString("M_NAME"));
				memberDTO.setAddress1(rs.getString("M_ADDRESS"));
				memberDTO.setBirth(rs.getString("M_BIRTH"));
				memberDTO.setTel(rs.getString("M_TEL"));
				memberDTO.setGender(rs.getString("M_GENDER"));
				memberDTO.setEmail(rs.getString("M_EMAIL"));
				memberDTO.setPoint(rs.getInt("M_POINT"));
				memberList.add(memberDTO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return memberList;
	}

	public MemberDTO memberView(String id) {
		String sql = "SELECT * FROM MEMBER WHERE M_ID=?";
		MemberDTO memberView = new MemberDTO();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberView.setId(rs.getString("M_ID"));
				memberView.setPw(rs.getString("M_PW"));
				memberView.setName(rs.getString("M_NAME"));
				memberView.setAddress1(rs.getString("M_ADDRESS"));
				memberView.setBirth(rs.getString("M_BIRTH"));
				memberView.setTel(rs.getString("M_TEL"));
				memberView.setGender(rs.getString("M_GENDER"));
				memberView.setEmail(rs.getString("M_EMAIL"));
				memberView.setPoint(rs.getInt("M_POINT"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return memberView;
	}

	public int memberDelete(String id) {
		int result = 0;
		String sql = "DELETE FROM MEMBER WHERE M_ID=?";
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

	public MemberDTO memberView1(String id) {
		String sql = "SELECT * FROM MEMBER WHERE M_ID=?";
		MemberDTO memberView = new MemberDTO();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String address = rs.getString("M_ADDRESS");
				String[] array = address.split("/");
				memberView.setId(rs.getString("M_ID"));
				memberView.setPw(rs.getString("M_PW"));
				memberView.setName(rs.getString("M_NAME"));
				memberView.setAddress1(array[0]);
				memberView.setAddress2(array[1]);
				memberView.setAddress3(array[2]);
				memberView.setAddress4(array[3]);
				memberView.setAddress5(array[4]);
				memberView.setBirth(rs.getString("M_BIRTH"));
				memberView.setTel(rs.getString("M_TEL"));
				memberView.setGender(rs.getString("M_GENDER"));
				memberView.setEmail(rs.getString("M_EMAIL"));
				memberView.setPoint(rs.getInt("M_POINT"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return memberView;
	}

	public int memberModify(MemberDTO memberDTO) {
		int result = 0;
		String sql = "UPDATE MEMBER SET M_PW=?, M_NAME=?, M_ADDRESS=?, M_TEL=?, M_GENDER=?, M_EMAIL=? WHERE M_ID=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getPw());
			pstmt.setString(2, memberDTO.getName());
			pstmt.setString(3, memberDTO.getAddress1()+"/"+memberDTO.getAddress2()+"/"+memberDTO.getAddress3()+"/"+memberDTO.getAddress4()+"/"+memberDTO.getAddress5());
			pstmt.setString(4, memberDTO.getTel());
			pstmt.setString(5, memberDTO.getGender());
			pstmt.setString(6, memberDTO.getEmail());
			pstmt.setString(7, memberDTO.getId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public MemberDTO memberInformation(String id) {
		MemberDTO memberDTO = new MemberDTO();
		String sql = "SELECT * FROM MEMBER WHERE M_ID=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String address = rs.getString("M_ADDRESS");
				String[] array = address.split("/");
				memberDTO.setId(rs.getString("M_ID"));
				memberDTO.setPw(rs.getString("M_PW"));
				memberDTO.setName(rs.getString("M_NAME"));
				memberDTO.setAddress1(array[0]);
				memberDTO.setAddress2(array[1]);
				memberDTO.setAddress3(array[2]);
				memberDTO.setAddress4(array[3]);
				memberDTO.setAddress5(array[4]);
				memberDTO.setBirth(rs.getString("M_BIRTH"));
				memberDTO.setTel(rs.getString("M_TEL"));
				memberDTO.setGender(rs.getString("M_GENDER"));
				memberDTO.setEmail(rs.getString("M_EMAIL"));
				memberDTO.setPoint(rs.getInt("M_POINT"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return memberDTO;
	}
}
