package menu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbconn.DBConnect;

public class MenuDao {
	private DBConnect dbconn;
	
	public MenuDao() {
		dbconn = DBConnect.getInstance();
	}
	//메뉴추가
	public void insert(MenuVo vo) {
		String sql = "insert into menu values (menuseq.nextval,?,?,?,?)";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getPrice());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getImgPath());
			pstmt.setInt(4, vo.getRestSeq());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//식당에 해당하는 메뉴 정보 출력
	public ArrayList<MenuVo> selectMenu(int restSeq){
		ArrayList<MenuVo> list = new ArrayList<>();
		
		String sql = "select * from menu where restSeq=?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, restSeq);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new MenuVo(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}//select

}//MenuDao
