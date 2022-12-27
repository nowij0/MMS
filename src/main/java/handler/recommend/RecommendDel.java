package handler.recommend;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import recommend.RecommendService;
import recommend.RecommendVo;

public class RecommendDel implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		int recSeq = Integer.parseInt(request.getParameter("recSeq"));
		RecommendService service = new RecommendService();
		RecommendVo vo = service.getRecommend(recSeq);
		
		File f = new File("C:\\Users\\김경래\\Desktop\\255\\MyJAVA\\Basic\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\img\\"+vo.getImgFolder());
		f.delete();
		service.deleteRecommend(recSeq);
		return "redirect:/recommend/list.do";
	}

}
