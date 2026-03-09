package com.sw.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OddEven")
public class OddEven extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));

		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		String html = renderHtml("<h1>" + (num % 2 == 0 ? "짝" : "홀") + "</h1>");

		out.print(html);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public String renderHtml(String content) {
		return """
				<html>
				<head>
					<meta charset=\"UTF-8\">
					<link rel=\"stylesheet\" href=\"/css/output.css\">
				</head>
				<body>
				%s
				</body>
				</html>
				""".formatted(content);
	}

}
