package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dto.BoardDTO;
import service.WritingService;

@WebServlet("/boardWriteFile")
public class BoardWriteFileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardWriteFileController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	int size = 10*1024*1024;
    	String savePath = "C:/Users/8/Desktop/Development/source/servlet/servlet_200210/WebContent/fileUpload";
    	
    	MultipartRequest multi = new MultipartRequest(request, savePath, size, "UTF-8", new DefaultFileRenamePolicy());
    	
    	BoardDTO boardDTO = new BoardDTO();
    	
    	boardDTO.setName(multi.getParameter("name"));
    	boardDTO.setTitle(multi.getParameter("title"));
    	boardDTO.setPassword(multi.getParameter("password"));
    	boardDTO.setContents(multi.getParameter("contents"));
    	boardDTO.setbFile(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
    	
    	WritingService writingService = new WritingService();
    	int writeResult = writingService.boardWriteFile(boardDTO);
    	
    	if(writeResult > 0) {
    		response.sendRedirect("boardList");
    	} else {
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
