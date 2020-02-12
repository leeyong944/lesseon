package service;

import static db.JdbcUtil.*;

import java.sql.*;

import dao.DAO;
import dto.BoardDTO;

public class BoardDeleteService {

	public BoardDTO boardDelete(int boardNum) {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		BoardDTO boardDTO = dao.view(boardNum);
		return boardDTO;
	}

}
