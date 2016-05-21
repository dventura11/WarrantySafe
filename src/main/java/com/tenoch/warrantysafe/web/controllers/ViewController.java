package com.tenoch.warrantysafe.web.controllers;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController implements ErrorController{

	private static final String INDEX_PAGE_NAME = "index";
	private static final String PUBLIC_PAGE_FORMAT = "/view/public/%s";
	private static final String PRIVATE_PAGE_FORMAT = "/view/private/%s";

	@RequestMapping("/")
	public String indexView() {
		return publicView(INDEX_PAGE_NAME);
	}
	
	@RequestMapping("/error")
	public String errorView() {
		return "error";
	}

	@RequestMapping("/{page}")
	public String publicView(String page) {
		return String.format(PUBLIC_PAGE_FORMAT, page);
	}
	
	@RequestMapping("/secure/")
	public String privateIndexView() {
		return privateView(INDEX_PAGE_NAME);
	}
	
	@RequestMapping("secure/{page}")
	public String privateView(String page) {
		return String.format(PRIVATE_PAGE_FORMAT, page);
	}

	@Override
	public String getErrorPath() {
		return "error";
	}
	
	
}
