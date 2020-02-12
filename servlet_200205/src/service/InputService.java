package service;

import dao.DAO;
import static db.JdbcUtil.*;
import java.sql.*;
import javax.sql.*;

public class InputService {

	public boolean inputDB(String data1) {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		boolean inputResult;
		int result;
		result = dao.inputDB(data1);
		if(result > 0) {
			commit(con);
			inputResult = true;
		} else {
			commit(con);
			inputResult = false;
		}
		return inputResult;
	}

}
