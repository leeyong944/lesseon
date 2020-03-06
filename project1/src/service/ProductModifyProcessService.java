package service;

import static db.JdbcUtil.*;

import java.sql.*;

import dao.ProductDAO;
import dto.ProductDTO;

public class ProductModifyProcessService {

	public int productModifyProcess(ProductDTO productDTO) {
		ProductDAO dao = ProductDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		int result = dao.productModifyProcess(productDTO);
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}

}
