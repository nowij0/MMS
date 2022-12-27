package recommend;

import java.util.ArrayList;

public class RecommendService {
	private RecommendDao dao;

	public RecommendService() {
		dao = new RecommendDao();
	}

	// 글작성
	public void addRecommend(RecommendVo vo) {
		dao.insert(vo);
	}

	// 1set
	public RecommendVo getRecommend(int secSeq) {
		return dao.select(secSeq);
	}

	// 제목으로 검색
	public ArrayList<RecommendVo> getByTitle(String title) {
		return dao.selectByTitle(title);
	}

	// 수정(추천게시판 글번호로 받아서)
	public void editRecommend(RecommendVo vo) {
		dao.update(vo);
	}

	// 삭제(추천게시판 글번호로 받아서)
	public void deleteRecommend(int recSeq) {
		dao.delete(recSeq);
	}

	// 전체목록 출력 -> 뷰페이지에서는 회원번호 출력안해야함(getint(7) 제외)
	public ArrayList<RecommendVo> getAll() {
		return dao.selectAll();
	}
	
	// 조회수 증가
	public void cntUp(int recSeq) {
		dao.updateCnt(recSeq);
	}
		
}

