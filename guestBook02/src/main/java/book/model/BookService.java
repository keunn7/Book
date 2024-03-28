package book.model;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import static book.JDBCTemplate.getConnection;
import static book.JDBCTemplate.close;

public class BookService {
	
	//Controller와 Dao 사이
	//중간자 역할
	public List<BookVo>selectList(){
		Connection conn = getConnection();
		List<BookVo> resultList = new BookDao().selectList(conn);
		close(conn);
		return resultList;
	}
	public void insertOne(String writer, String content) {
		Connection conn = getConnection();
		new BookDao().insertOne(conn, writer, content);
		close(conn);
	}
}
