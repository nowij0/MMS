package handler.restaurant;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import handler.Handler;
import restaurant.RestaurantService;
import restaurant.RestaurantVo;

public class RestaurantDel implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int restSeq = Integer.parseInt(request.getParameter("restSeq"));
		HttpSession session = request.getSession();
		
		int memberSeq = (int)session.getAttribute("memberSeq");
		
		RestaurantService service = new RestaurantService();
		RestaurantVo vo = service.getRestaurantByrestSeq(restSeq);
		File f = new File("C:\\Users\\김경래\\Desktop\\255\\MyJAVA\\Basic\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\img\\"+vo.getImgPath());
		f.delete();
		service.deleteRestaurant(restSeq);
		return "redirect:/restaurant/listByMemberSeq.do?memberSeq="+memberSeq;
	}

}
