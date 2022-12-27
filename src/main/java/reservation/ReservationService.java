package reservation;

import java.util.ArrayList;

public class ReservationService {
	ReservationDao dao;
	
	public ReservationService() {
		dao = new ReservationDao();
	}
	//예약정보 추가
	public void addReservation(ReservationVo vo) {
		dao.insert(vo);
	}
	
	public ReservationVo getMember(int resSeq) {
		return dao.select(resSeq);
	}
	//전체출력
	public ArrayList<ReservationVo> getAll() {
		return dao.selectAll();
	}
	//고객별 예약리스트
	public ArrayList<ReservationCustomer> getByMemberSeq(int memberSeq){
		return dao.selectByMemberSeq(memberSeq);
	}

	//가게별 줄서기 인원 구하기
	public int getByLine(int restSeq) {
		return dao.selectByLine(restSeq);
	}
	//가게별 예약리스트
	public ArrayList<ReservationRest> getByRestList(int restSeq){
		return dao.selectByResList(restSeq);
				}
	//가게별 에약리스트 삭제
	public void delRestlist(int resSeq) {
		dao.deleteResList(resSeq);
	}
	//입장완료 상태변경
	public void editEntrance(int resSeq) {
		dao.updateEntrance(resSeq);
	}
}	
