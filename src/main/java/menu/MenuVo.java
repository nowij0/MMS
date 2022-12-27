package menu;

public class MenuVo {
	int menuSeq;
	int price;
	String name;
	String imgPath;
	int restSeq;

	public MenuVo() {
	}

	public MenuVo(int menuSeq, int price, String name, String imgPath, int restSeq) {
		this.menuSeq = menuSeq;
		this.price = price;
		this.name = name;
		this.imgPath = imgPath;
		this.restSeq = restSeq;
	}

	public int getMenuSeq() {
		return menuSeq;
	}

	public void setMenuSeq(int menuSeq) {
		this.menuSeq = menuSeq;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public int getRestSeq() {
		return restSeq;
	}

	public void setRestSeq(int restSeq) {
		this.restSeq = restSeq;
	}

	@Override
	public String toString() {
		return "MenuVo [menuSeq=" + menuSeq + ", price=" + price + ", name=" + name + ", imgPath=" + imgPath
				+ ", restSeq=" + restSeq + "]";
	}
}
