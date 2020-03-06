package service;

import static db.JdbcUtil.*;

import java.sql.*;

import dao.BoardDAO;
import dto.BoardDTO;

public class BoardWriteService {

	public int boardWrite(BoardDTO boardDTO) {
		BoardDAO dao = BoardDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		int result = dao.boardWrite(boardDTO);
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}

}
