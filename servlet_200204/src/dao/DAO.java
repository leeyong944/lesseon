package dao;

import static db.JdbcUtil.*;
import java.sql.*;
import javax.sql.*;
import java.util.*;

public class DAO {
	private static DAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	//DAO(Data Access Object)
	public static DAO getInstance() {
		if(dao == null) {
			dao = new DAO();
		}
		return dao;
	}
	
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	public int inputDB(String data1, String data2) {
		// 옛 기억을 살려서 TEST 테이블에 data1, data2에 담긴 값을 저장하고
		// sql developer에서 저장된 데이터를 확인해보세요.
		String sql = "INSERT INTO TEST VALUES(?,?)";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, data1);
			pstmt.setString(2, data2);
			result = pstmt.executeUpdate();
//			if(result>0) {
//				commit(con);
//			}else {
//				rollback(con);
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
		
	}

	public List<String> selectDB() {
		List<String> select = new ArrayList<String>();
		String sql = "SELECT * FROM TEST";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				select.add(rs.getString("date1"));
				select.add(rs.getString("date2"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return select;
		
	}
	
	

}