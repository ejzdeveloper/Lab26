package co.grandcircus.Lab26MovieApi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class indexMovieController {
	
	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index");
	}

}
