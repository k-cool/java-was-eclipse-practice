

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Calc2")
public class Calc2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		String[] ops= request.getParameterValues("oper");
		String calcContent="";
		String guide= "";
		
		
		System.out.println(x + " "+y);
		
		
		for (String op : ops) {
			if(op.equals("plus")) 
				calcContent += div("""
				%d + %d = %d
				""".formatted(x, y, x+y));
				
			if(op.equals("minus")) 
				calcContent += div("""
				%d - %d = %d
				""".formatted(x, y, x-y));
			
			if(op.equals("multiply")) 
				calcContent +=  div("""
				%d x %d = %d
				""".formatted(x, y, x*y));
			
			if(op.equals("divide")) {
				if(y==0) {
					guide ="0으로 나눌 수 없어요";
				} else {
					
					DecimalFormat df = new DecimalFormat("#.##");
					String dResult = df.format((double)x/(double)y);
					
					calcContent += div("""
					%d / %d = %s
					""".formatted(x, y, dResult));
				}
			}	
			
		}
		
				
		if(!guide.equals("")) calcContent += h1(guide, "err");
			
				
		String content  = """
				<div class="box">
					%s
				</div>
				""".formatted(calcContent);

		// response
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		String html = renderHtml(content, "/03/css/calc.css");

		out.print(html);
		
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
