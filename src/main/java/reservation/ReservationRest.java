package reservation;

import java.sql.Date;

public class ReservationRest {
	private int resSeq;
	private Date resDate;
	private String tel;
	private int people;
	private int entrance;
	
	public ReservationRest() {}
	public ReservationRest(int resSeq, Date resDate, String tel, int people, int entrance) {
		this.resSeq = resSeq;
		this.resDate = resDate;
		this.tel = tel;
		this.people = people;
		this.entrance = entrance;
	}
	
	public Date getResDate() {
		return resDate;
	}
	public void setResDate(Date resDate) {
		this.resDate = resDate;
	}
	public int getResSeq() {
		return resSeq;
	}
	public void setResSeq(int resSeq) {
		this.resSeq = resSeq;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getPeople() {
		return people;
	}
	public void setPeople(int people) {
		this.people = people;
	}
	public int getEntrance() {
		return entrance;
	}
	public void setEntrance(int entrance) {
		this.entrance = entrance;
	}
	@Override
	public String toString() {
		return "ReservationRest [resSeq=" + resSeq + ", resDate=" + resDate + ", tel=" + tel + ", people=" + people
				+ ", entrance=" + entrance + "]";
	}
	
	
}
