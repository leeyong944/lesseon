package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dto.PagingDTO;
import dto.ProductDTO;
import service.ProductListService;

import java.util.*;

@WebServlet("/productList")
public class ProductListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductListController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	ProductListService pls = new ProductListService();
    	int page = 1; //처음 기본값 1페이지 시작
    	int limit = 9; //한페이지에 몇개의 글을 보여줄것인지
    	String search = null;
    	int listCount = 0;
    	List<ProductDTO> productList = null;
    	String searchflag = null;
    	//page 파라미터 값 검사
    	if(request.getParameter("page") != null) {
    		page = Integer.parseInt(request.getParameter("page"));
    	}
    	
    	// 전체 글 갯수를 가져오기 위한 ListService 클래스의 메소드 호출
    	if(request.getParameter("searchflag") == null) {
    		listCount = pls.listCount();
    	} else {
    		searchflag = request.getParameter("searchflag");
    		search = request.getParameter("search");
    		listCount = pls.searchCount(search);
    	}
    	
    	
    	//limit 값을 걸어놓은 만큼 범위에 해당하는 글만 가져오는 방법
    	int startRow = (page - 1) * limit + 1;
    	int endRow = page * limit;
    	
    	// 한페이지에 3개씩 보여줄때 1페이지에 보여줘야 하는 글번호(RN 기준)
    	// 시작 글은 1번 마지막글은 3번
    	if(request.getParameter("searchflag") == null) {
    		productList = pls.productList(startRow, endRow);
    	} else {
    		productList = pls.productSearchList(search, startRow, endRow);
    	}
    	
    	// 페이지 계산을 위한 부분
    	// 최대로 필용한 페이지 갯수 계산
    	int maxPage = (int) ((double) listCount / limit + 0.9);
    	// 현재 페이지에 보여줄 시작 페이지 번호(1, 11, 21, 31 ~~~~~~)
    	int startPage = (((int) ((double) page / 10 + 0.9)) -1) * 10 + 1;
    	// 현재 페이지에 보여줄 끝 페이지 번호 (10, 20, 30, 40 ~~~~)
    	int endPage = startPage + 10 - 1 ;
    	
    	if(endPage > maxPage) {
    		endPage = maxPage;
    	}
    	
    	PagingDTO paging = new PagingDTO();
    	
    	paging.setPage(page);
    	paging.setStartPage(startPage);
    	paging.setEndPage(endPage);
    	paging.setMaxPage(maxPage);
    	paging.setListCount(listCount);
    	paging.setStartRow(startRow);
    	paging.setEndRow(endRow);
    	
    	request.setAttribute("searchflag", searchflag);
    	request.setAttribute("search", search);
    	request.setAttribute("paging", paging);
    	
    	request.setAttribute("productList", productList);
    	
    	RequestDispatcher dispatcher =
    			request.getRequestDispatcher("ProductList.jsp");
    	dispatcher.forward(request, response);
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
}
