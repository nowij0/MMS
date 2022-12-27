package handler.recommend;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import recommend.RecommendService;
import recommend.RecommendVo;

public class RecommendList implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {

		ArrayList<RecommendVo> list = (new RecommendService().getAll());
		request.setAttribute("list", list);
		return "/recommend/list.jsp";
	
		
	}



}
