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
import joinService.ModifyService;
import joinService.ViewService;

@WebServlet("/modify")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ModifyController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	HttpSession session = request.getSession();
    	String id = (String) session.getAttribute("login");
    	ModifyService modifyService = new ModifyService();
    	MemberDTO memberModify = modifyService.modify(id);
    	request.setAttribute("memberModify",memberModify);
    	RequestDispatcher dispatch = request.getRequestDispatcher("MemberModify.jsp");
    	dispatch.forward(request, response);
    	
//    	ViewService viewService = new ViewService();
    	
    	
//    	String id = request.getParameter("id");
//    	String password, name, email;
//    	password = request.getParameter("password");
//    	name = request.getParameter("name");
//    	email = request.getParameter("email");
//    	ModifyService modifyService = new ModifyService();
//    	boolean result;
//    	result = modifyService.modify(id, password, name, email);
//    	if(result) {
//    		response.sendRedirect("ModifySuccess.jsp");
//    	} else {
//    		response.sendRedirect("ModifyFail.jsp");
//    	}
    	
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
