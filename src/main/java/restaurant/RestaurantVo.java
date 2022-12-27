package restaurant;

public class RestaurantVo {
	
	private int restSeq;
	private String name;
	private String category;
	private String address;
	private String tel;
	private String restOpenT;
	private String restCloseT;
	private String restIntro;
	private String imgPath;
	private int gradeAvg;
	private int resOpen;
	private int memberSeq;
	
	public RestaurantVo(){};
	public RestaurantVo(int restSeq, String name, String category, String address, String tel, String restOpenT,
			String restCloseT, String restIntro, String imgPath, int gradeAvg, int resOpen, int memberSeq) {
		super();
		this.restSeq = restSeq;
		this.name = name;
		this.category = category;
		this.address = address;
		this.tel = tel;
		this.restOpenT = restOpenT;
		this.restCloseT = restCloseT;
		this.restIntro = restIntro;
		this.imgPath = imgPath;
		this.gradeAvg = gradeAvg;
		this.resOpen = resOpen;
		this.memberSeq = memberSeq;
	}
	
	
	public int getRestSeq() {
		return restSeq;
	}
	public void setRestSeq(int restSeq) {
		this.restSeq = restSeq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getRestOpenT() {
		return restOpenT;
	}
	public void setRestOpenT(String restOpenT) {
		this.restOpenT = restOpenT;
	}
	public String getRestCloseT() {
		return restCloseT;
	}
	public void setRestCloseT(String restCloseT) {
		this.restCloseT = restCloseT;
	}
	public String getRestIntro() {
		return restIntro;
	}
	public void setRestIntro(String restIntro) {
		this.restIntro = restIntro;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public int getGradeAvg() {
		return gradeAvg;
	}
	public void setGradeAvg(int gradeAvg) {
		this.gradeAvg = gradeAvg;
	}
	public int getResOpen() {
		return resOpen;
	}
	public void setResOpen(int resOpen) {
		this.resOpen = resOpen;
	}
	public int getMemberSeq() {
		return memberSeq;
	}
	public void setMemberSeq(int memberSeq) {
		this.memberSeq = memberSeq;
	}
	
	
	
	@Override
	public String toString() {
		return "RestaurantVo [restSeq=" + restSeq + ", name=" + name + ", category=" + category + ", address=" + address
				+ ", tel=" + tel + ", restOpenT=" + restOpenT + ", restCloseT=" + restCloseT + ", restIntro="
				+ restIntro + ", imgPath=" + imgPath + ", gradeAvg=" + gradeAvg + ", resOpen=" + resOpen
				+ ", memberSeq=" + memberSeq + "]";
	}
	
}//RestaurantVo