package joinService;

import static joinDb.JoinJdbcUtil.getConnection;
import java.sql.*;
import joinDao.JoinDAO;
import java.util.*;

import dto.MemberDTO;

public class MemberListService {

	public List<MemberDTO> listLookUp() {
		JoinDAO dao = JoinDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		List<MemberDTO> memberList = new ArrayList<MemberDTO>();
		memberList = dao.memberList();
		return memberList;
	}

}
