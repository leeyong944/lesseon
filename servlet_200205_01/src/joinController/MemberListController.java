package joinController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import joinService.MemberListService;

import java.util.*;

@WebServlet("/memberList")
public class MemberListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberListController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	List<MemberDTO> memberList = new ArrayList<MemberDTO>();
    	MemberListService listService = new MemberListService();
    	memberList = listService.listLookUp();  	
    	request.setAttribute("memberList", memberList);
    	RequestDispatcher dispatch = request.getRequestDispatcher("MemberList.jsp");
    	dispatch.forward(request, response);
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


}
