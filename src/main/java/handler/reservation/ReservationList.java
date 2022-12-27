package handler.reservation;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import handler.Handler;
import reservation.ReservationCustomer;
import reservation.ReservationService;
import reservation.ReservationVo;

public class ReservationList implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		int memberSeq = (int)session.getAttribute("memberSeq");
		
		ReservationService service = new ReservationService();
		ArrayList<ReservationCustomer> value = service.getByMemberSeq(memberSeq);
		
		ArrayList<ReservationCustomer> list = new ArrayList<>();
		for(int i=0; i<value.size(); i++) {
			System.out.println(value.get(i));
			if(memberSeq == value.get(i).getMemberSeq()) {
				list.add(value.get(i));
			}
		}
		
		
		request.setAttribute("list", list);
		return "/reservation/list.jsp";
	}

}
