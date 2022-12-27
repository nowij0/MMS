package review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReviewService {

	private ReviewDao dao;
	
	public ReviewService() {
		dao = new ReviewDao();
	}
	
	//번호로 게시물 조회
	public ReviewVo getbyreviewSeq(int reviewSeq) {
		return dao.select(reviewSeq);
	}
	
	//해당 식당의 전체 후기 목록 출력
	public ArrayList<ReviewVo> getAll(int restSeq){
		return dao.selectAll(restSeq);
	}
	
	public ArrayList<ReviewVo2> getByMemberList(){
		return dao.selectByMemberList();
	}
	
	//insert
	public void add(ReviewVo vo, int restSeq) {
		dao.insert(vo, restSeq);
	}
	
	//update
	public void edit(ReviewVo vo) {
		dao.update(vo);
	}
	
	//delete
	public void del(int reviewSeq) {
		dao.delete(reviewSeq);
	}
	
}//ReviewService