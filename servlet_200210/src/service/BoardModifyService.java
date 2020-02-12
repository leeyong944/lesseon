package service;

import static db.JdbcUtil.*;

import java.sql.*;
import java.util.*;

import dao.DAO;
import dto.BoardDTO;

public class BoardModifyService {

	public BoardDTO boardModify(int boardNum) {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);

		BoardDTO boardList = dao.view(boardNum);
		return boardList;
	}

	

}
