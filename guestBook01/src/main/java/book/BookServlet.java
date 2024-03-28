package book;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/book")
public class BookServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 방명록 목록 페이지로 이동 
		// 1. 방명록 목록 조회하기
		Connection conn = null; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String url = "jdbc:mariadb://127.0.0.1:3306/guest_book";
			String user = "root";
			String pw = "1234";
			// 아래 드라이버의 도움을 받겠다 
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pw);		
			String sql = "SELECT * FROM content_list";
			//쿼리의 도움을 받는다
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
			//데이터 한줄씩 조회-> map에 넣어줌 
			while(rs.next()) {
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("writer", rs.getString("g_writer"));
				map.put("content", rs.getString("g_content"));
				map.put("date", rs.getDate("g_reg_date"));
				//list 기차에 map 손님이 탔다
				list.add(map);
			}
			// 2. 목록 정보 전달하기 
			req.setAttribute("books", list);
			// 3. 목록 페이지로 이동하기 
			RequestDispatcher rd = req.getRequestDispatcher("views/book.jsp");
			rd.forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		super.doGet(req, res);
	}

	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//1. book.jsp로부터 정보 가져오기 (사옹자가 적은 한글을 처리)	
		req.setCharacterEncoding("UTF-8"); 
			
			//
			String writer = req.getParameter("writer");
			String content = req.getParameter("content");
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				//2. 데이터베이스에 정보 추가
				String url = "jdbc:mariadb://127.0.0.1:3306/guest_book";
				String user = "root";
				String pw = "1234";
				Class.forName("org.mariadb.jdbc.Driver");
				conn = DriverManager.getConnection(url, user, pw);
				
				String sql = "INSERT INTO content_list(g_writer,g_content,g_reg_date) VALUES(?,?,NOW())";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, writer); //1번 writer는 첫번째 물음표
				pstmt.setString(2, content);//2번 content는 두번째 물음표
				
				rs = pstmt.executeQuery();
				//3. 목록화면으로 전환
				res.sendRedirect("/book");
				
			}catch(Exception e) {
				e.printStackTrace();
			}		
		}
}
