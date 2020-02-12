package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import service.WritingService;

@WebServlet("/writing")
public class WritingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WritingController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	String title, name, contents, password;
    	title = request.getParameter("title");
    	name = request.getParameter("name");
    	contents = request.getParameter("contents");
    	password = request.getParameter("password");
    	BoardDTO boardDTO = new BoardDTO();
    	boardDTO.setTitle(title);
    	boardDTO.setName(name);
    	boardDTO.setContents(contents);
    	boardDTO.setPassword(password);
    	int result = 0;
    	WritingService writingService = new WritingService();
    	result = writingService.writing(boardDTO);
    	if(result > 0) {
    		response.sendRedirect("boardList");
    	} else {
    		response.sendRedirect("Board.jsp");
    	}
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
