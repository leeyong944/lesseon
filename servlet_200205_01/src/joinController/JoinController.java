package joinController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import joinService.JoinService;

@WebServlet("/memberJoin")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public JoinController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	String id, password, name, birth, gender, email, email2;
    	id = request.getParameter("id");
    	password = request.getParameter("password");
    	name = request.getParameter("name");
    	birth = request.getParameter("birth");
    	gender = request.getParameter("gender");
    	email = request.getParameter("email");
    	email2 = request.getParameter("email2");
    	MemberDTO member = new MemberDTO();
    	member.setId(id);
    	member.setPassword(password);
    	member.setName(name);
    	member.setBirth(birth);
    	member.setGender(gender);
    	member.setEmail(email+email2);
  
    	JoinService joinService = new JoinService();
    	boolean joinResult;
    	joinResult = joinService.inputJoin(member);
    	if(joinResult == true) {
    		response.sendRedirect("JoinSuccess.jsp");
    	} else {
    		response.sendRedirect("JoinFail.jsp");
    	}
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
