package com.sw.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Test")
public class Test extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Test 진입");
		System.out.println(request.getContextPath());
		System.out.println(request.getParameter("bb"));
		System.out.println(request.getParameter("cc"));
		
		response.getWriter()
		.append("Current Path: ")
		.append(request.getContextPath())
		
		.append("\nQuery Params")
		.append("\n - bb: "+ request.getParameter("bb"))
		.append("\n - cc: "+ request.getParameter("cc"));
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
