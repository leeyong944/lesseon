package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import dao.DAO;
import dto.BoardDTO;

public class OrderByService {

	public List<BoardDTO> orderByList() {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		List<BoardDTO> boardDTO = new ArrayList<BoardDTO>();
		boardDTO = dao.orderByList();
		close(con);
		return boardDTO;
	}

}
