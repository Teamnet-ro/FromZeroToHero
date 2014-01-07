package ro.zerotohero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
/*@RequestMapping("/")*/
public class IndexController {

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		model.addAttribute("message", "Application Index");
		return "login";
	}

	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
 
		model.addAttribute("error", "true");
		return "login";
 
	}
 
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
 
		return "login";
 
	}
	
	/*@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap model) {
		return "redirect:/login";
	}*/
}