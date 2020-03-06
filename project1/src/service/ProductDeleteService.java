package service;

import static db.JdbcUtil.*;

import java.sql.*;

import dao.ProductDAO;

public class ProductDeleteService {

	public int productDelete(int p_number) {
		ProductDAO dao = ProductDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		int result = dao.productDelete(p_number);
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}

}
