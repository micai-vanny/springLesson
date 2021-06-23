package co.micol.prj.research.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.micol.prj.research.map.ResearchResponseMap;
import co.micol.prj.research.service.ResearchResponseService;
import co.micol.prj.research.vo.ResearchResponseVO;

@Repository("responseDao")
public class ResearchResponseServiceImpl implements ResearchResponseService {
	@Autowired
	ResearchResponseMap map;
	
	@Override
	public int researchResponseInsert(List<ResearchResponseVO> list) {
		return map.researchResponseInsert(list);
	}

}
