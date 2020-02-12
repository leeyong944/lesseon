package joinService;

import static joinDb.JoinJdbcUtil.getConnection;
import java.sql.Connection;
import joinDao.JoinDAO;
import java.util.*;

import dto.MemberDTO;

public class LoginService {
	
	public boolean memberLogin(String id, String password){
		JoinDAO dao = JoinDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		boolean login;
		login = dao.memberLogin(id,password);
		return login;
	}
}
