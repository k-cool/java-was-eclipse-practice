package com.sw.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		String guide;

		if (!"sw".equals(id)) {
			guide = h1("존재하지 않는 회원입니다.", "err");
		} else if (!"1004".equals(pw)) {
			guide = h1("비번 오류", "err");
		} else {
			guide = h1("로그인 성공!", "success");
		}

		String content;
		String idH1 = h1("id: " + id, "");
		String pwH1 = h1("pw: " + pw, "");

		content = """
				<div class="box">
					%s
					%s
					%s
				</div>
				""".formatted(idH1, pwH1, guide);

		// response
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		String html = renderHtml(content, "login");

		out.print(html);
	}

	public String renderHtml(String content, String css) {
		return """
				<html>
				<head>
					<meta charset=\"UTF-8\">
					<link rel=\"stylesheet\" href=\"/css/%s.css\">
				</head>
				<body>
				%s
				</body>
				</html>
				""".formatted(css, content);
	}

	public String div(String content, String className) {
		return """
				<div class="%s">%s</div>
				""".formatted(className, content);
	}

	public String h1(String content, String className) {
		return """
				<h1 class="%s">%s</h1>
				""".formatted(className, content);
	}

}
