package notice;

import java.util.ArrayList;

public class NoticeService {
	private NoticeDao dao;
	
	public NoticeService() {
		dao = new NoticeDao();
	}
	
	//공지 추가
	public void addNotice(NoticeVo vo) {
		dao.insert(vo);
	}
	
	//공지 수정
	public void editNotice(NoticeVo vo) {
		dao.update(vo);
	}
	
	//공지 삭제
	public void deleteNotice(int noticeSeq) {
		dao.delete(noticeSeq);
	}
	
	//매장별 공지 출력
	public ArrayList<NoticeVo> selectByRestSeq(int restSeq){
		return dao.selectByRestSeq(restSeq);
	}
}
