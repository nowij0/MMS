package notice;

public class NoticeVo {
	private int noticeSeq;
	private String title;
	private String content;
	private int restSeq;
	
	public NoticeVo() {
		
	}
	
	
	public NoticeVo(int noticeSeq, String title, String content, int restSeq) {
		super();
		this.noticeSeq = noticeSeq;
		this.title = title;
		this.content = content;
		this.restSeq = restSeq;
	}


	public int getNoticeSeq() {
		return noticeSeq;
	}


	public void setNoticeSeq(int noticeSeq) {
		this.noticeSeq = noticeSeq;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public int getRestSeq() {
		return restSeq;
	}


	public void setRestSeq(int restSeq) {
		this.restSeq = restSeq;
	}


	@Override
	public String toString() {
		return "NoticeVo [noticeSeq=" + noticeSeq + ", title=" + title + ", content=" + content + ", restSeq=" + restSeq
				+ "]";
	}
	
	
}
