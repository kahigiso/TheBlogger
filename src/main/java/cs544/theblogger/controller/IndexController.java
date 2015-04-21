package cs544.theblogger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cs544.theblogger.dao.UserDao;


@Controller
public class IndexController {
	
	@Autowired
	private UserDao userDao;

	@RequestMapping(value="/home")
	public String home(Model model){
		model.addAttribute("verif", userDao.getAll());
		return "home";
	}

}
