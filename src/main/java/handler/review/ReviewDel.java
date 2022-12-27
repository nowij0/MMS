package handler.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import review.ReviewService;

public class ReviewDel implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		int reviewSeq = Integer.parseInt(request.getParameter("reviewSeq"));
		
		ReviewService rService = new ReviewService();
		rService.del(reviewSeq);
		
		return "redirect:/review/list.jsp";
	}

}
