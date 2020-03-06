package service;

import static db.JdbcUtil.*;

import java.sql.*;

import dao.BoardDAO;
import dto.BoardDTO;

public class BoardModifyService {

	public BoardDTO boardView(int b_number) {
		BoardDAO dao = BoardDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		BoardDTO boardView = dao.boardView(b_number);
		return boardView;
	}

}
