package com.green.course.controller;

import com.green.course.controller.action.Action;
import com.green.course.controller.action.CourseListAction;

public class ActionFactory {
	private ActionFactory() {}
	private static ActionFactory af = new ActionFactory();
	public static ActionFactory getInstance() {
		return af;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		if(command.equals("course_list")) {
			action = new CourseListAction();
		} else if (command.equals("course_register_form")) {
			action = new CourseRegisterForm();
		} else if (command.equals("course_register")) {
			action = new CourseRegisterAction();
	    } else if (command.equals("course_info")) {
			action = new CourseInfoAction();
	    }
		return action;
	}	
}
