package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import service.BoardWriteService;

@WebServlet("/boardWrite")
public class BoardWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardWriteController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	String id, b_password, b_categori, b_contents;
    	id = request.getParameter("id");
    	b_password = request.getParameter("b_password");
    	b_categori = request.getParameter("b_categori");
    	b_contents = request.getParameter("b_contents");
    	BoardDTO boardDTO = new BoardDTO();
    	boardDTO.setId(id);
    	boardDTO.setB_password(b_password);
    	boardDTO.setB_categori(b_categori);
    	boardDTO.setB_contents(b_contents);
    	BoardWriteService bws = new BoardWriteService();
    	int result = bws.boardWrite(boardDTO);
    	if(result > 0) {
    		response.sendRedirect("BoardWriteSuccess.jsp");
    	}
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
