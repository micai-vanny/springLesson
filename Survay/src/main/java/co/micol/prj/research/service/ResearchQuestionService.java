package co.micol.prj.research.service;

import java.util.List;

import co.micol.prj.research.vo.ResearchQuestionVO;

public interface ResearchQuestionService {
	List<ResearchQuestionVO> questionList(ResearchQuestionVO vo);
}
