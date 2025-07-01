package com.core.api_management_web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.core.api_management_web.model.Api;
import com.core.api_management_web.service.Api_Service;

import lombok.Data;

@Data
@Controller
public class Api_Controller {

	@Autowired
	private Api_Service service;
	
	@GetMapping("/")
	public String home(Model model) {
		Iterable<Api> listApi = service.getApi();
		model.addAttribute("Api", listApi);
		return "home";
	}
	
	@GetMapping("/createApi")
	public String createApi(Model model) {
		Api e = new Api();
		model.addAttribute("api", e);
		return "formNewApi";
	}
	
	@GetMapping("/updateApi/{id}")
	public String updateApi(@PathVariable("id") final int id, Model model) {
		Api e = service.getApi(id);		
		model.addAttribute("api", e);	
		return "formUpdateApi";		
	}
	
	@GetMapping("/deleteApi/{id}")
	public ModelAndView deleteApi(@PathVariable("id") final int id) {
		service.deleteApi(id);
		return new ModelAndView("redirect:/");		
	}
	
	@PostMapping("/saveApi")
	public ModelAndView saveApi(@ModelAttribute Api api) {
		if(api.getId() != null) {
			// Api from update form has the nom_api field not filled,
			// so we fill it with the current nom_api.
			Api current = service.getApi(api.getId());
			api.setNom_api(current.getNom_api());////////////////////////////////////////////////
		}
		service.saveApi(api);
		return new ModelAndView("redirect:/");	
	}
}
