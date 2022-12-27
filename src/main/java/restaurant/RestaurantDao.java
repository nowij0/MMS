package restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbconn.DBConnect;

/*int restSeq; 식당번호1
String name; 식당이름2
String category; 식당종류3
String address; 식당주소4
String tel; 연락처5
String restOpenT; 오픈시간6
String restCloseT; 닫는시간7
String restIntro; 소개글8
String imgPath; 식당사진경로9
int gradeAvg; 별점평균10
int resOpen; 예약가능여부11
int memberSeq; 회원번호12*/

public class RestaurantDao {
	private DBConnect dbconn;

	public RestaurantDao() {
		dbconn = DBConnect.getInstance();
	}

	// 식당 정보 추가
	public void insert(RestaurantVo vo) {
		String sql = "insert into restaurant values(restseq.nextval,?,?,?,?,?,?,?,?,?,?,?)";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getCategory());
			pstmt.setString(3, vo.getAddress());
			pstmt.setString(4, vo.getTel());
			pstmt.setString(5, vo.getRestOpenT());
			pstmt.setString(6, vo.getRestCloseT());
			pstmt.setString(7, vo.getRestIntro());
			pstmt.setString(8, vo.getImgPath());
			pstmt.setInt(9, vo.getGradeAvg());
			pstmt.setInt(10, vo.getResOpen());
			pstmt.setInt(11, vo.getMemberSeq());
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

	// 식당 정보 수정
	public void update(RestaurantVo vo) {
		String sql = "update restaurant set name =?, category =?, address=?, tel =?, restopent =?, restcloset =?, "
				+ "restintro =?, imgpath =?, resopen =? where restSeq=?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getCategory());
			pstmt.setString(3, vo.getAddress());
			pstmt.setString(4, vo.getTel());
			pstmt.setString(5, vo.getRestOpenT());
			pstmt.setString(6, vo.getRestCloseT());
			pstmt.setString(7, vo.getRestIntro());
			pstmt.setString(8, vo.getImgPath());
			pstmt.setInt(9, vo.getResOpen());
			pstmt.setInt(10, vo.getRestSeq());
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

	// 식당 정보 삭제(식당 번호 받아서)
	public void delete(int restSeq) {
		String sql = "delete from restaurant where restseq =?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, restSeq);
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

	// 로그인세션에서 memberSeq를 받아서 운영하는식당리스트받아오기
	public ArrayList<RestaurantVo> selectByMemberSeq(int memberSeq) {
		ArrayList<RestaurantVo> list = new ArrayList<>();
		String sql = "select * from restaurant where memberSeq=?";

		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberSeq);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new RestaurantVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getInt(10), rs.getInt(11), rs.getInt(12)));
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

	

	// 식당 정보 출력(식당 번호 받아서)
	public RestaurantVo select(int restSeq) {

		RestaurantVo vo = null;
		String sql = "select * from restaurant where restseq=?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, restSeq);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new RestaurantVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10),
						rs.getInt(11), rs.getInt(12));
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

	// 식당 가게명으로 검색
	public ArrayList<RestaurantVo> selectByname(String name) {
		ArrayList<RestaurantVo> list = new ArrayList<>();

		String sql = "select * from restaurant where name like ?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + name + "%");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new RestaurantVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getInt(10), rs.getInt(11), rs.getInt(12)));
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
	// 검색한 주소 기반, 주변 식당 정보 출력
		public ArrayList<RestaurantVo> selectAddr(String address) {
			ArrayList<RestaurantVo> list = new ArrayList<>();

			String sql = "select * from restaurant where address like ?";
			Connection conn = dbconn.conn();
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + address + "%");
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					list.add(new RestaurantVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getInt(10), rs.getInt(11), rs.getInt(12)));
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
		}// selectAddr

	// 검색한 주소 기반, 주변 식당 정보 출력 (본인 가게 안 나오게)
	public ArrayList<RestaurantVo> selectAddr(String address, int restSeq) {
		ArrayList<RestaurantVo> list = new ArrayList<>();

		String sql = "select * from restaurant where address like ? and restSeq != ?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + address + "%");
			pstmt.setInt(2, restSeq);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new RestaurantVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getInt(10), rs.getInt(11), rs.getInt(12)));
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
	}// selectAddr

	// 식당 정보 전체 출력
	public ArrayList<RestaurantVo> selectAll() {
		ResultSet rs = null;
		ArrayList<RestaurantVo> list = new ArrayList<>();
		String sql = "select * from restaurant order by restSeq desc";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new RestaurantVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getInt(10), rs.getInt(11), rs.getInt(12)));
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

}