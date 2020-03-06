package service;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;

public class MemberDeleteService {

	public int memberDelete(String id) {
		MemberDAO dao = MemberDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		int result = dao.memberDelete(id);
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return result;
	}

}
