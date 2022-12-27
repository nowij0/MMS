package handler.restaurant;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import restaurant.RestaurantService;
import restaurant.RestaurantVo;

public class RestByMemberSeq implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		int memberSeq = Integer.parseInt(request.getParameter("memberSeq"));
	    RestaurantService service = new RestaurantService();
		ArrayList<RestaurantVo> list = service.getByMemberSeq(memberSeq);
		request.setAttribute("list", list);
		return "/restaurant/listByMemberSeq.jsp";
	}

}
