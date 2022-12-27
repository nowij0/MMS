package handler.member;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import handler.Handler;
import member.MemberService;
import member.MemberVo;

public class IdCheck implements Handler {

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

		String id = request.getParameter("id");
		MemberService service = new MemberService();
		MemberVo vo = service.getMember(id);
		boolean idflag = false;
		String msg = "사용 불가능한 아이디";

		if (vo == null) {
			msg = "사용 가능한 아이디";
			idflag = true;
		}

		JSONObject obj = new JSONObject();
		obj.put("idflag", idflag);
		obj.put("msg", msg);
		String txt = obj.toJSONString();
		return "responsebody/" + txt;
	}

}
