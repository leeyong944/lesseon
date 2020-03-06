package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.CartDTO;
import service.ProductCartService;

@WebServlet("/productCart")
public class ProductCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductCartController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	String id = request.getParameter("id");
    	int p_number = Integer.parseInt(request.getParameter("p_number"));
    	int page = Integer.parseInt(request.getParameter("page"));
    	CartDTO productCart = new CartDTO();
    	productCart.setId(id);
    	productCart.setP_number(p_number);
    	ProductCartService pcs = new ProductCartService();
    	int result = pcs.productCart(productCart);
    	if(result > 0) {
    		request.setAttribute("p_number", p_number);
    		request.setAttribute("page", page);
    		RequestDispatcher dispatch = request.getRequestDispatcher("ProductCartSuccess.jsp");
        	dispatch.forward(request, response);
    	}
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
