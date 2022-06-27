package com.green.shopping.controller;

import com.green.shopping.controller.action.Action;
import com.green.shopping.controller.action.IndexAction;
import com.green.shopping.controller.action.MemberRegisterAction;
import com.green.shopping.controller.action.MemberRegisterForm;
import com.green.shopping.controller.action.MemberSelectAction;
import com.green.shopping.controller.action.MemberSelectPriceAction;
import com.green.shopping.controller.action.MemberUpdateAction;
import com.green.shopping.controller.action.MemberUpdateForm;

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
		} else if (command.equals("member_select_price")) {
			action = new MemberSelectPriceAction();
		} else if (command.equals("member_update_form")) {
			action = new MemberUpdateForm();
		} else if (command.equals("member_update")) {
			action = new MemberUpdateAction();
		}
		
		return action;
	}
	
	
}
