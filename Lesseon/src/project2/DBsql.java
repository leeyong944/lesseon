package project2;

import java.sql.*;

public class DBsql {
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void dbConnection() {
		con = DBConnection.makeConnection();
	}

}
