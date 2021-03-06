package service;

import static db.JdbcUtil.*;

import java.sql.*;

import dao.MemberDAO;

public class MemberLoginService {

	public boolean memberLogin(String id, String pw) {
		MemberDAO dao = MemberDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		boolean result = dao.memberLogin(id, pw);
		close(con);
		return result;
		
	}

}
