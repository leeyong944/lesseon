package service;

import static db.JdbcUtil.*;

import java.sql.*;

import dao.DAO;
import dto.BoardDTO;

public class BoardModifyProcessService {

	public int boardModify(BoardDTO boardDTO) {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		int result = 0;
		result = dao.boardModify(boardDTO);
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}

}
