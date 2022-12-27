package handler.restaurant;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import restaurant.RestaurantService;
import restaurant.RestaurantVo;

public class RestaurantList implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		RestaurantService service = new RestaurantService();
		ArrayList<RestaurantVo> list = service.getAll();
		request.setAttribute("list", list);
		return "/index.jsp";
	}

}
