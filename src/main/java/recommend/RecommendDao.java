package recommend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbconn.DBConnect;
/*	recSeq		//게시글번호
	writer		//작성자
	title		//제목
	w_date      //작성일
	content		//게시물내용
	imgFolder	//이미지경로
	cnt			//조회수
	memberSeq 	//회원번호
*/

public class RecommendDao {
	private DBConnect dbconn;

	public RecommendDao() {
		dbconn = DBConnect.getInstance();
	}

	// 추가(작성) - 조회수는?로 처리? 0으로 디폴트값.?
	public void insert(RecommendVo vo) {
		String sql = "insert into recommend values(recSeq.nextval,?,?,sysdate,?,?,0,?)";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getImgFolder());
			pstmt.setInt(5, vo.getMemberSeq());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 객체1set - 글시퀀스번호를 파람으로
	public RecommendVo select(int recSeq) {
		RecommendVo vo = null;
		ResultSet rs = null;

		String sql = "select * from recommend where recSeq=?";
		Connection conn = dbconn.conn();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, recSeq);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				vo = new RecommendVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8));
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
		return vo;
	}

	// 제목으로 글검색
	public ArrayList<RecommendVo> selectByTitle(String title) {
		ResultSet rs = null;
		ArrayList<RecommendVo> list = new ArrayList<RecommendVo>();
		String sql = "select * from recommend where title like ? order by recSeq desc";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + title + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new RecommendVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8)));
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

	// 수정(추천게시판 글번호로 받아서)
	public void update(RecommendVo vo) {
		String sql = "update Recommend set content=?, imgFolder=? where recseq=?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getContent());
			pstmt.setString(2, vo.getImgFolder());
			pstmt.setInt(3, vo.getRecSeq());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 삭제(추천게시판 글번호로 받아서)
	public void delete(int recSeq) {
		String sql = "delete from recommend where recseq=?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, recSeq);
			pstmt.executeUpdate();
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

	// 전체목록 출력 -> 뷰페이지에서는 회원번호 출력안해야함(getint(8) 제외)
	public ArrayList<RecommendVo> selectAll() {
		ResultSet rs = null;
		ArrayList<RecommendVo> list = new ArrayList<>();
		String sql = "select * from recommend order by recSeq desc";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new RecommendVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8)));
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
	}

	//조회수 업데이트
	public void updateCnt(int recSeq) {
		String sql = "update Recommend set cnt = (cnt +1) where recseq=?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, recSeq);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
