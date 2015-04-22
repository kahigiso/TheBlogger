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

import cs544.theblogger.entity.Category;
import cs544.theblogger.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@ModelAttribute("category")
	public Category construct(){
		return new Category();
	}
	
	@RequestMapping(value="/categories", method=RequestMethod.GET)
	public String getCategories(Model model){
		model.addAttribute("categories",categoryService.getAll());
		return "categories";
	}
		
	@RequestMapping(value="/categories/add")
	public String showForm(){
		return "addCategory";
	}
	
	@RequestMapping(value="/categories/edit/{id}", method=RequestMethod.GET)
	public String edit(@PathVariable long id, Model model){
		model.addAttribute("category", categoryService.find(id));
		return "addCategory";
	}
	
	@RequestMapping(value="/categories/add", method=RequestMethod.POST)
	public String doAdd(@Valid Category category, BindingResult result, Model model){
		String view = "redirect:/categories";
		if(!result.hasErrors()){
			categoryService.create(category);
			//TODO add success message
		}else view ="addCategory";
		return view;
	}
}
