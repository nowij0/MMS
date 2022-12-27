package review;

public class ReviewVo2 {
	private String name;
	private String content;
	private int grade;
	private String writer;

	public ReviewVo2() {
	}
	public ReviewVo2(String name, String content, int grade, String writer) {
		super();
		this.name = name;
		this.content = content;
		this.grade = grade;
		this.writer = writer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	@Override
	public String toString() {
		return "ReviewVo2 [name=" + name + ", content=" + content + ", grade=" + grade + ", writer=" + writer + "]";
	}
}
