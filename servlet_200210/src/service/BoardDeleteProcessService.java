package service;

import static db.JdbcUtil.*;

import java.sql.*;

import dao.DAO;

public class BoardDeleteProcessService {

	public int boardDelete(int boardNum) {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		int result = dao.boardDelete(boardNum);
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}

}
