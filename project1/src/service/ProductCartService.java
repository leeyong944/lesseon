package service;

import static db.JdbcUtil.*;

import java.sql.*;

import dao.ProductDAO;
import dto.CartDTO;

public class ProductCartService {

	public int productCart(CartDTO productCart) {
		ProductDAO dao = ProductDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		int result = dao.productCart(productCart);
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}

}
