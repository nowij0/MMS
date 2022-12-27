package handler.member;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import member.MemberService;
import member.MemberVo;

public class MemberList implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		MemberService service = new MemberService();
		ArrayList<MemberVo> list = service.getAll();
		request.setAttribute("list", list);
		return "/member/listAdmin.jsp";
	}

}
