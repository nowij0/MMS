package handler.restaurant;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import member.MemberService;
import member.MemberVo;
import menu.MenuService;
import menu.MenuVo;
import notice.NoticeService;
import notice.NoticeVo;
import reservation.ReservationService;
import restaurant.RestaurantService;
import restaurant.RestaurantVo;

public class RestaurantCustomerDetail implements Handler {

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
		
		//해당 매장에 해당하는 메뉴 출력
		MenuService mService = new MenuService();
		ArrayList<MenuVo> meList = mService.getAll(restSeq);
		request.setAttribute("meList", meList);
		
		//해당 매장에 해당하는 예약 수 출력
		ReservationService rService = new ReservationService();
		int line = rService.getByLine(restSeq);
		request.setAttribute("line", line);
		
		 //접속한 아이디 받아서 접속 멤버객체 출력
	      String id = request.getParameter("id");
	      MemberService memService = new MemberService();
	      MemberVo mVo = memService.getMember(id);
	      request.setAttribute("mVo", mVo);

		
		return "/restaurant/customerDetail.jsp";
	}

}
