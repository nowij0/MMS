package handler.reservation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import member.MemberService;
import member.MemberVo;
import reservation.ReservationService;
import reservation.ReservationVo;
import restaurant.RestaurantService;
import restaurant.RestaurantVo;

public class ReservationAdd implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {

		if(request.getMethod().toLowerCase().equals("get")) {
			//매장 정보 출력
			int restSeq = Integer.parseInt(request.getParameter("restSeq"));
			RestaurantService service = new RestaurantService();
			RestaurantVo vo = service.getRestaurantByrestSeq(restSeq);
			request.setAttribute("vo", vo);
			
			//고객 정보 출력
			String id = request.getParameter("id");
			MemberService mService = new MemberService();
			MemberVo Mvo= mService.getMember(id);
			request.setAttribute("Mvo", Mvo);
			
			return "/reservation/add.jsp";
		}
		//예약 접수
		int people = Integer.parseInt(request.getParameter("people"));
		int restSeq = Integer.parseInt(request.getParameter("restSeq"));
		int memberSeq = Integer.parseInt(request.getParameter("memberSeq"));
		
		ReservationService service = new ReservationService();
		service.addReservation(new ReservationVo(0,people,null,restSeq,memberSeq,0));
		return "/restaurant/getall.do";
	}

}
