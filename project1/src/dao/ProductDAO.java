package dao;

import static db.JdbcUtil.*;
import java.sql.*;
import java.util.*;

import dto.BoardDTO;
import dto.CartDTO;
import dto.ProductDTO;

public class ProductDAO {
	private static ProductDAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public static ProductDAO getInstance() {
		if(dao == null) {
			dao = new ProductDAO();
		}
		return dao;
	}
	
	public void setConnection(Connection con) {
		this.con = con;
	}


	public int listCount() {
		int listCount = 0;
		String sql = "SELECT COUNT(*) FROM PRODUCT";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return listCount;
	}

	public List<ProductDTO> productList(int startRow, int endRow) {
		List<ProductDTO> productList = new ArrayList<ProductDTO>();
		ProductDTO productDTO = null;
		String sql = "SELECT * FROM PRODUCTLIST WHERE RN BETWEEN ? AND ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				productDTO = new ProductDTO();
				productDTO.setP_number(rs.getInt("P_NUMBER"));
				productDTO.setP_name(rs.getString("P_NAME"));
				productDTO.setP_categori(rs.getString("P_CATEGORI"));
				productDTO.setP_desc(rs.getString("P_DESC"));
				productDTO.setP_price(rs.getInt("P_PRICE"));
				productDTO.setP_stock(rs.getInt("P_STOCK"));
				productDTO.setP_file(rs.getString("P_FILE"));
				productList.add(productDTO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return productList;
	}

	public ProductDTO productView(int p_number) {
		ProductDTO productView = null;
		String sql = "SELECT * FROM PRODUCT WHERE P_NUMBER=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, p_number);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				productView = new ProductDTO();
				productView.setP_number(rs.getInt("P_NUMBER"));
				productView.setP_name(rs.getString("P_NAME"));
				productView.setP_categori(rs.getString("P_CATEGORI"));
				productView.setP_desc(rs.getString("P_DESC"));
				productView.setP_price(rs.getInt("P_PRICE"));
				productView.setP_stock(rs.getInt("P_STOCK"));
				productView.setP_file(rs.getString("P_FILE"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return productView;
	}

	public int productCart(CartDTO productCart) {
		int result = 0;
		String sql = "INSERT INTO CART VALUES(?,?,DEFAULT)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, productCart.getId());
			pstmt.setInt(2, productCart.getP_number());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public List<ProductDTO> searchList(int startRow, int endRow, String search) {
		List<ProductDTO> searchList = new ArrayList<ProductDTO>();
		ProductDTO productDTO = null;
		String sql = "SELECT * FROM PRODUCTLIST WHERE P_NAME LIKE ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+search+"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				productDTO = new ProductDTO();
				productDTO.setP_number(rs.getInt("P_NUMBER"));
				productDTO.setP_name(rs.getString("P_NAME"));
				productDTO.setP_categori(rs.getString("P_CATEGORI"));
				productDTO.setP_desc(rs.getString("P_DESC"));
				productDTO.setP_price(rs.getInt("P_PRICE"));
				productDTO.setP_stock(rs.getInt("P_STOCK"));
				productDTO.setP_file(rs.getString("P_FILE"));
				searchList.add(productDTO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return searchList;
	}

	public int listCount(String search) {
		int listCount = 0;
		String sql = "SELECT COUNT(*) FROM PRODUCT WHERE P_NAME LIKE ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+search+"%");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return listCount;
	}

	public int productAdd(ProductDTO productDTO) {
		int result = 0;
		String sql = "INSERT INTO PRODUCT VALUES(PRODUCT_SEQ.NEXTVAL,?,?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, productDTO.getP_name());
			pstmt.setString(2, productDTO.getP_categori());
			pstmt.setString(3, productDTO.getP_desc());
			pstmt.setInt(4, productDTO.getP_price());
			pstmt.setInt(5, productDTO.getP_stock());
			pstmt.setString(6, productDTO.getP_file());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ProductDTO productModify(int p_number) {
		ProductDTO productModify = null;
		String sql = "SELECT * FROM PRODUCT WHERE P_NUMBER = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, p_number);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				productModify = new ProductDTO();
				productModify.setP_number(rs.getInt("P_NUMBER"));
				productModify.setP_name(rs.getString("P_NAME"));
				productModify.setP_categori(rs.getString("P_CATEGORI"));
				productModify.setP_desc(rs.getString("P_DESC"));
				productModify.setP_price(rs.getInt("P_PRICE"));
				productModify.setP_stock(rs.getInt("P_STOCK"));
				productModify.setP_file(rs.getString("P_FILE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return productModify;
	}

	public int productModifyProcess(ProductDTO productDTO) {
		int result = 0;
		String sql = "UPDATE PRODUCT SET P_NAME=?, P_CATEGORI=?, P_DESC=?, P_PRICE=?, P_STOCK=?, P_FILE=? WHERE P_NUMBER=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, productDTO.getP_name());
			pstmt.setString(2, productDTO.getP_categori());
			pstmt.setString(3, productDTO.getP_desc());
			pstmt.setInt(4, productDTO.getP_price());
			pstmt.setInt(5, productDTO.getP_stock());
			pstmt.setString(6, productDTO.getP_file());
			pstmt.setInt(7, productDTO.getP_number());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int productDelete(int p_number) {
		int result = 0;
		String sql = "DELETE FROM PRODUCT WHERE P_NUMBER = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, p_number);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int boardListCount() {
		int listCount = 0;
		String sql = "SELECT COUNT(*) FROM BOARD";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return listCount;
	}
	
	public List<BoardDTO> boardList(int startRow, int endRow) {
		List<BoardDTO> boardList = new ArrayList<BoardDTO>();
		BoardDTO boardDTO = null;
		String sql = "SELECT * FROM BOARDLIST WHERE RN BETWEEN ? AND ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				boardDTO = new BoardDTO();
				boardDTO.setB_number(rs.getInt("B_NUMBER"));
				boardDTO.setId(rs.getString("M_ID"));
				boardDTO.setB_categori(rs.getString("B_CATEGORI"));
				boardDTO.setB_contents(rs.getString("B_CONTENTS"));
				boardDTO.setB_password(rs.getString("B_PASSWORD"));
				boardDTO.setB_date(rs.getString("B_DATE"));
				boardList.add(boardDTO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return boardList;
	}

	public List<CartDTO> cartList(String id) {
		List<CartDTO> cartList = new ArrayList<CartDTO>();
		CartDTO cartDTO = null;
		String sql = "SELECT C.M_ID, P.P_FILE, P.P_NAME, P.P_PRICE, P.P_NUMBER FROM CART C, PRODUCT P WHERE C.P_NUMBER = P.P_NUMBER AND M_ID=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				cartDTO = new CartDTO();
				cartDTO.setId(rs.getString("M_ID"));
				cartDTO.setP_file(rs.getString("P_FILE"));
				cartDTO.setP_name(rs.getString("P_NAME"));
				cartDTO.setP_price(rs.getInt("P_PRICE"));
				cartDTO.setP_number(rs.getInt("P_NUMBER"));
				cartList.add(cartDTO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return cartList;
	}

	public ProductDTO productInformation(int p_number) {
		ProductDTO productDTO = new ProductDTO();
		String sql = "SELECT * FROM PRODUCT WHERE P_NUMBER=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, p_number);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				productDTO.setP_number(rs.getInt("P_NUMBER"));
				productDTO.setP_name(rs.getString("P_NAME"));
				productDTO.setP_categori(rs.getString("P_CATEGORI"));
				productDTO.setP_desc(rs.getString("P_DESC"));
				productDTO.setP_price(rs.getInt("P_PRICE"));
				productDTO.setP_stock(rs.getInt("P_STOCK"));
				productDTO.setP_file(rs.getString("P_FILE"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return productDTO;
	}

}
