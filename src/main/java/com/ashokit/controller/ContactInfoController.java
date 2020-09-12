package com.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ashokit.modal.Contact;
import com.ashokit.service.impl.ContactServiceImpl;



@Controller
public class ContactInfoController {
	
	@Autowired
	private ContactServiceImpl contactServiceImpl;
	
    @GetMapping("/")
	public String loadContactForm(Model model) {   // for display
    	Contact contactObj = new Contact();
    	model.addAttribute("contact", contactObj);
		return "index";
	}
	
    @PostMapping("/saveContact")
	public String handleSubmitBtn(@ModelAttribute("contact") Contact c,RedirectAttributes model) { //for save and load and update
		
    	//model.addAttribute("msg", "Account created successfully");
		boolean isSaved = contactServiceImpl.saveContact(c);
		if(isSaved) {
			model.addFlashAttribute("succMsg", "Contect Saved");
		}else {
			model.addFlashAttribute("errMsg", "Faild to save contact");
		}
		return "redirect:/contactSuccess";
		
	}
    
    @GetMapping(value = "/contactSuccess")
    public String redirectForm(Model model) {
    	model.addAttribute("contact", new Contact());
		return "index";
    	
    }
    
    
	public String handleViewHiperLink(Model model) {   //show for hyper link /view all data
		return null;
		
	}
	
}
