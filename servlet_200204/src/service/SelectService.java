package service;

import dao.DAO;
import static db.JdbcUtil.*;
import java.sql.*;
import javax.sql.*;
import java.util.*;

public class SelectService {
	
	public List<String> selectDB() {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		List<String> select = new ArrayList<String>();
		select = dao.selectDB();
		close(con);
		return select;
	}

}
