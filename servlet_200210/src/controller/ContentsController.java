package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;

import java.util.*;
import service.ContentsService;

@WebServlet("/contents")
public class ContentsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ContentsController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	int boardNum;
    	boardNum = Integer.parseInt(request.getParameter("boardNum"));
    	ContentsService contentsService = new ContentsService();
    	contentsService.readCount(boardNum);
    	BoardDTO boardList = contentsService.view(boardNum);
    	request.setAttribute("contentsView", boardList);
    	RequestDispatcher dispatcher =
				request.getRequestDispatcher("ContentsView.jsp");
		dispatcher.forward(request, response);
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
