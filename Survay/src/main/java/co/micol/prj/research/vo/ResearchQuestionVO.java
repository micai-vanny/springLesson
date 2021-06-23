package co.micol.prj.research.vo;

public class ResearchQuestionVO {
	private int qId;
	private int id;
	private int qOrder;
	private String qTitle;
	private String qSubtitle;
	private String qType;
	
	public ResearchQuestionVO() {
	}

	public int getqId() {
		return qId;
	}

	public void setqId(int qId) {
		this.qId = qId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getqOrder() {
		return qOrder;
	}

	public void setqOrder(int qOrder) {
		this.qOrder = qOrder;
	}

	public String getqTitle() {
		return qTitle;
	}

	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}

	public String getqSubtitle() {
		return qSubtitle;
	}

	public void setqSubtitle(String qSubtitle) {
		this.qSubtitle = qSubtitle;
	}

	public String getqType() {
		return qType;
	}

	public void setqType(String qType) {
		this.qType = qType;
	}
}
