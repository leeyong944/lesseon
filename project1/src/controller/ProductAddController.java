package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dto.ProductDTO;
import service.ProductAddService;

@WebServlet("/productAdd")
public class ProductAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductAddController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	int size = 10*1024*1024;
    	String savePath = "C:/Users/8/Desktop/Development/source/servlet/project1/WebContent/Resource/images";
    	
    	MultipartRequest multi = new MultipartRequest(request, savePath, size, "UTF-8", new DefaultFileRenamePolicy());
    	ProductDTO productDTO = new ProductDTO();
    	ProductAddService pas = new ProductAddService();
    	
    	productDTO.setP_name(multi.getParameter("p_name"));
    	productDTO.setP_categori(multi.getParameter("p_categori"));
    	productDTO.setP_desc(multi.getParameter("p_desc"));
    	productDTO.setP_price(Integer.parseInt(multi.getParameter("p_price")));
    	productDTO.setP_stock(Integer.parseInt(multi.getParameter("p_stock")));
    	productDTO.setP_file(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
    	
    	int result = pas.productAdd(productDTO);
    	if(result > 0) {
    		response.sendRedirect("ProductAddSuccess.jsp");
    	}
    	
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
