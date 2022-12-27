package handler.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import handler.Handler;

public class MemberLogout implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		// 현재 세션을 무효화 => 새 세션 생성 => 로그아웃
		session.invalidate();
		return "/restaurant/getall.do";
	}

}
