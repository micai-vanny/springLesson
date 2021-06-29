package co.micol.prj.member.map;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import co.micol.prj.member.vo.MemberVO;

public interface MemberMap {
	List<MemberVO> memberSelectList();
	
	@Select("select * from member where email = #{email}")
	MemberVO memberSelect(MemberVO vo);
	
	@Insert("insert into member(email, name, password) values(#{email}, #{name}, #{password})")
	int memberInsert(MemberVO vo);
	int memberUpdate(MemberVO vo);

	@Delete("update member set state = 'D' where email = #{email}")
	int memberDelete(MemberVO vo);
}
