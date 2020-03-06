package service;

import static db.JdbcUtil.*;

import java.sql.*;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberModifyProcessService {

	public int memberModify(MemberDTO memberDTO) {
		MemberDAO dao = MemberDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		int result = dao.memberModify(memberDTO);
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}

}
