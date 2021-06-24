package co.micol.prj.research.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.micol.prj.research.service.ResearchQuestionService;
import co.micol.prj.research.service.ResearchResponseService;
import co.micol.prj.research.service.ResearchServie;
import co.micol.prj.research.vo.ResearchQuestionVO;
import co.micol.prj.research.vo.ResearchResponseVO;
import co.micol.prj.research.vo.ResearchVO;

@Controller
public class ResearchController {
	@Autowired
	@Qualifier("researchDao")
	private ResearchServie dao;
	
	@Autowired
	private ResearchQuestionService questionDao;
	
	@Autowired
	private ResearchResponseService responseDao;
	
	@RequestMapping("researchList.do")
	public String researchList(Model model) {
		model.addAttribute("lists",dao.researchSelectList());
		return "research/researchList";
	}
	
	@PostMapping("researchSelect.do")
	public String researchSelect(ResearchVO vo, Model model) {
		model.addAttribute("vo", dao.researchSelect(vo));
		return "research/researchSelect";
	}
	
	@RequestMapping("researchAppend.do")
	public String researchAppend(ResearchVO vo, Model model) {
		ResearchQuestionVO rvo = new ResearchQuestionVO();
		rvo.setId(vo.getId());
		
		model.addAttribute("researchTitle", dao.researchSelect(vo));
		model.addAttribute("qlists",questionDao.questionList(rvo));
		return "research/researchAppend";
	}
	
	@RequestMapping("researchAppendwrite.do")
	public String researchAppendwrite(HttpServletRequest req, Model model) {
		List<ResearchResponseVO> list = new ArrayList<ResearchResponseVO>();
		ResearchResponseVO vo = new ResearchResponseVO();
		// 넘겨받을 값 id, qId, qOrder, qResult
		// int id, qId, qOrder
		// qResult[1] 동일한 객체로
		// 몇개가 넘어오는지 모르니까 while로 처리
		// vo 초기화 => 넘어온 객체를 vo에 담아주고 리스트 add
		String[] qOrder = req.getParameterValues("qOrder");
		String[] qResult;
		for(int i= 1; i <= qOrder.length; i++) {
			vo = new ResearchResponseVO();
			qResult = req.getParameterValues("qResult["+i+"]");
			String result = "";
			StringBuilder sb = new StringBuilder();
			for(String str : qResult) {
//				System.out.println(i+str);
				sb.append(str);
				if(sb.length() > 0){
					sb.append(',');
			    }
//				sb.deleteCharAt(0);
			    str = sb.toString();
//				str = String.join(",",str);
				result += str;
			    System.out.println(result);
			}
			vo.setqOrder(Integer.parseInt(qOrder[i-1]));
			vo.setqId(Integer.parseInt(qOrder[i-1]));
			vo.setqResult(result);
			list.add(vo);
		}
		int n = responseDao.researchResponseInsert(list);
		
		String message;
		
		if(n > 0)
			message="설문이 정상 등록 되었습니다.";
		else
			message="설문 등록에 실패하였습니다.";
		model.addAttribute("str", message);
		return "research/researchAppendwrite";
//			return null;
	}
}
