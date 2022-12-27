package handler.restaurant;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import notice.NoticeService;
import notice.NoticeVo;
import restaurant.RestaurantService;
import restaurant.RestaurantVo;

public class RestaurantDetail implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		//해당 식당 정보 출력(식당 번호받아서)
		int restSeq = Integer.parseInt(request.getParameter("restSeq"));
		RestaurantService service = new RestaurantService();
		RestaurantVo vo = service.getRestaurantByrestSeq(restSeq);
		request.setAttribute("vo", vo);
		
		//해당 매장에 해당하는 공지 출력
		NoticeService nService = new NoticeService();
		ArrayList<NoticeVo> noList = nService.selectByRestSeq(restSeq);
		request.setAttribute("noList", noList);
		
		return "/restaurant/detail.jsp";
	}

}
