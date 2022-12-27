package handler.member;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import member.MemberService;
import member.MemberVo;



public class MemberDetail implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String id = request.getParameter("id");
		if(request.getMethod().toLowerCase().equals("get")) {
			MemberService service = new MemberService();
			MemberVo vo = service.getMember(id);
			//검색 결과를 request에 담는다
			System.out.println(vo);
			request.setAttribute("vo", vo);
		}
		return "/member/detail.jsp";

	}

}
