package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import service.BoardModifyService;

@WebServlet("/boardModify")
public class BoardModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardModifyController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	int b_number = Integer.parseInt(request.getParameter("b_number"));
    	BoardDTO boardView = new BoardDTO();
    	BoardModifyService bms = new BoardModifyService();
    	boardView = bms.boardView(b_number);
    	request.setAttribute("boardView", boardView);
    	RequestDispatcher dispatch = request.getRequestDispatcher("BoardModify.jsp");
    	dispatch.forward(request, response);
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
