package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import service.MemberModifyService;

@WebServlet("/memberModify")
public class MemberModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberModifyController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	String id = request.getParameter("id");
    	MemberModifyService mms = new MemberModifyService();
    	MemberDTO memberView = new MemberDTO();
    	memberView = mms.memberView(id);
    	request.setAttribute("memberView", memberView);
    	RequestDispatcher dispatch = request.getRequestDispatcher("MemberModify.jsp");
    	dispatch.forward(request, response);
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


}
