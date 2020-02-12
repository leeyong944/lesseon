package service;

import static db.JdbcUtil.getConnection;
import java.sql.*;
import dao.DAO;
import java.util.*;

public class SelectService {
	
	public List<String> SelectDB(){
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		List<String> select = new ArrayList<String>();
		select = dao.selectDB();
		return select;
	}
}
