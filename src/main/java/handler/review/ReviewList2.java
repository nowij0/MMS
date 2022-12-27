package handler.review;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import handler.Handler;
import review.ReviewService;
import review.ReviewVo2;

public class ReviewList2 implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("loginId");
		
		System.out.println("로그인한 id: " + id);
		
		ReviewService service = new ReviewService();
		ArrayList<ReviewVo2> value = service.getByMemberList();
		
		for(ReviewVo2 test : value) {
			System.out.println("리뷰목록: " + test);
		}

		//회원번호에 해당하는 값들을 뽑아서 저장할 배열
		ArrayList<ReviewVo2> list = new ArrayList<>();
	
			for(int i=0; i<value.size(); i++) {
				System.out.println(i+"번째 ID: " + value.get(i).getWriter());
				if(id.equals(value.get(i).getWriter())) {
					list.add(new ReviewVo2(value.get(i).getName(), value.get(i).getContent(), value.get(i).getGrade(), value.get(i).getWriter() ));
				}
			}
		
		request.setAttribute("list", list);
		return "/review/list2.jsp";
	}

}
