package book.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import book.model.BookService;
import book.model.BookVo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/book")
public class BookController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1. 목록 정보 추출 (Dao)
		//2. 추출된 정보 파싱 (우리가 원하는 대로 재조립)(Service)
		//3. 정보를 화면으로 전달 (Controller)
		List<BookVo> resultList =new ArrayList<BookVo>();
		resultList = new BookService().selectList();
		req.setAttribute("resultList",resultList);
		RequestDispatcher rd = req.getRequestDispatcher("views/book.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//1. 사용자가 입력한 정보 가져오기(인코딩) - controller
		req.setCharacterEncoding("UTF-8");
		String writer = req.getParameter("writer");
		String content = req.getParameter("content");
		//시간은 마리아 DB에서 받음 
		//2. 데이터베이스에 추가 -
		// (1)연결(service)
		new BookService().insertOne(writer, content);
		// (2)등록(dao)
		//3. 목록화면으로 전환 
		res.sendRedirect("/book");
	}
	
	
	

	

}
