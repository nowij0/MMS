package restaurant;

import java.util.ArrayList;

import recommend.RecommendVo;

public class RestaurantService {
	private RestaurantDao dao;

	public RestaurantService() {
		dao = new RestaurantDao();
	}

	// 식당 추가
	public void addRestaurant(RestaurantVo vo) {
		dao.insert(vo);
	}

	// 식당 수정
	public void editRestaurant(RestaurantVo vo) {
		dao.update(vo);
	}

	// 식당 삭제
	public void deleteRestaurant(int restSeq) {
		dao.delete(restSeq);
	}

	
	
	// 식당정보 검색(식당 번호 받아서)
	public RestaurantVo getRestaurantByrestSeq(int restSeq) {
		return dao.select(restSeq);
	}

	// 주소검색을 통한 식당 정보
	public ArrayList<RestaurantVo> getRestaurantByaddr(String address) {
		return dao.selectAddr(address);
	}
	
	// 주소검색을 통한 식당 정보 (검색한 식당은 안나오도록)
	public ArrayList<RestaurantVo> getRestaurantByaddr(String address, int restSeq) {
		return dao.selectAddr(address, restSeq);
	}

	// 식당정보 전체 출력
	public ArrayList<RestaurantVo> getAll() {
		return dao.selectAll();
	}

	// 가게명 검색
	public ArrayList<RestaurantVo> getRestaurantByname(String name) {
		return dao.selectByname(name);
	}
	
	
	//식당여러개 출력(회원번호통해서)
	public ArrayList<RestaurantVo> getByMemberSeq(int memberSeq) {
		return dao.selectByMemberSeq(memberSeq);
	}
}
