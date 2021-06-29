package co.micol.prj.member.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.micol.prj.member.sevice.MemberService;
import co.micol.prj.member.vo.MemberVO;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberDao;
	
	@RequestMapping("memberRegister.do")// ┌>MemberVO vo, 로 안 쓰면 HttpServletRequest req를 쓰던가 @RequestParam 쓰던가 해야됨
	public String memberRegister(@ModelAttribute("memberVO") MemberVO vo, @RequestParam("confirmPassword") String confirmPassword, Model model) {
								//@RequestParam으로 받을시
								//@RequestParam("email") String email, @RequestParam("name") String name, 
								//@RequestParam("password") String password... 이런 식으로 쓰야됨
//		MemberVO vo = new MemberVO();	// HttpServletRequest나 @RequestParam으로 받을라면 이런 개 똥꼬쇼를 해야된다 이겁니다.
//		vo.setEmail(req.getParameter("email"));
//		vo.setName(req.getParameter("name"));
//		vo.setPassword(req.getParameter("password"));

		System.out.println(confirmPassword);
		
		int n = memberDao.memberInsert(vo);
		if(n != 0) {
			model.addAttribute("message", "회원등록이 완료되었습니다.");
		}else {
			model.addAttribute("message", "회원등록에 실패하였습니다.");
		}
		model.addAttribute("vo", vo);
//		return "member/memberRegister";
		return "member/memberInputForm";
	}
	
	@RequestMapping("member/memberInputForm")
	public String memberInputForm(MemberVO vo, Model model) {
		model.addAttribute("memberVO", vo);
		return "member/memberInputForm";
	}
}
