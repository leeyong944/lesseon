package dao;

import static db.JdbcUtil.*;
import java.sql.*;
import java.util.*;

import dto.BoardDTO;

public class BoardDAO {
	private static BoardDAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public static BoardDAO getInstance() {
		if(dao == null) {
			dao = new BoardDAO();
		}
		return dao;
	}
	
	public void setConnection(Connection con) {
		this.con = con;
	}

	public int boardWrite(BoardDTO boardDTO) {
		int result = 0;
		String sql = "INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL,?,?,?,?,SYSDATE)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, boardDTO.getId());
			pstmt.setString(2, boardDTO.getB_categori());
			pstmt.setString(3, boardDTO.getB_contents());
			pstmt.setString(4, boardDTO.getB_password());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public BoardDTO boardView(int b_number) {
		BoardDTO boardView = new BoardDTO();
		String sql = "SELECT * FROM BOARD WHERE B_NUMBER=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, b_number);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				boardView.setB_number(rs.getInt("B_NUMBER"));
				boardView.setId(rs.getString("M_ID"));
				boardView.setB_categori(rs.getString("B_CATEGORI"));
				boardView.setB_contents(rs.getString("B_CONTENTS"));
				boardView.setB_password(rs.getString("B_PASSWORD"));
				boardView.setB_date(rs.getString("B_DATE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			close(pstmt);
			close(rs);
		}
		return boardView;
	}

	public int boardModify(int b_number, String b_categori, String b_contents) {
		int result = 0;
		String sql = "UPDATE BOARD SET B_CATEGORI=?, B_CONTENTS=? WHERE B_NUMBER=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, b_categori);
			pstmt.setString(2, b_contents);
			pstmt.setInt(3, b_number);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int boardDelete(int b_number) {
		int result = 0;
		String sql = "DELETE FROM BOARD WHERE B_NUMBER=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, b_number);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
}
