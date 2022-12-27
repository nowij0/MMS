package handler.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import review.ReviewService;
import review.ReviewVo;

public class ReviewUpdate implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		if(request.getMethod().toLowerCase().equals("get")) {
			return "/review/list.jsp";
		}
		
		int reviewSeq = Integer.parseInt(request.getParameter("reviewSeq"));
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		int grade = Integer.parseInt(request.getParameter("grade"));
		int restSeq = Integer.parseInt(request.getParameter("restSeq"));
		
		ReviewService rService = new ReviewService();
		rService.edit(new ReviewVo(reviewSeq, writer, content, grade, restSeq));
		
		return "";
	}

}//UpdateHandler
