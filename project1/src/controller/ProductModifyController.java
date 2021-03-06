package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ProductDTO;
import service.ProductModifyService;

@WebServlet("/productModify")
public class ProductModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductModifyController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	int p_number = Integer.parseInt(request.getParameter("p_number"));
    	ProductDTO productModify = new ProductDTO();
    	ProductModifyService pms = new ProductModifyService();
    	productModify = pms.productModify(p_number);
    	request.setAttribute("productModify", productModify);
    	RequestDispatcher dispatch = request.getRequestDispatcher("ProductModify.jsp");
    	dispatch.forward(request, response);
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
