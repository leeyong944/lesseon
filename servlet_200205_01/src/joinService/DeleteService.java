package joinService;

import static joinDb.JoinJdbcUtil.*;

import java.sql.Connection;

import joinDao.JoinDAO;

public class DeleteService {

	public int memberDelete(String id) {
		JoinDAO dao = JoinDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		int result = 0;
		result = dao.memberDelete(id);
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
		
		
	}

	
}
