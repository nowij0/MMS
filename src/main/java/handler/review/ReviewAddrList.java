package handler.review;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import restaurant.RestaurantService;
import restaurant.RestaurantVo;

public class ReviewAddrList implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		String address = request.getParameter("address");
		RestaurantService rService = new RestaurantService();
		ArrayList<RestaurantVo> list = rService.getRestaurantByaddr(address);
		
		request.setAttribute("list", list);
		
		return "";
	}

}
