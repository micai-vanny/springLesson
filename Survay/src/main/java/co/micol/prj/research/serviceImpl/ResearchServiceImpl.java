package co.micol.prj.research.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.micol.prj.research.map.ResearchMap;
import co.micol.prj.research.service.ResearchServie;
import co.micol.prj.research.vo.ResearchVO;

@Repository("researchDao")
public class ResearchServiceImpl implements ResearchServie {
	@Autowired
	private ResearchMap map;
	
	@Override
	public List<ResearchVO> researchSelectList() {
		return map.researchSelectList();
	}

	@Override
	public ResearchVO researchSelect(ResearchVO vo) {
		return map.researchSelect(vo);
	}

	@Override
	public int resarchInsert(ResearchVO vo) {
		return map.resarchInsert(vo);
	}

	@Override
	public int resarchUpdate(ResearchVO vo) {
		return map.resarchUpdate(vo);
	}

	@Override
	public int resarchDelect(ResearchVO vo) {
		return map.resarchDelect(vo);
	}

}
