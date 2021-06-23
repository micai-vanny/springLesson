package co.micol.prj.research.service;

import java.util.List;

import co.micol.prj.research.vo.ResearchVO;

public interface ResearchServie {
	List<ResearchVO> researchSelectList();
	ResearchVO researchSelect(ResearchVO vo);
	int resarchInsert(ResearchVO vo);
	int resarchUpdate(ResearchVO vo);
	int resarchDelect(ResearchVO vo);
}
