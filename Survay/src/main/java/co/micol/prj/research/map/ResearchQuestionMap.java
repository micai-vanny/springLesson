package co.micol.prj.research.map;

import java.util.List;

import co.micol.prj.research.vo.ResearchQuestionVO;

public interface ResearchQuestionMap {
	List<ResearchQuestionVO> questionList(ResearchQuestionVO vo);
}
