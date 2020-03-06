package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ProductDTO;
import service.ProductViewService;

@WebServlet("/productView")
public class ProductViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	int p_number = Integer.parseInt(request.getParameter("p_number"));
    	int page = Integer.parseInt(request.getParameter("page"));
    	ProductViewService pvs = new ProductViewService();
    	ProductDTO productView = pvs.productView(p_number);
    	request.setAttribute("productView", productView);
    	request.setAttribute("page", page);
    	RequestDispatcher dispatch = request.getRequestDispatcher("ProductView.jsp");
    	dispatch.forward(request, response);
    	
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
