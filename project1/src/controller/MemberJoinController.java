package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import service.MemberJoinService;

@WebServlet("/memberJoin")
public class MemberJoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberJoinController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	MemberDTO memberDTO = new MemberDTO();
    	String id, pw, name, address1, address2, address3, address4, address5, birth, tel, gender, email;
    	id = request.getParameter("m_id");
    	pw = request.getParameter("m_pw");
    	name = request.getParameter("m_name");
    	address1 = request.getParameter("m_address1");
    	address2 = request.getParameter("m_address2");
    	address3 = request.getParameter("m_address3");
    	address4 = request.getParameter("m_address4");
    	address5 = request.getParameter("m_address5");
    	birth = request.getParameter("m_birth");
    	tel = request.getParameter("m_tel");
    	gender = request.getParameter("m_gender");
    	email = request.getParameter("m_email");
    	
    	memberDTO.setId(id);
    	memberDTO.setPw(pw);
    	memberDTO.setName(name);
    	memberDTO.setAddress1(address1);
    	memberDTO.setAddress2(address2);
    	memberDTO.setAddress3(address3);
    	memberDTO.setAddress4(address4);
    	memberDTO.setAddress5(address5);
    	memberDTO.setBirth(birth);
    	memberDTO.setTel(tel);
    	memberDTO.setGender(gender);
    	memberDTO.setEmail(email);
    	
    	MemberJoinService mjs = new MemberJoinService();
    	int result = mjs.memberJoin(memberDTO);
    	if(result > 0) {
    		response.sendRedirect("JoinSuccess.jsp");
    	}else {
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
