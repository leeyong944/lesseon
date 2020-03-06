package service;

import static db.JdbcUtil.*;

import java.sql.*;

import dao.ProductDAO;
import dto.ProductDTO;

public class ProductModifyService {

	public ProductDTO productModify(int p_number) {
		ProductDAO dao = ProductDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		ProductDTO productModify = dao.productModify(p_number);
		close(con);
		return productModify;
	}

}
