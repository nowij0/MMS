package handler.reservation;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import reservation.ReservationRest;
import reservation.ReservationService;

public class ReservationRestList implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		int restSeq = Integer.parseInt(request.getParameter("restSeq"));
		ArrayList<ReservationRest> list = (new ReservationService().getByRestList(restSeq));
		request.setAttribute("list", list);
		return "/restaurant/reservRest.jsp";
	}

}
