package service;

import static db.JdbcUtil.*;

import java.sql.*;
import java.util.*;

import dao.ProductDAO;
import dto.CartDTO;

public class ProductCartListService {

	public List<CartDTO> cartList(String id) {
		ProductDAO dao = ProductDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		List<CartDTO> cartList = dao.cartList(id);
		return cartList;
	}

}
