package com.green.pt001.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.green.pt001.service.StaffServiceImpl;
import com.green.pt001.vo.StaffVO;

@Controller
@RequestMapping("/staff")
public class StaffController {
	
	@Autowired
	private StaffServiceImpl service;
	
	// 교직원 명단 불러오기
	@RequestMapping(value = "/staff_list", method = RequestMethod.GET)
	public String list(Model model) throws Exception {
		List<StaffVO> list = service.selectStaffList();
		model.addAttribute("staffList", list);
		return "/staff/staffList";
	}
	
	// 교직원 등록 폼 이동
	@RequestMapping(value = "/staff_register", method = RequestMethod.GET)
	public String registerForm(Model model) throws Exception {
		int result = service.selectStaffSeq();
		model.addAttribute("nextSeq", result);
		return "/staff/staffRegister";
	}
	
	// 교직원 등록
	@RequestMapping(value = "/staff_register", method = RequestMethod.POST)
	public String register(@ModelAttribute StaffVO sVo, RedirectAttributes rttr) throws Exception {
		rttr.addFlashAttribute("result", service.insertStaff(sVo));
		return "redirect:./staff_list";
	}
	
	// 교직원 정보 상세조회
	@RequestMapping(value = "/staff_info", method = RequestMethod.GET)
	public String info(Model model, @RequestParam("staff_num") String staff_num) throws Exception {
		StaffVO sVo = service.selectStaffInfo(staff_num);
		model.addAttribute("staff", sVo);
		return "/staff/staffInfo";
	}
	
	// 교직원 삭제
	@RequestMapping(value = "/staff_delete", method = RequestMethod.GET)
	public String delete(@RequestParam("staff_num") String staff_num, RedirectAttributes rttr) throws Exception {
		rttr.addFlashAttribute("result", service.deleteStaff(staff_num));
		return "redirect:./staff_list";
	}
	
	// 교직원 수정 폼 이동
	@RequestMapping(value = "/staff_update_form", method = RequestMethod.GET)
	public String updateForm(Model model, @RequestParam("staff_num") String staff_num) throws Exception {
		StaffVO sVo = service.selectStaffInfo(staff_num);
		model.addAttribute("staff", sVo);
		return "/staff/staffUpdate";
	}
	
	// 교직원 정보 수정
	@RequestMapping(value = "/staff_update", method = RequestMethod.POST)
	public String update(@ModelAttribute StaffVO sVo, RedirectAttributes rttr) throws Exception {
		rttr.addFlashAttribute("result", service.updateStaff(sVo));
		return "redirect:./staff_list";
	}
			
}
