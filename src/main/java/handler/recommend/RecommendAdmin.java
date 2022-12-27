package handler.recommend;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import recommend.RecommendService;
import recommend.RecommendVo;

public class RecommendAdmin implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {

		//관리자용 게시판 리스트 출력
		ArrayList<RecommendVo> list = (new RecommendService().getAll());
		request.setAttribute("list", list);
		return "/recommend/listByAdmin.jsp";
	
	}

}
