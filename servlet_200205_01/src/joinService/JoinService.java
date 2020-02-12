package joinService;

import static joinDb.JoinJdbcUtil.*;
import java.sql.*;

import dto.MemberDTO;
import joinDao.JoinDAO;

public class JoinService {

	public boolean inputJoin(MemberDTO member) {
		JoinDAO dao = JoinDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		int joinResult;
		boolean result = false;
		joinResult = dao.inputJoin(member);
		if(joinResult > 0) {
			result = true;
			commit(con);
		} else {
			result = false;
			commit(con);
		}
		return result;
	}

}
