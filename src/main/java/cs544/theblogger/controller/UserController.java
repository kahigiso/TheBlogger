package cs544.theblogger.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cs544.theblogger.dao.UserDao;
import cs544.theblogger.entity.User;


@Controller
@RequestMapping(value="/users")
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
//	@ModelAttribute("user")
//	public User construct(){
//		return new User();
//	}

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getUsers(Model model){
		model.addAttribute("users", userDao.getAll());
		return "users";
	}
	
	@RequestMapping(value="/{userId}", method=RequestMethod.GET)
	public String userDetails(@PathVariable long userId, Model model){
		model.addAttribute("user", userDao.get(userId));
		return "userProfile";
	}
	
	@RequestMapping(value="/{userId}", method=RequestMethod.GET)
	public String editUser(@PathVariable long userId, Model model){
		model.addAttribute("user", userDao.get(userId));
		return "addUser";
	}
	
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	public String addUsers(@Valid User user, Model model){
		model.addAttribute("users", userDao.getAll());
		return "addUser";
	}
	
	@RequestMapping(value="/register")
	public String showRegister(){
		return "userRegister";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String doRegister(@Valid User user){
		
		return "";
	}
	

}
