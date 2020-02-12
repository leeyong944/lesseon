package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import service.BoardModifyProcessService;

@WebServlet("/modifyProcess")
public class BoardModifyControllerProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardModifyControllerProcess() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	String title, contents;
    	int boardNum;
    	boardNum = Integer.parseInt(request.getParameter("boardNum"));
    	title = request.getParameter("title");
    	contents = request.getParameter("contents");
    	BoardDTO boardDTO = new BoardDTO();
    	boardDTO.setBoardnum(boardNum);
    	boardDTO.setTitle(title);
    	boardDTO.setContents(contents);
    	BoardModifyProcessService bmps = new BoardModifyProcessService();
    	int result = 0;
    	result = bmps.boardModify(boardDTO);
    	if(result > 0) {
    		response.sendRedirect("boardList");
    	}else {
    		response.sendRedirect("BoardMain.jsp");
    	}
    	
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
