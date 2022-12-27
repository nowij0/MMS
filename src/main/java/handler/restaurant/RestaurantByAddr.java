package handler.restaurant;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import restaurant.RestaurantService;
import restaurant.RestaurantVo;

public class RestaurantByAddr implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String addr = request.getParameter("addr");
		RestaurantService service = new RestaurantService();
		ArrayList<RestaurantVo> list = service.getRestaurantByaddr(addr);
		request.setAttribute("list", list);
		
		return "/index.jsp";
	}

}
