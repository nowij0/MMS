package handler.notice;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import notice.NoticeService;
import notice.NoticeVo;

public class NoticeAdd implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		if(request.getMethod().toLowerCase().equals("get")) {
			int restSeq = Integer.parseInt(request.getParameter("restSeq"));
			request.setAttribute("restSeq", restSeq);
			return "/notice/add.jsp";
		}
		
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int restSeq = Integer.parseInt(request.getParameter("restSeq"));
		String id = request.getParameter("id");
		
		NoticeService service = new NoticeService();
		service.addNotice(new NoticeVo(0,title,content,restSeq));
		return "redirect:/restaurant/customerDetail.do?restSeq="+restSeq+"&id="+id;
	}

}
