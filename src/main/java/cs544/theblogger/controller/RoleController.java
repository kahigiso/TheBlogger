package cs544.theblogger.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cs544.theblogger.entity.Role;
import cs544.theblogger.service.RoleService;

@Controller
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@ModelAttribute("role")
	public Role construct(){
		return new Role();
	}
	
	@RequestMapping(value="/administrate/roles", method=RequestMethod.GET)
	public String listAll(Model model){
		model.addAttribute("roles", roleService.findAll());
		return "roles";
	}
	
	@RequestMapping(value="/administrate/roles/add")
	public String showAdd(){
		return "addRole";
	}
	
	@RequestMapping(value="/administrate/roles/add/{id}", method=RequestMethod.GET)
	public String edit(@PathVariable long id, Model model){
		model.addAttribute("role", roleService.find(id));
		return "addRole";
	}
		
	@RequestMapping(value="/administrate/roles/add/", method=RequestMethod.POST)
	public String add(@Valid Role role, BindingResult result, Model model){
		String view ="redirect:roles";
		if(!result.hasErrors()){
			roleService.create(role);
			//TODO add success message
		}else view ="addRole";
		
		return view;
	}
	
	

}
