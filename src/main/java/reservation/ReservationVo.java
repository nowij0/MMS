package reservation;

import java.sql.Date;

public class ReservationVo {
	private int resSeq;
	private int people;
	private Date resDate;
	private int restSeq;
	private int memberSeq;
	private int entrance;
	
	public ReservationVo() {}

	public ReservationVo(int resSeq, int people, Date resDate, int restSeq, int memberSeq, int entrance) {
		this.resSeq = resSeq;
		this.people = people;
		this.resDate = resDate;
		this.restSeq = restSeq;
		this.memberSeq = memberSeq;
		this.entrance = entrance;
	}

	public int getResSeq() {
		return resSeq;
	}

	public void setResSeq(int resSeq) {
		this.resSeq = resSeq;
	}

	public int getPeople() {
		return people;
	}

	public void setPeople(int people) {
		this.people = people;
	}

	public Date getResDate() {
		return resDate;
	}

	public void setResDate(Date resDate) {
		this.resDate = resDate;
	}

	public int getRestSeq() {
		return restSeq;
	}

	public void setRestSeq(int restSeq) {
		this.restSeq = restSeq;
	}

	public int getMemberSeq() {
		return memberSeq;
	}

	public void setMemberSeq(int memberSeq) {
		this.memberSeq = memberSeq;
	}

	public int getEntrance() {
		return entrance;
	}

	public void setEntrance(int entrance) {
		this.entrance = entrance;
	}

	@Override
	public String toString() {
		return "ReservationVo [resSeq=" + resSeq + ", people=" + people + ", resDate=" + resDate + ", restSeq="
				+ restSeq + ", memberSeq=" + memberSeq + ", entrance=" + entrance + "]";
	}

	
	
	
}
