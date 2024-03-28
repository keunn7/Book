package book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTemplate {
	//database 연결, 연결 해제 담당 
	
	//1. 데이터베이스 연결 
	public static Connection getConnection() {
		Connection conn = null; 
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url= "jdbc:mariadb://127.0.0.1:3306/guest_book";
			String user = "root";
			String pw = "1234";
			conn = DriverManager.getConnection(url, user, pw);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
		
		//2. 데이터베이스 연결 해제
		public static void close(Connection conn) {
			try {
				if(conn != null && conn.isClosed() == false) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		public static void close (PreparedStatement pstmt) {
			try {
				if(pstmt != null && pstmt.isClosed() == false) {
					pstmt.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		public static void close (ResultSet rs) {
			try {
				if(rs != null && rs.isClosed() == false) {
					rs.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
