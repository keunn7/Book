package book.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static book.JDBCTemplate.close;


public class BookDao {
	
	//데이터베이스에서 목록 조회
	public List<BookVo>selectList(Connection conn) {
		//1. connection
		//2. preparedStatement
		//3. ResultSet
		//4.List<Map<String,Object>>
		
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		List<BookVo> resultList = new ArrayList<BookVo>();
		try {		
			String sql = "SELECT * FROM content_list";
			//쿼리의 도움을 받는다
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BookVo vo = new BookVo();
				vo.setWriter(rs.getString("g_writer"));
				vo.setContent(rs.getString("g_content"));
				vo.setReg_date(rs.getDate("g_reg_date"));
				resultList.add(vo);
			}
		  
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return resultList;
	} 
	public void insertOne(Connection conn, String writer, String content) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "INSERT INTO content_list(g_writer,g_content,g_reg_date) VALUES(?,?,NOW())";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer);
			pstmt.setString(2, content);
			rs = pstmt.executeQuery();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
	}
}