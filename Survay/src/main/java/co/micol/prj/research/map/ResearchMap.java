package co.micol.prj.research.map;

import java.util.List;

import org.apache.ibatis.annotations.Delete;

import org.apache.ibatis.annotations.Select;


import co.micol.prj.research.vo.ResearchVO;

public interface ResearchMap {
	List<ResearchVO> researchSelectList();
	
	@Select("select * from research where id = #{id}")
	ResearchVO researchSelect(ResearchVO vo);
		
	int resarchInsert(ResearchVO vo);
	int resarchUpdate(ResearchVO vo);
	@Delete("delete from research where id = #{id}")
	int resarchDelect(ResearchVO vo);	
}
