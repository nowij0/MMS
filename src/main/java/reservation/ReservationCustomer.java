package reservation;

import java.sql.Date;

public class ReservationCustomer {
	private int resSeq;
	private int memberSeq;
	private String name;
	private int people;
	private Date resDate;
	private int entrance;

	public ReservationCustomer() {
	}

	public ReservationCustomer(int resSeq, int memberSeq, String name, int people, Date resDate, int entrance) {
		super();
		this.resSeq = resSeq;
		this.memberSeq = memberSeq;
		this.name = name;
		this.people = people;
		this.resDate = resDate;
		this.entrance = entrance;
	}

	public int getResSeq() {
		return resSeq;
	}

	public void setResSeq(int resSeq) {
		this.resSeq = resSeq;
	}

	public int getMemberSeq() {
		return memberSeq;
	}

	public void setMemberSeq(int memberSeq) {
		this.memberSeq = memberSeq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getEntrance() {
		return entrance;
	}

	public void setEntrance(int entrance) {
		this.entrance = entrance;
	}

	@Override
	public String toString() {
		return "ReservationCustomer [resSeq=" + resSeq + ", memberSeq=" + memberSeq + ", name=" + name + ", people="
				+ people + ", resDate=" + resDate + ", entrance=" + entrance + "]";
	}
	
}
