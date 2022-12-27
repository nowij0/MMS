package review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbconn.DBConnect;
import reservation.ReservationCustomer;

public class ReviewDao {

	private DBConnect dbconn;

	public ReviewDao() {
		dbconn = DBConnect.getInstance();
	}

	// select
	public ReviewVo select(int reviewSeq) {
		ReviewVo vo = null;
		ResultSet rs = null;

		String sql = "select * from review where reviewSeq = ?";
		Connection conn = dbconn.conn();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reviewSeq);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				vo = new ReviewVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return vo;
	}

	// 해당 식당의 전체 후기 목록 출력
	public ArrayList<ReviewVo> selectAll(int restSeq) {
		ArrayList<ReviewVo> list = new ArrayList<>();
		String sql = "select * from review where restSeq=?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, restSeq);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new ReviewVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}// selectAll

	
	public ArrayList<ReviewVo2> selectByMemberList() {
		ArrayList<ReviewVo2> list = new ArrayList<>();
		String sql = "select  name, content, grade, r.writer from review r join restaurant on r.restseq=restaurant.restseq";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new ReviewVo2(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
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
	}

	// insert
	public void insert(ReviewVo vo, int restSeq) {
		String sql = "insert into review values(reviewSeq.nextVal, ?, ?, ?, ?)";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getWriter());
			ps.setString(2, vo.getContent());
			ps.setInt(3, vo.getGrade());
			ps.setInt(4, restSeq);

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void update(ReviewVo vo) {
		String sql = "update review set content=? where writer=?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getContent());
			ps.setString(2, vo.getWriter());

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}// update

	public void delete(int reviewSeq) {
		String sql = "delete from review where reviewSeq = ?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reviewSeq);

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}// delete

}// ReviewDao