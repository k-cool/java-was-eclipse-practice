package com.mz.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 어노테이션 주의사항
 * 1. 복붙해도 저건 안바꿔줌. 수동처리
 * 2. refactor해도 안바꿔줌
 * 
 * @WebServlet안에 명시되어있는 PATH기준으로 라우팅됨.
 */

@WebServlet("/BB")
public class BB extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append(request.getContextPath());
//		response.getWriter().append("GET: HELLO WORLD").append(request.getContextPath());
		
		System.out.println("BB진입");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		doGet(request, response);
		
		response.getWriter().append("POST: HELLO WORLD");
	}

}
