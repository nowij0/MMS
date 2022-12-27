package menu;

import java.util.ArrayList;

public class MenuService {
	
	private MenuDao dao;
	
	public MenuService() {
		dao = new MenuDao();
	}
	//메뉴추가
	public void addMenu(MenuVo vo) {
		dao.insert(vo);
	}
	
	//select
	//식당에 해당하는 메뉴 정보 출력
	public ArrayList<MenuVo> getAll(int restSeq){
		return dao.selectMenu(restSeq);
	}

}//MenuService
