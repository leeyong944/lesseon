package joinController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.MemberDTO;
import joinService.LoginService;

import java.util.*;

@WebServlet("/memberLogin")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	HttpSession session = request.getSession();
    	LoginService loginService = new LoginService();
    	String id, password;
    	id = request.getParameter("id");
    	password = request.getParameter("password");
    	boolean login;
    	login = loginService.memberLogin(id,password);
    	session.setAttribute("login", id);
    	if(login) {
    		RequestDispatcher dispatch = request.getRequestDispatcher("LoginSuccess.jsp");
        	dispatch.forward(request, response);
    	}
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
