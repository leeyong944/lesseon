package joinService;

import static joinDb.JoinJdbcUtil.*;

import java.sql.Connection;

import dto.MemberDTO;
import joinDao.JoinDAO;

public class MemberModifyProcessService {

	public int memberModify(MemberDTO member) {
		JoinDAO dao = JoinDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		int modifyResult = dao.memberModify(member);
		if(modifyResult>0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return modifyResult;
		
	}

}
