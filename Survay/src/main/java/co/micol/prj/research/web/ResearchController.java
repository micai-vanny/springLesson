package co.micol.prj.research.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.micol.prj.research.service.ResearchQuestionService;
import co.micol.prj.research.service.ResearchResponseService;
import co.micol.prj.research.service.ResearchServie;
import co.micol.prj.research.vo.ResearchQuestionVO;
import co.micol.prj.research.vo.ResearchResponseVO;
import co.micol.prj.research.vo.ResearchVO;
import co.micol.prj.research.vo.ResultVO;

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
	public String researchSelect(@ModelAttribute("lists") ResultVO vo, Model model) {
		model.addAttribute("vo", dao.researchSelectList());
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
		// ???????????? ??? id, qId, qOrder, qResult
		// int id, qId, qOrder
		// qResult[1] ????????? ?????????
		// ????????? ??????????????? ???????????? while??? ??????
		// vo ????????? => ????????? ????????? vo??? ???????????? ????????? add
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
			message="????????? ?????? ?????? ???????????????.";
		else
			message="?????? ????????? ?????????????????????.";
		model.addAttribute("str", message);
		return "research/researchAppendwrite";
//			return null;
	}
}
