package recommend;

import java.sql.Date;

public class RecommendVo {
	private int recSeq;
	private String writer;
	private String title;
	private Date wDate;
	private String content;
	private String imgFolder;
	private int cnt;
	private int memberSeq;
	
	public RecommendVo() {
		
	}

	public RecommendVo(int recSeq, String writer, String title, Date wDate, String content, String imgFolder, int cnt,
			int memberSeq) {
		super();
		this.recSeq = recSeq;
		this.writer = writer;
		this.title = title;
		this.wDate = wDate;
		this.content = content;
		this.imgFolder = imgFolder;
		this.cnt = cnt;
		this.memberSeq = memberSeq;
	}

	public int getRecSeq() {
		return recSeq;
	}

	public void setRecSeq(int recSeq) {
		this.recSeq = recSeq;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getWDate() {
		return wDate;
	}

	public void setW_date(Date wDate) {
		this.wDate = wDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImgFolder() {
		return imgFolder;
	}

	public void setImgFolder(String imgFolder) {
		this.imgFolder = imgFolder;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getMemberSeq() {
		return memberSeq;
	}

	public void setMemberSeq(int memberSeq) {
		this.memberSeq = memberSeq;
	}

	@Override
	public String toString() {
		return "RecommendVo [recSeq=" + recSeq + ", writer=" + writer + ", title=" + title + ", wDate=" + wDate
				+ ", content=" + content + ", imgFolder=" + imgFolder + ", cnt=" + cnt + ", memberSeq=" + memberSeq
				+ "]";
	}

	
	
}
	
	