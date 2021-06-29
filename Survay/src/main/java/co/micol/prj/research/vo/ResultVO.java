package co.micol.prj.research.vo;

import java.util.List;

public class ResultVO {
	private List<ResearchResponseVO> result;
	private int responseId;
	
	public ResultVO() {
		// TODO Auto-generated constructor stub
	}

	public int getResponseId() {
		return responseId;
	}

	public void setResponseId(int responseId) {
		this.responseId = responseId;
	}


	public List<ResearchResponseVO> getResult() {
		return result;
	}

	public void setResult(List<ResearchResponseVO> result) {
		this.result = result;
	}
}
