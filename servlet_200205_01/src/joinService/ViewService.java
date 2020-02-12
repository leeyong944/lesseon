package joinService;

import static joinDb.JoinJdbcUtil.getConnection;
import java.sql.*;

import dto.MemberDTO;
import joinDao.JoinDAO;

public class ViewService {

	public MemberDTO view(String id) {
		JoinDAO dao = JoinDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		MemberDTO memberDTO = new MemberDTO();
		memberDTO = dao.memberview(id);
		return memberDTO;
		
	}

}
