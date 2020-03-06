package service;

import static db.JdbcUtil.*;

import java.sql.*;

import dao.MemberDAO;
import dao.ProductDAO;
import dto.MemberDTO;
import dto.ProductDTO;

public class ProductBuyService {

	public ProductDTO productInformation(int p_number) {
		ProductDAO dao = ProductDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		ProductDTO productDTO = dao.productInformation(p_number);
		close(con);
		return productDTO;
	}

	public MemberDTO memberInformation(String id) {
		MemberDAO dao = MemberDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		MemberDTO memberDTO = dao.memberInformation(id);
		close(con);
		return memberDTO;
	}

}
