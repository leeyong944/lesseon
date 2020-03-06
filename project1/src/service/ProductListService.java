package service;

import static db.JdbcUtil.*;

import java.sql.*;
import java.util.List;

import dao.ProductDAO;
import dto.ProductDTO;

public class ProductListService {


	public int listCount() {
		ProductDAO dao = ProductDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		int listCount = dao.listCount();
		close(con);
		return listCount;
	}

	public List<ProductDTO> productList(int startRow, int endRow) {
		ProductDAO dao = ProductDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		List<ProductDTO> productList = dao.productList(startRow, endRow);
		close(con);
		return productList;
	}


	public int searchCount(String search) {
		ProductDAO dao = ProductDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		int listCount = dao.listCount(search);
		close(con);
		return listCount;
	}

	public List<ProductDTO> productSearchList(String search, int startRow, int endRow) {
		ProductDAO dao = ProductDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		List<ProductDTO> searchList = dao.searchList(startRow, endRow, search);
		close(con);
		return searchList;
	}

}
