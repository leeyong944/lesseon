package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import service.BoardViewService;

@WebServlet("/boardView")
public class BoardViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardViewController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	int b_number = Integer.parseInt(request.getParameter("b_number"));
    	BoardDTO boardView = new BoardDTO();
    	BoardViewService bvs = new BoardViewService();
    	boardView = bvs.boardView(b_number);
    	request.setAttribute("boardView", boardView);
    	RequestDispatcher dispatch = request.getRequestDispatcher("BoardView.jsp");
    	dispatch.forward(request, response);
    	
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
