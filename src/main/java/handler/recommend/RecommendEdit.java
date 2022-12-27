package handler.recommend;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import handler.Handler;
import recommend.RecommendService;
import recommend.RecommendVo;

public class RecommendEdit implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		if (request.getMethod().toLowerCase().equals("get")) {
			int recSeq = Integer.parseInt(request.getParameter("recSeq"));
			RecommendService service = new RecommendService();
			RecommendVo vo = service.getRecommend(recSeq);
			request.setAttribute("vo", vo);
			return "/recommend/edit.jsp";
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

			HttpSession session = request.getSession();
			int memberSeq = (int)session.getAttribute("memberSeq");
			
			// 폼파라메터 읽기
			int recSeq = Integer.parseInt(multipart.getParameter("recSeq"));
			String title = multipart.getParameter("title");
			String content = multipart.getParameter("content");
			
			// 업로드된 파일 객체
			File f = multipart.getFile("file");
			String ofname = multipart.getParameter("imgFolder");
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

			RecommendService service = new RecommendService();
			service.editRecommend(new RecommendVo(recSeq,"", title, null, content, fname, 0, memberSeq));
			return "redirect:/recommend/list.do";
		}
	

}
