package review;

public class ReviewVo {
	private int reviewSeq;
	private String writer;
	private String content;
	private int grade;
	private int restSeq;
	
	public ReviewVo() {
		
	}

	public ReviewVo(int reviewSeq, String writer, String content, int grade, int restSeq) {
		super();
		this.reviewSeq = reviewSeq;
		this.writer = writer;
		this.content = content;
		this.grade = grade;
		this.restSeq = restSeq;
	}

	public int getReviewSeq() {
		return reviewSeq;
	}

	public void setReviewSeq(int reviewSeq) {
		this.reviewSeq = reviewSeq;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getRestSeq() {
		return restSeq;
	}

	public void setRestSeq(int restSeq) {
		this.restSeq = restSeq;
	}

	@Override
	public String toString() {
		return "ReviewVo [reviewSeq=" + reviewSeq + ", writer=" + writer + ", content=" + content + ", grade=" + grade
				+ ", restSeq=" + restSeq + "]";
	}
	
	
}