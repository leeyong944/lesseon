package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberLoginService;

@WebServlet("/memberLogin")
public class MemberLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberLoginController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	HttpSession session = request.getSession();
    	String id, pw;
    	id = request.getParameter("m_id");
    	pw = request.getParameter("m_pw");
    	MemberLoginService mls = new MemberLoginService();
    	boolean login = mls.memberLogin(id,pw);
    	if(login) {
    		session.setAttribute("login", id);
    		RequestDispatcher dispatch = request.getRequestDispatcher("MainPage.jsp");
        	dispatch.forward(request, response);
    	}else {
    		response.sendRedirect("LoginFail.jsp");
    	}
    	
    	
    	
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
