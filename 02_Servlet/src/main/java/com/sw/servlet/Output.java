package com.sw.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Output")
public class Output extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Output 진입");
		
		String s = request.getParameter("say");
		String c = request.getParameter("cnt");
		
		System.out.println(s);
		System.out.println(c);
		
		
		int cInt = Integer.parseInt(c);
		
		if (s == null || c == null) {
		    response.getWriter().append("parameter missing");
		    return;
		}
		

	    response.setContentType("text/html; charset=UTF-8");

	    PrintWriter out = response.getWriter();
	    
	    out.print("<html>");
	    out.print("<head>");
	    
	    out.print("<meta charset=\"UTF-8\">");
	    out.print("<link rel=\"stylesheet\" href=\"/css/output.css\">");
	    
	    out.print("<body>");
	    
	    for (int i = 0; i < cInt; i++) {
	    	out.print("<h1>"+s+"</h1>");
	    }
	    
	    out.print("</body>");
	    out.print("</head>");
	    out.print("</html>");

		
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
