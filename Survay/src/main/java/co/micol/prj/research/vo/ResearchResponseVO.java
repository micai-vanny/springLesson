package co.micol.prj.research.vo;

public class ResearchResponseVO {
//	private int responseId;
	private int qId;
	private int qOrder;
	private String qResult;
	
	public ResearchResponseVO() {
	}

//	public int getResponseId() {
//		return responseId;
//	}
//
//	public void setResponseId(int responseId) {
//		this.responseId = responseId;
//	}

	public int getqId() {
		return qId;
	}

	public void setqId(int qId) {
		this.qId = qId;
	}

	public int getqOrder() {
		return qOrder;
	}

	public void setqOrder(int qOrder) {
		this.qOrder = qOrder;
	}

	public String getqResult() {
		return qResult;
	}

	public void setqResult(String qResult) {
		this.qResult = qResult;
	}
}
