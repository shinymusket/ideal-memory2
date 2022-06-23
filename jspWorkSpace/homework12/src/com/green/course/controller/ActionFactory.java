package com.green.course.controller;

import com.green.course.controller.action.Action;
import com.green.course.controller.action.CourseDeleteAction;
import com.green.course.controller.action.CourseInfoAction;
import com.green.course.controller.action.CourseListAction;
import com.green.course.controller.action.CourseRegisterAction;
import com.green.course.controller.action.CourseRegisterForm;
import com.green.course.controller.action.CourseUpdateAction;
import com.green.course.controller.action.CourseUpdateForm;
import com.green.course.controller.action.LectuererInfoAction;
import com.green.course.controller.action.LectuererListAction;
import com.green.course.controller.action.LectuererRegister;
import com.green.course.controller.action.LectuererRegisterForm;
import com.green.course.controller.action.LectuererUpdateAction;

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
	    } else if (command.equals("course_update_form")) {
			action = new CourseUpdateForm();
	    } else if (command.equals("course_update")) {
			action = new CourseUpdateAction();
	    } else if (command.equals("delete_course")) {
			action = new CourseDeleteAction();
	    } else if (command.equals("lectuerer_list")) {
			action = new LectuererListAction();
	    } else if (command.equals("lectuerer_register_form")) {
			action = new LectuererRegisterForm();
	    } else if (command.equals("lectuerer_register")) {
	    	action = new LectuererRegister();
	    } else if (command.equals("lectuerer_info")) {
	    	action = new LectuererInfoAction();
	    } else if (command.equals("lectuerer_update")) {
	    	action = new LectuererUpdateAction();
	    }
		return action;
	}	
}
