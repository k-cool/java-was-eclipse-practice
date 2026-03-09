

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Calc")
public class Calc extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));

		
		String plus = div("""
				%d + %d = %d
				""".formatted(x, y, x+y)); 
		String minus = div("""
				%d + %d = %d
				""".formatted(x, y, x-y)); 
		String multiple = div("""
				%d + %d = %d
				""".formatted(x, y, x*y)); 
		String divide = div("""
				%d + %d = %d
				""".formatted(x, y, x/y)); 
		
		String content  = """
				<div class="box">
					%s
					%s
					%s
					%s
				</div>
				""".formatted(plus, minus, multiple, divide);

		// response
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		String html = renderHtml(content, "/03/css/calc.css");

		out.print(html);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public String renderHtml(String content, String css) {
		return """
				<html>
				<head>
					<meta charset=\"UTF-8\">
					<link rel=\"stylesheet\" href=\"%s\">
				</head>
				<body>
				%s
				</body>
				</html>
				""".formatted(css, content);
	}

	public String div(String content) {
		return """
				<div>%s</div>
				""".formatted(content);
	}
	
	public String div(String content, String className) {
		return """
				<div class="%s">%s</div>
				""".formatted(className, content);
	}

	
	public String h1(String content) {
		return """
				<h1>%s</h1>
				""".formatted(content);
	}
	
	public String h1(String content, String className) {
		return """
				<h1 class="%s">%s</h1>
				""".formatted(className, content);
	}
	

}
