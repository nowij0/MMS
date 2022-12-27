package handler.member;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import handler.Handler;
import member.MemberService;
import member.MemberVo;

public class MemberEdit implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		if(request.getMethod().toLowerCase().equals("get")) {
			String id = request.getParameter("id");
			MemberService service = new MemberService();
			MemberVo vo = service.getMember(id);
			request.setAttribute("vo", vo);
			
			return "/member/edit.jsp";
		}
		

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		int memberSeq = Integer.parseInt(request.getParameter("memberSeq"));
		
		MemberService service = new MemberService();
		service.editMember(new MemberVo(memberSeq, id, name, pwd, tel, email, 0));
		
		return "redirect:/member/detail.do?id="+id;
	}

}
