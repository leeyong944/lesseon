package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;
import dto.CartDTO;
import service.ProductCartListService;

@WebServlet("/productCartList")
public class ProductCartListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductCartListController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	HttpSession session = request.getSession();
    	String id = request.getParameter("id");
    	List<CartDTO> cartList = new ArrayList<CartDTO>();
    	ProductCartListService pcls = new ProductCartListService();
    	cartList = pcls.cartList(id);
    	session.setAttribute("cartList", cartList);
    	RequestDispatcher dispatch = request.getRequestDispatcher("ProductCart.jsp");
    	dispatch.forward(request, response);
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


}
