package spring.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import spring.dao.MemberDao;
import spring.vo.ListCommand;
import spring.vo.Member;

@Controller
public class MemberListController {
	private MemberDao dao;

	public void setDao(MemberDao dao) {
		this.dao = dao;
	}
	
	@GetMapping("member/list")
	public String form(ListCommand listcommand) {
		
		return "member/memberList";
	}
	
	@PostMapping("member/list")
	public String list(ListCommand listcommand, Model model) {
		
		if(listcommand.getFrom() != null && listcommand.getTo() != null) {
			List<Member> list = dao.selectByRegDate(listcommand.getFrom(), listcommand.getTo());
			System.out.println("조호된 회원 수 : " + list.size());
			model.addAttribute("members", list);
		}
			
		return "member/memberList";
	}

}