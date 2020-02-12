package service;

import static db.JdbcUtil.*;

import java.sql.*;
import java.util.*;

import dao.DAO;
import dto.BoardDTO;

public class ContentsService {
	
	public void readCount(int boardNum) {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		dao.readCount(boardNum);
		commit(con);
		close(con);
	}

	public BoardDTO view(int boardNum) {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		BoardDTO boardList = dao.view(boardNum);
		close(con);
		return boardList;
		
	}


}
