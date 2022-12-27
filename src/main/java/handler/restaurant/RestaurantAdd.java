package handler.restaurant;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import handler.Handler;
import restaurant.RestaurantService;
import restaurant.RestaurantVo;

public class RestaurantAdd implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		if (request.getMethod().toLowerCase().equals("get")) {
			return "/restaurant/add.jsp";
		}
		
		//post 일때
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String path = "C:\\Users\\김경래\\Desktop\\255\\MyJAVA\\Basic\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\img\\";

		// 업로드 파일의 최대 크기
		int size = 100 * 1024 * 1024; // 100M

		// 업로드에 사용할 MultipartRequest 객체 생성
		MultipartRequest multipart= null;
		try {
			multipart = new MultipartRequest(request, path, size, "UTF-8", new DefaultFileRenamePolicy());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 폼파라메터 읽기
		String name = multipart.getParameter("name");
		String category = multipart.getParameter("category");
		String address = multipart.getParameter("address");
		String tel = multipart.getParameter("tel");
		String restOpenT = multipart.getParameter("restOpenT");
		String restCloseT = multipart.getParameter("restCloseT");
		String restIntro = multipart.getParameter("restIntro");
		//업로드된 파일 객체
		File f = multipart.getFile("file");
		String fname = f.getName();//파일명
		// 업로드된 파일명
		String imgPath = "/img/"+fname;
		
		//회원번호...ㅎ.어찌받아오지..ㅎ....ㅎ..
		HttpSession session = request.getSession();
		int memberSeq = (int)session.getAttribute("memberSeq");
		System.out.println(memberSeq);
		RestaurantService service = new RestaurantService();
		service.addRestaurant(new RestaurantVo(0, name, category, address, tel, restOpenT, restCloseT,
				restIntro, imgPath, 0 ,0, memberSeq));
		                           //평균별점, 예약온오프, 멤버회원seq
		
		return "redirect:/restaurant/getall.do";
	}
		
}
