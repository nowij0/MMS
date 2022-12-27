package handler.recommend;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import recommend.RecommendService;
import recommend.RecommendVo;

public class RecommendGet implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String title = request.getParameter("title");
		System.out.println(title);
		ArrayList<RecommendVo> list = (new RecommendService().getByTitle(title));
		for(RecommendVo vo : list) {
			System.out.println(vo);
		}
		request.setAttribute("list", list);
		return "/recommend/list.jsp";
	
		
	}
}