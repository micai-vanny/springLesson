package co.micol.prj;


import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping("home.do")
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
				
		
		return "home";
	}
	
	//				 ┌>모든 Form들을 이걸로 조지는 것...!
	@RequestMapping("*/*Form.do")
	public String researchFormCall(HttpServletRequest request) {
//		String path = request.getContextPath();
//		String uri = request.getRequestURI();
//		// 						┌>이게 ContextPath
//		//http://www.yedam.ac/search/list.do 이 주소 자체는 URL
//		//						└>여기서 부터 list.do까지가 URI
//		String viewPage = uri.substring(path.length());
//			// /aaaForm.do 출력
//		viewPage = "research" + viewPage.substring(0, viewPage.indexOf(".do"));
//		이걸 다 줄이면 아래와 같음.	

		String viewPage = request.getServletPath();
	    viewPage = viewPage.substring(0, viewPage.lastIndexOf(".do"));
	      
		return viewPage;
	}
	
}
