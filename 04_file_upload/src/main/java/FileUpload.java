
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/FileUpload")
public class FileUpload extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. 저장 경로
//		String savePath = "C:\\Users\\soldesk\\Desktop\\mr-test";

		String saveRealPath = request.getServletContext().getRealPath("/images");

//		System.out.println(savePath);
		System.out.println(saveRealPath);

		// 서버 파일 중복되면 안되므로 파일명 처리가 필요함 a1.jpg, a2.jpg, a3.jpg ...

		// 2. 파일 처리(객체생성 만으로도 업로드 기능처리 끝)
		MultipartRequest mr = new MultipartRequest(request, saveRealPath, 30 * 1024 * 1024, "UTF-8",
				new DefaultFileRenamePolicy());

		// 3. 값 받기
		String name = mr.getParameter("name");
		System.out.println(name);

		// 업로드한 파일명
		String pic = mr.getFilesystemName("pic");
		System.out.println(pic);
		String etc = mr.getFilesystemName("etc");
		System.out.println(etc);

		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset=\"utf-8\">");
		out.print("</head>");
		out.print("<body>");

		out.print("<h1>" + name + "</h1>");
		out.printf("<h1><img src='images/%s'></h1>", pic);
		out.printf("<h1>%s</h1>", etc);

		out.printf("<h1><a href='images/%s'>사진보기</a></h1>", pic);
		out.printf("<h1><a href='images/%s'>파일 다운로드</a></h1>", etc);

		out.print("</body>");
		out.print("</html>");

	}

}
