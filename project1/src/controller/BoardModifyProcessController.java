package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardModifyProcessService;

@WebServlet("/boardModifyProcess")
public class BoardModifyProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardModifyProcessController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	int b_number = Integer.parseInt(request.getParameter("b_number"));
    	String b_categori, b_contents;
    	b_categori = request.getParameter("b_categori");
    	b_contents = request.getParameter("b_contents");
    	BoardModifyProcessService bmps = new BoardModifyProcessService();
    	int result = bmps.boardModify(b_number, b_categori, b_contents);
    	if(result > 0) {
    		response.sendRedirect("BoardModifySuccess.jsp");
    	}
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
