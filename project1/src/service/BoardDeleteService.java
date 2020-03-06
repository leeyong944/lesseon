package service;

import static db.JdbcUtil.*;

import java.sql.*;

import dao.BoardDAO;

public class BoardDeleteService {

	public int boardDelete(int b_number) {
		BoardDAO dao = BoardDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		int result = dao.boardDelete(b_number);
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}

}
