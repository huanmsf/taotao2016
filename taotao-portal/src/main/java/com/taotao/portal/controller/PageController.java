package com.taotao.portal.controller;


import com.taotao.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	@Autowired
	private AdService adService;

	@RequestMapping("/index")
	public String showIndex(Model model) throws Exception {

		String adResult = adService.getAdItemList();
		model.addAttribute("ad1", adResult);

		return "index";
	}
}
