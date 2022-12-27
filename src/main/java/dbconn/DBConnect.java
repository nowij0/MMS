package dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//싱글톤 
//DB 연결 하는 클래스
public class DBConnect {

	private static DBConnect dbconn = new DBConnect();	
	private String url = "jdbc:oracle:thin:@localhost:1521/xe";
	
	private DBConnect() {}
	
	//생성자가 private니까 getInstance()로 돌려준다
	public static DBConnect getInstance() {
		return dbconn;
	}
	
	public Connection conn() {
		try {
			//Class.forName() : 드라이버 로드
			Class.forName("oracle.jdbc.OracleDriver");
			
			//세션 수립(DB에 연결) url 계정 서버에 연결해라, 계정명/비밀번호
			return DriverManager.getConnection(url, "project" , "1234");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}//DBConnect
