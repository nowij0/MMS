package member;

import java.util.ArrayList;

public class MemberService {
	private MemberDao dao;

	public MemberService() {
		dao = new MemberDao();
	}

	// 회원가입
	public void join(MemberVo vo) {
		dao.insert(vo);
	}

	// 1set 출력(회원번호로 받아서)
	public MemberVo getMember(String id) {
		return dao.select(id);
	}
	
	//수정
	public void editMember(MemberVo vo) {
		dao.update(vo);
	}
	
	//삭제
	public void delMember(String id) {
		dao.delete(id);
	}

	//전체출력
	public ArrayList<MemberVo> getAll() {
		return dao.selectAll();
	}
}