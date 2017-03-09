package pmh.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApplicationController {
	@RequestMapping("/index")
	public String home(HttpServletRequest request){
		return "home";
	}
}
