package com.green.shopping.controller;

import com.green.shopping.controller.action.Action;
import com.green.shopping.controller.action.IndexAction;
import com.green.shopping.controller.action.MemberRegisterAction;
import com.green.shopping.controller.action.MemberRegisterForm;
import com.green.shopping.controller.action.MemberSelectAction;

public class ActionFactory {
	private ActionFactory() {}
	private static ActionFactory af = new ActionFactory();
	public static ActionFactory getInstance() {
		return af;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		if (command.equals("home")) {
			action = new IndexAction();
		} else if (command.equals("member_register_form")) {
			action = new MemberRegisterForm();
		} else if (command.equals("member_register")) {
			action = new MemberRegisterAction();
		} else if (command.equals("member_select")) {
			action = new MemberSelectAction();
		}
		
		
		return action;
	}
	
	
}
