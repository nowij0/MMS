package handler.restaurant;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import handler.Handler;
import restaurant.RestaurantService;
import restaurant.RestaurantVo;

public class RestaurantEdit implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		if(request.getMethod().toLowerCase().equals("get")) {
			int restSeq = Integer.parseInt(request.getParameter("restSeq"));
			RestaurantService service = new RestaurantService();
			RestaurantVo vo = service.getRestaurantByrestSeq(restSeq);
			request.setAttribute("vo", vo);
			return "/restaurant/detail.jsp";
		}
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
		MultipartRequest multipart = null;
		try {
			multipart = new MultipartRequest(request, path, size, "UTF-8", new DefaultFileRenamePolicy());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 폼파라메터 읽기
		int restSeq = Integer.parseInt(multipart.getParameter("restSeq"));
		System.out.println(restSeq);
		String name = multipart.getParameter("name");
		System.out.println(name);
		String category = multipart.getParameter("category");
		String address = multipart.getParameter("address");
		String tel = multipart.getParameter("tel");
		String restOpenT = multipart.getParameter("restOpenT");
		String restCloseT = multipart.getParameter("restCloseT");
		String restIntro = multipart.getParameter("restIntro");
		int resOpen = Integer.parseInt(multipart.getParameter("resOpen"));
		int gradeAvg = Integer.parseInt(multipart.getParameter("gradeAvg"));
		int memberSeq = Integer.parseInt(multipart.getParameter("memberSeq"));
		
		// 업로드된 파일 객체
		File f = multipart.getFile("file");
		String ofname = multipart.getParameter("imgPath");
		String fname = "";
		if (f == null) {
			// 원본파일명
			fname = ofname;
		} else {
			// 업로드된 파일명
			fname = "/img/"+f.getName();
			File delFile = new File(path + ofname);
			delFile.delete();
		}

		RestaurantService service = new RestaurantService();
		service.editRestaurant(new RestaurantVo(restSeq, name, category, address, tel, restOpenT, restCloseT,
				restIntro, fname, gradeAvg ,resOpen, memberSeq));
		return "redirect:/restaurant/listByMemberSeq.do?memberSeq="+memberSeq;
	}
}


