

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Reg")
public class Reg extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 1. 값 받기
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String gender = request.getParameter("gender");
		String addr = request.getParameter("addr");
		String[] interest = request.getParameterValues("interest");
		String introduce = request.getParameter("introduce");
		
		// 콘솔 출력
//		System.out.println(name);
//		System.out.println(id);
//		System.out.println(pw);
//		System.out.println(gender);
//		System.out.println(addr);
		
		
//		for (String inter : interest) {
//			System.out.println(inter);	
//		}
//		
//		System.out.println(introduce);
		
		
		// content
		String interStr = "";
		
		if(interest !=null) {
			for (String inter : interest) {
				interStr += div(inter);
			}
		} else {
			interStr = div("관심사 없음");
		}
		
		
		String content = """
				  <div class="container">
        <div class="items">
          <div class="item1">Name</div>
          <div class="item2">
            <div>%s</div>
          </div>
        </div>
        <div class="items">
          <div class="item1">ID</div>
          <div class="item2">
            <div>%s</div>
          </div>
        </div>
        <div class="items">
          <div class="item1">PW</div>
          <div class="item2">
            <div>%s</div>
          </div>
        </div>
        <div class="items">
          <div class="item1">Gender</div>
          <div class="item2">
            <div>%s</div>
          </div>
        </div>
        <div class="items">
          <div class="item1">Addr</div>
          <div class="item2">
            <div>%s</div>
          </div>
        </div>
        <div class="items inter">
          <div class="item1">Interest</div>
          <div class="item2 interest">
				%s
          </div>
        </div>
        <div class="items text">
          <div class="item1">Introduce</div>
          <div class="item2">
            <div>%s</div>
          </div>
        </div>
      </div>
				""".formatted(name, id, pw, addr, gender, interStr, introduce );
		
		
		
		// response
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		String html = renderHtml(content, "/03/css/reg.css");

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
