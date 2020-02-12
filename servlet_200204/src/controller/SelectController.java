package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.SelectService;
import java.util.*;

/**
 * Servlet implementation class SelectController
 */
@WebServlet("/selectDB")
public class SelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectController() {
        super();
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	/*
    	 * 처리 과정
    	 * 	서비스 클래스의 selectDB 메소드 호출 ->
    	 * 	DB 접속하고 -> DAO의 selectDB 메소드 호출 ->
    	 * 	DAO의 selectDB 메소드는 DB의 TEST 테이블의 모든 내용 조회->
    	 * 	조회 내용을 서비스 클래스로 리턴 ->
    	 * 	서비스 클래스는 컨트롤러로 조회내용을 리턴->
    	 * 	컨트롤러에서 SelectResult.jsp로 데이터를 가지고 이동
    	 */
    	List<String> select = new ArrayList<String>();
    	SelectService SelectService = new SelectService();
    	select = SelectService.selectDB();
    	// select 를 request영역의 parameter에 담아서 SelectResult.jsp로 이동
    	request.setAttribute("reqData1", select);
    	RequestDispatcher dispatch = request.getRequestDispatcher("SelectResult.jsp");
    	dispatch.forward(request, response);
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
