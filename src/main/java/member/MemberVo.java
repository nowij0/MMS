package member;

public class MemberVo {
	private int memberSeq;
	private String id;
	private String name;
	private String pwd;
	private String tel;
	private String email;
	private int type;
	
	public MemberVo() {}
	
	public MemberVo(int memberSeq, String id, String name, String pwd, String tel, String email, int type) {
		this.memberSeq = memberSeq;
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.tel = tel;
		this.email = email;
		this.type = type;
	}

	public int getMemberSeq() {
		return memberSeq;
	}

	public void setMemberSeq(int memberSeq) {
		this.memberSeq = memberSeq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return "MemberVo [memberSeq=" + memberSeq + ", id=" + id + ", name=" + name + ", pwd=" + pwd + ", tel=" + tel
				+ ", email=" + email + ", type=" + type + "]";
	}
	
	
	
	
}