package handler.reservation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import reservation.ReservationService;

public class ReservationDel2 implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {

		int resSeq = Integer.parseInt(request.getParameter("resSeq"));
		ReservationService service = new ReservationService();
		service.delRestlist(resSeq);
		return "redirect:/reservation/list.do";
	}

}
