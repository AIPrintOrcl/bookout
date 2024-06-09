package com.fastcampus.book.controller;

import com.fastcampus.book.domain.MemberDto;
import com.fastcampus.book.service.CustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CustController {

	@Autowired
	CustService custService;

	@GetMapping("/write")
	public String write(Model m) {

		Integer cust_no = custService.getLastCustNo(); // 마지막 고객번호

		m.addAttribute("cust_no", cust_no);

		return "write";
	}

	@GetMapping("/modify")
	public String modify(Integer cust_no, Model m) {

		MemberDto memberDto = custService.getCustInfo(cust_no); // 고객정보

		m.addAttribute("memberDto", memberDto);

		return "write";
	}

	@PostMapping("/writeEvent")
	public String writeEvent(MemberDto memberDto, String msg, Model m) {
		if("WRITE_FAIL".equals(msg)) {
			m.addAttribute("memberDto", memberDto);
			return "write";
		}

		custService.writeCust(memberDto);

		return "redirect:/custListModify";
	}

	@PostMapping("/modifyEvent")
	public String modifyEvent(MemberDto memberDto, String msg, Model m) {

		if("WRITE_FAIL".equals(msg)) {
			m.addAttribute("memberDto", memberDto);
			return "write";
		}

		custService.modifyCust(memberDto);

		return "redirect:/custListModify";
	}

	@GetMapping("/custListModify")
	public String custListModify(Model m) {

		List<MemberDto> list = custService.getCustList();

		m.addAttribute("list", list);

		return "custListModify";
	}
	
}
