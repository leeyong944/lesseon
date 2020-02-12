package dao;

import static db.JdbcUtil.*;
import java.sql.*;
import java.util.*;

import dto.BoardDTO;

public class DAO {
	private static DAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public static DAO getInstance() {
		if(dao == null) {
			dao = new DAO();
		}
		return dao;
	}
	
	public void setConnection(Connection con) {
		this.con = con;
	}

	public int writing(BoardDTO boardDTO) {
		int result = 0;
		String sql = "INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL,?,?,?,SYSDATE,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, boardDTO.getTitle());
			pstmt.setString(2, boardDTO.getName());
			pstmt.setString(3, boardDTO.getContents());
			pstmt.setString(4, boardDTO.getPassword());
			pstmt.setInt(5, 0);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public List<BoardDTO> list() {
		String sql = "SELECT * FROM BOARD";
		BoardDTO boardDTO = null;
		List<BoardDTO> boardList = new ArrayList<BoardDTO>();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				boardDTO = new BoardDTO();
				boardDTO.setBoardnum(rs.getInt("BOARDNUM"));
				boardDTO.setTitle(rs.getString("TITLE"));
				boardDTO.setName(rs.getString("NAME"));
				boardDTO.setDatetime(rs.getDate("DATETIME"));
				boardDTO.setHit(rs.getInt("HIT"));
				boardDTO.setPassword(rs.getString("PASSWORD"));
				boardList.add(boardDTO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return boardList;
	}

	public BoardDTO view(int boardNum) {
		String sql = "SELECT * FROM BOARD WHERE BOARDNUM=?";
		BoardDTO boardDTO = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				boardDTO = new BoardDTO();
				boardDTO.setBoardnum(rs.getInt("BOARDNUM"));
				boardDTO.setTitle(rs.getString("TITLE"));
				boardDTO.setName(rs.getString("NAME"));
				boardDTO.setContents(rs.getString("CONTENTS"));
				boardDTO.setDatetime(rs.getDate("DATETIME"));
				boardDTO.setHit(rs.getInt("HIT"));
				boardDTO.setPassword(rs.getString("PASSWORD"));
				boardDTO.setbFile(rs.getString("BFILE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return boardDTO;
	}

	public void readCount(int boardNum) {
		String sql = "UPDATE BOARD SET HIT = HIT + 1 WHERE BOARDNUM = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
	}

	public List<BoardDTO> orderByList() {
		String sql = "SELECT * FROM BOARD ORDER BY HIT DESC";
		BoardDTO boardDTO = null;
		List<BoardDTO> boardList = new ArrayList<BoardDTO>();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				boardDTO = new BoardDTO();
				boardDTO.setBoardnum(rs.getInt("BOARDNUM"));
				boardDTO.setTitle(rs.getString("TITLE"));
				boardDTO.setName(rs.getString("NAME"));
				boardDTO.setDatetime(rs.getDate("DATETIME"));
				boardDTO.setHit(rs.getInt("HIT"));
				boardList.add(boardDTO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return boardList;
	}


	public int boardModify(BoardDTO boardDTO) {
		String sql = "UPDATE BOARD SET TITLE=?, CONTENTS=? WHERE BOARDNUM=?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, boardDTO.getTitle());
			pstmt.setString(2, boardDTO.getContents());
			pstmt.setInt(3, boardDTO.getBoardnum());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int boardDelete(int boardNum) {
		String sql = "DELETE FROM BOARD WHERE BOARDNUM=?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
	}

	public int boardWriteFile(BoardDTO boardDTO) {
		int result = 0;
		String sql = "INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL,?,?,?,SYSDATE,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, boardDTO.getTitle());
			pstmt.setString(2, boardDTO.getName());
			pstmt.setString(3, boardDTO.getContents());
			pstmt.setString(4, boardDTO.getPassword());
			pstmt.setInt(5, 0);
			pstmt.setString(6, boardDTO.getbFile());
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
