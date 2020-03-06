package service;

import static db.JdbcUtil.*;
import java.sql.*;
import dao.MemberDAO;
import dto.MemberDTO;

public class MemberJoinService {

	public int memberJoin(MemberDTO memberDTO) {
		MemberDAO dao = MemberDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		
		int result = dao.memberJoin(memberDTO);
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return result;
		
		
	}

}
