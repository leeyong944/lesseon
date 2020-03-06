package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import dto.OrderDTO;
import dto.ProductDTO;
import service.ProductBuyService;

@WebServlet("/productBuy")
public class ProductBuyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductBuyController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	String id;
    	int quantity;
    	id = request.getParameter("id");
    	quantity = Integer.parseInt(request.getParameter("c_quantity"));
    	OrderDTO orderDTO = new OrderDTO();
    	orderDTO.setId(id);
    	orderDTO.setO_quantity(quantity);
    	ProductBuyService pbs = new ProductBuyService();
    	MemberDTO memberDTO = new MemberDTO();
    	memberDTO = pbs.memberInformation(id);
    	
    	request.setAttribute("memberDTO", memberDTO);
    	request.setAttribute("orderDTO", orderDTO);
    	RequestDispatcher dispatch = request.getRequestDispatcher("ProductBuy.jsp");
    	dispatch.forward(request, response);
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


}
