package reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbconn.DBConnect;

public class ReservationDao {
	private DBConnect dbconn;
	
	public ReservationDao() {
		dbconn = DBConnect.getInstance();
	}
	
	//예약정보 입력
	public void insert(ReservationVo vo) {
		String sql = "insert into reservation values (resSeq.nextval,?,sysdate,?,?,2)";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getPeople());
			pstmt.setInt(2, vo.getRestSeq());
			pstmt.setInt(3, vo.getMemberSeq());
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
	//예약리스트 출력
	public ArrayList<ReservationVo> selectAll(){
		ArrayList<ReservationVo> list = new ArrayList<>();
		String sql = "select * from reservation order by resseq desc";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new ReservationVo(rs.getInt(1),rs.getInt(2),rs.getDate(3),rs.getInt(4),
						rs.getInt(5),rs.getInt(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	//에약 resSeq로 선택
	public ReservationVo select(int resSeq) {
		ReservationVo vo = null;
		String sql = "select * from reservation where resseq=?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, resSeq);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new ReservationVo(rs.getInt(1),rs.getInt(2),rs.getDate(3),rs.getInt(4),
						rs.getInt(5),rs.getInt(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return vo;
	}

	//memberseq로 리스트 출력
	public ArrayList<ReservationCustomer> selectByMemberSeq(int memberSeq){
		ArrayList<ReservationCustomer> list = new ArrayList<>();
		String sql = "select resSeq, name, people, resDate, entrance from reservation join restaurant on reservation.restseq=restaurant.restseq AND restaurant.memberseq=?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberSeq);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new ReservationCustomer(rs.getInt(1), rs.getInt(2) ,rs.getString(3),rs.getInt(4),rs.getDate(5),rs.getInt(6)));
			} 
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	//restseq로 리스트 출력
	public ArrayList<ReservationVo> selectByRestSeq(int restSeq){
		ArrayList<ReservationVo> list = new ArrayList<>();
		String sql = "select * from reservation where restSeq=? order by resseq desc";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, restSeq);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new ReservationVo(rs.getInt(1),rs.getInt(2),rs.getDate(3),rs.getInt(4),
						rs.getInt(5),rs.getInt(6)));
			} 
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	//줄서기 -명 구하기
	public int selectByLine(int restSeq) {
		int line = 0;
		String sql = "select count(*) from reservation where restSeq=? and entrance=2";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, restSeq);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				line = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return line;
	}
	
	//가게용 예약 내역 확인
		public ArrayList<ReservationRest> selectByResList(int restSeq){
			ArrayList<ReservationRest> list = new ArrayList<>();
			String sql = "select resseq, sysdate, tel, people, entrance from reservation join member on reservation.memberseq=member.memberseq AND reservation.restseq=? order by resseq";
			Connection conn = dbconn.conn();
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, restSeq);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					list.add(new ReservationRest(rs.getInt(1),rs.getDate(2),rs.getString(3),rs.getInt(4),rs.getInt(5)));
				} 
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return list;
		}
		
		//예약번호 받아 삭제
		public void deleteResList(int resSeq) {
			String sql = "delete from reservation where resseq=?";
			Connection conn = dbconn.conn();
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, resSeq);
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
	//입장상태 바꾸기
	public void updateEntrance(int resSeq) {
		String sql ="update reservation set entrance=1 where resseq=?";
		Connection conn = dbconn.conn();
				try {
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, resSeq);
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
}
