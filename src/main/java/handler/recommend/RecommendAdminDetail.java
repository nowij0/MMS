package handler.recommend;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import recommend.RecommendService;
import recommend.RecommendVo;

public class RecommendAdminDetail implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
	//관리자용 게시판 상세 출력 	
		int recSeq = Integer.parseInt(request.getParameter("recSeq"));
		RecommendService service = new RecommendService();
		RecommendVo vo = service.getRecommend(recSeq);
		request.setAttribute("vo", vo);
		
		return "/recommend/detailByAdmin.jsp";
		
	}

}
