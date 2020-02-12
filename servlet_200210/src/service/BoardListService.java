package service;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.*;

import dao.DAO;
import dto.BoardDTO;

public class BoardListService {

	public List<BoardDTO> list() {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		List<BoardDTO> boardDTO = new ArrayList<BoardDTO>();
		boardDTO = dao.list();
		close(con);
		return boardDTO;
		
	}

}
