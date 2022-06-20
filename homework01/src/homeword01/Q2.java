package homeword01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Q2")
public class Q2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String id = "green";
		String pwd = "1234";
		
		String u_id = request.getParameter("userId");
		String u_pwd = request.getParameter("userPwd");
		
		
		PrintWriter out = response.getWriter();
		if (id.equals(u_id) && pwd.equals(u_pwd)) {
			
			out.println("<html>");
			out.println("<head>");
			out.println("<title>로그인</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>로그인 성공</h1>");
			out.println("</body>");
			out.println("</html>");
		} else {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>로그인</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>로그인 실패</h1>");
			out.println("</body>");
			out.println("</html>");
		}
	}

}
