package service;

import static db.JdbcUtil.*;

import java.sql.*;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberModifyService {

	public MemberDTO memberView(String id) {
		MemberDAO dao = MemberDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		MemberDTO memberView = dao.memberView1(id);
		close(con);
		return memberView;
	}

}
