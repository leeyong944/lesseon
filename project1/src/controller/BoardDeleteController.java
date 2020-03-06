package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardDeleteService;

@WebServlet("/boardDelete")
public class BoardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardDeleteController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	int b_number = Integer.parseInt(request.getParameter("b_number"));
    	BoardDeleteService bds = new BoardDeleteService();
    	int result = bds.boardDelete(b_number);
    	if(result > 0) {
    		response.sendRedirect("BoardDeleteSuccess.jsp");
    	}
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}