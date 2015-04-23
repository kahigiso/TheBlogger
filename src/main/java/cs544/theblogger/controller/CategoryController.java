package cs544.theblogger.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@RequestMapping(value="/manage/categories", method=RequestMethod.GET)
	public String getCategories(Model model){
		model.addAttribute("categories",categoryService.getAll());
		return "categories";
	}
		
	@RequestMapping(value="/manage/categories/add")
	public String showForm(){
		return "addCategory";
	}
	
	@RequestMapping(value="/manage/categories/delete/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable long id,HttpServletRequest request, Model model,RedirectAttributes redirectAttributes){
		if(categoryService.find(id)!=null){
			categoryService.delete(id);
			redirectAttributes.addFlashAttribute("SUCCESS_MESSAGE", "Category deteted successfully!");
		}else{
			redirectAttributes.addFlashAttribute("FAILED_MESSAGE", "Category could not be deteted!");
		}
		return "redirect:"+request.getHeader("Referer");
	}
	
	@RequestMapping(value="/manage/categories/edit/{id}", method=RequestMethod.GET)
	public String edit(@PathVariable long id, Model model){
		model.addAttribute("category", categoryService.find(id));
		return "addCategory";
		
	}
	
	
	@RequestMapping(value="/manage/categories/addo", method=RequestMethod.POST)
	public String doAdd(@Valid Category category, BindingResult result, Model model){
		String view = "redirect:/manage/categories";
		if(!result.hasErrors()){
			categoryService.create(category);
			//TODO add success message
		}else view ="addCategory";
		return view;
	}
}
