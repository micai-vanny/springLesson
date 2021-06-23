package co.micol.prj.research.vo;

import java.sql.Date;

public class ResearchVO {
	private int id;
	private String title;
	private String writer;
	private Date sdate;
	private Date edate;
	private String gubun;
	private String course;
	private int rnumber;
	
	public ResearchVO() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getSdate() {
		return sdate;
	}

	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}

	public Date getEdate() {
		return edate;
	}

	public void setEdate(Date edate) {
		this.edate = edate;
	}

	public String getGubun() {
		return gubun;
	}

	public void setGubun(String gubun) {
		this.gubun = gubun;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getRnumber() {
		return rnumber;
	}

	public void setRnumber(int rnumber) {
		this.rnumber = rnumber;
	}
	
	
}
