package handler.member;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import member.MemberService;
import member.MemberVo;

public class MemberAdd implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		if(request.getMethod().toLowerCase().equals("get")) {
			return "/member/addForm.jsp";
		}
		
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		// id, pwd, name, email 입력 폼 값 읽어오기
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd1");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		int type = Integer.parseInt(request.getParameter("type"));
		MemberVo vo = new MemberVo(0,id, name, pwd, tel, email, type);
		MemberService service = new MemberService();
		service.join(vo);// 회원가입 완료
		return "redirect:/restaurant/getall.do";	}

}
