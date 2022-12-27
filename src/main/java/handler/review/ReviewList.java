package handler.review;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import menu.MenuService;
import menu.MenuVo;
import restaurant.RestaurantService;
import restaurant.RestaurantVo;
import review.ReviewService;
import review.ReviewVo;

public class ReviewList implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html; charset=UTF-8");
		
		int restSeq = Integer.parseInt(request.getParameter("restSeq"));
		String address = request.getParameter("address");
		
		System.out.println(restSeq + " :  " +  address);		
		//리뷰 목록
		ReviewService rService = new ReviewService();
		ArrayList<ReviewVo> reviewList = rService.getAll(restSeq);
		
		//식당 메뉴판
		MenuService mService = new MenuService();
		ArrayList<MenuVo> menuList = mService.getAll(restSeq);
		
		
		//식당 정보
		RestaurantService resService = new RestaurantService();
		RestaurantVo vo = resService.getRestaurantByrestSeq(restSeq);
		
		//검색한 식당 인근 식당 내역
		ArrayList<RestaurantVo> value = resService.getRestaurantByaddr(address);
		ArrayList<RestaurantVo> addrNearList = new ArrayList<RestaurantVo>();

		String name = vo.getName();
		for(RestaurantVo rvo : value) {
			if(!rvo.getName().equals(name)) {
				addrNearList.add(new RestaurantVo(rvo.getRestSeq(), rvo.getName(), rvo.getCategory(), rvo.getAddress(), rvo.getTel(), rvo.getRestOpenT(),
							rvo.getRestCloseT(), rvo.getRestIntro(), rvo.getImgPath(), rvo.getGradeAvg(), rvo.getResOpen(), rvo.getMemberSeq()));
			}
		}
		
		for(RestaurantVo test : addrNearList) {
			System.out.println(test);
		}
		
		
		request.setAttribute("menuList", menuList);
		request.setAttribute("vo", vo);
		request.setAttribute("reviewList", reviewList);
		request.setAttribute("addrNearList", addrNearList);
		
		return "/review/list.jsp";
	}

}
