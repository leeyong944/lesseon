package service;

import static db.JdbcUtil.*;

import java.sql.*;

import dao.BoardDAO;

public class BoardModifyProcessService {

	public int boardModify(int b_number, String b_categori, String b_contents) {
		BoardDAO dao = BoardDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		int result = dao.boardModify(b_number, b_categori, b_contents);
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
		
	}

}
