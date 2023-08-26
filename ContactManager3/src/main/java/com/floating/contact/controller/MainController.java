package com.floating.contact.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.floating.contact.dao.ContactDAO;
import com.floating.contact.model.Contact;

@Controller
public class MainController {

	@Autowired
	private ContactDAO contactDAO;

 	/*@RequestMapping(value="/")
	public String home()
	{
		return "index";
	}*/
	

		
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(@RequestParam(value = "searchName", required = false) String searchName) {
	    ModelAndView model = new ModelAndView("index");
	    
	    List<Contact> listContact;
	    if (searchName != null && !searchName.isEmpty()) {
	        listContact = contactDAO.searchByName(searchName);
	    } else {
	        listContact = contactDAO.list();
	    }

	    model.addObject("listContact", listContact);
	    return model;
	}
	
	
	@RequestMapping(value="/new",  method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model)
	{
		Contact newContact = new Contact();
		model.addObject("contact", newContact);
		model.setViewName("contact_form");
		return model;
		
	}
	@RequestMapping(value="/save",  method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Contact contact)
	{
		if(contact.getId()==null)
		{
			contactDAO.save(contact);
		}
		else
		{
			contactDAO.update(contact);
		}
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value="/edit",  method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request)
	{
		Integer id=Integer.parseInt(request.getParameter("id"));
		Contact contact =contactDAO.get(id);
		ModelAndView model=new ModelAndView("contact_form");
		model.addObject("contact",contact);
		return  model;
	}
	
	@RequestMapping(value="/delete",  method = RequestMethod.GET)
	public ModelAndView deleteContact (@RequestParam Integer id)
	{
		contactDAO.delete(id);
		
		return new ModelAndView("redirect:/");
	}
	
	 
	
	  
}