package joinService;

import static joinDb.JoinJdbcUtil.*;
import java.sql.*;

import dto.MemberDTO;
import joinDao.JoinDAO;

public class ModifyService {

	public MemberDTO modify(String id) {
		JoinDAO dao = JoinDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		MemberDTO memberModify = dao.memberview(id);
		return memberModify;
		
//		boolean modifyResult = false;
//		int result = dao.modify(id, password, name, email);
//		if(result>0) {
//			modifyResult = true;
//			commit(con);
//		} else {
//			modifyResult = false;
//			commit(con);
//		}
//		return modifyResult;
//	}
	}
}
