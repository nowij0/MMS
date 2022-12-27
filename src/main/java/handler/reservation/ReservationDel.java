package handler.reservation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import reservation.ReservationService;
import reservation.ReservationVo;


public class ReservationDel implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
//		// TODO Auto-generated method stub
		int resSeq = Integer.parseInt(request.getParameter("resSeq"));
		ReservationService service = new ReservationService();
		ReservationVo vo = service.getMember(resSeq);
		
		int restSeq = vo.getRestSeq();
		
		service.delRestlist(resSeq);
		return "redirect:/reservation/restlist.do?restSeq="+restSeq;
	}

}
