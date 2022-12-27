package handler.reservation;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import handler.Handler;
import reservation.ReservationRest;
import reservation.ReservationService;
import reservation.ReservationVo;

public class ReservationEditEntrance implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		ReservationService service = new ReservationService();
		int resSeq = Integer.parseInt(request.getParameter("resSeq"));
		System.out.println(resSeq);
     	service.editEntrance(resSeq);
		ReservationVo vo = service.getMember(resSeq);
		int restSeq = vo.getRestSeq();
		
		ArrayList<ReservationRest> list = service.getByRestList(restSeq);
		System.out.println(list);
		JSONArray arr = new JSONArray();
		for(ReservationRest rvo : list) {
        JSONObject obj = new JSONObject();
         obj.put("resSeq", rvo.getResSeq());
  		 obj.put("entrance", rvo.getEntrance());
         arr.add(obj);
      }
		
		String txt = arr.toJSONString();
		System.out.println(txt);
		return "responsebody/"+ txt;
	}

}