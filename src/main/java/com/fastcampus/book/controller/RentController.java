package com.fastcampus.book.controller;

import com.fastcampus.book.domain.RentDto;
import com.fastcampus.book.domain.RentPriceDto;
import com.fastcampus.book.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Handles requests for the application home page.
 */
@Controller
public class RentController {

	@Autowired
	RentService rentService;

	@GetMapping("/rentList")
	public String rentList(Model m) {
		List<RentDto> list = rentService.getRentList();

		m.addAttribute("list", list);
		return "rentList";
	}

	@GetMapping("/rentPrice")
	public String rentPrice(Model m) {

		List<RentPriceDto> list = rentService.getRentPriceList();

		m.addAttribute("list", list);

		return "rentPrice";
	}
	
}
