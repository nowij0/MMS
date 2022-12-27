package handler.review;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import handler.Handler;
import review.ReviewService;
import review.ReviewVo;

public class ReviewAdd implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		int grade = Integer.parseInt(request.getParameter("grade"));
		int restSeq = Integer.parseInt(request.getParameter("restSeq")); 

		ReviewService rService = new ReviewService();
		rService.add(new ReviewVo(0, writer, content, grade, restSeq), restSeq);
		
		ArrayList<ReviewVo> reviewList = rService.getAll(restSeq);
		JSONArray arr = new JSONArray();
		for(ReviewVo rVo :reviewList) {
			JSONObject object = new JSONObject();
			object.put("grade", rVo.getGrade());
			object.put("writer", rVo.getWriter());
			object.put("content", rVo.getContent());
			object.put("reviewSeq", rVo.getReviewSeq());
			
			arr.add(object);
		}
		
		String txt = arr.toJSONString();
		
		return "responsebody/"+txt;
	}

}//AddHandler
