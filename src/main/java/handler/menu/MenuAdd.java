package handler.menu;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import handler.Handler;
import menu.MenuService;
import menu.MenuVo;

public class MenuAdd implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		if(request.getMethod().toLowerCase().equals("get")) {
			int restSeq = Integer.parseInt(request.getParameter("restSeq"));
			request.setAttribute("restSeq", restSeq);
			return "/menu/add.jsp";
		}
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
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
		int price = Integer.parseInt(multipart.getParameter("price"));
		int restSeq = Integer.parseInt(multipart.getParameter("restSeq"));
		String id = multipart.getParameter("id");
		//업로드된 파일 객체
		File f = multipart.getFile("file");
		String fname = f.getName();//파일명
		// 업로드된 파일명
		String imgPath = "/img/"+fname;
		
		MenuService service = new MenuService();
		service.addMenu(new MenuVo(0,price,name,imgPath,restSeq));
		
		return "redirect:/restaurant/customerDetail.do?restSeq="+restSeq+"&id="+id;
	}

}
