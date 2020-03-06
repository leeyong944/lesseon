package service;

import static db.JdbcUtil.*;

import java.sql.*;

import dao.ProductDAO;
import dto.ProductDTO;

public class ProductViewService {

	public ProductDTO productView(int p_number) {
		ProductDAO dao = ProductDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		ProductDTO productView = dao.productView(p_number);
		close(con);
		return productView;
	}

}
