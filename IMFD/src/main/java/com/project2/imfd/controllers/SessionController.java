package com.project2.imfd.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

@Controller
public class SessionController {
	
	public HttpServletRequest req;

	public void sessionCreate(String uname) {
		HttpSession session = req.getSession(true);
        session.setAttribute("username", uname);
	}
	
	public void sessionDestroy() {
		HttpSession session = req.getSession(true);
		session.invalidate();
	}
}
