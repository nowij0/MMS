package handler.recommend;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import recommend.RecommendService;
import recommend.RecommendVo;

public class RecommendDetail implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		int recSeq = Integer.parseInt(request.getParameter("recSeq"));
		RecommendService service = new RecommendService();
		RecommendVo vo = service.getRecommend(recSeq);
		request.setAttribute("vo", vo);
		service.cntUp(recSeq);
		return "/recommend/detail.jsp";
	}

}
