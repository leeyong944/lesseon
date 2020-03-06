package service;

import static db.JdbcUtil.*;

import java.sql.*;
import java.util.List;

import dao.ProductDAO;
import dto.BoardDTO;

public class ProductQnAService {

	public int listCount() {
		ProductDAO dao = ProductDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		int listCount = dao.boardListCount();
		close(con);
		return listCount;
	}
	
	
	public List<BoardDTO> boardList(int startRow, int endRow) {
		ProductDAO dao = ProductDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		List<BoardDTO> boardList = dao.boardList(startRow, endRow);
		close(con);
		return boardList;
	}


}
