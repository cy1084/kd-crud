package com.game.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommonView {
	private static final String PREFIX = "/WEB-INF/views";
	private static final String SUFFIX = ".jsp";

	public static void forward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = PREFIX + request.getRequestURI() + SUFFIX;
		RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

	public static String getCmd(HttpServletRequest request) {
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/") + 1;
		return uri.substring(idx);

		// uri.substring(request.getRequestURI().lastIndexOf("/")+1);
	}
	/*
	 * public static String getCmd(String uri) { int idx=uri.lastIndexOf("/")+1;
	 * return uri.substring(idx); //자른 것을 다시 uri에 대입 }
	 * 
	 * 
	 * public static void main(String[] args) { String uri="/user-info/list";
	 * uri=getCmd(uri);
	 * 
	 * uri="/user-info/insert"; uri=getCmd(uri);
	 * 
	 * uri="/test/view"; uri=getCmd(uri); }
	 */
	
	public static void forwardMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path="/WEB-INF/views/common/message.jsp";
		RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
