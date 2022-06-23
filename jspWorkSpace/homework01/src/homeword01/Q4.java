package homeword01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Q4")
public class Q4 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("userName");
		double temp = Double.parseDouble(request.getParameter("userTemp"));
		
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>코로나 검사</title>");
		out.println("<h1>코로나 검사 결과</h1>");
		out.println("<body>");

		if (temp < 37.5) {
			out.println("<p>" + name + "님 코로나 '음성'입니다. </p>");
		} else if (temp >= 37.5) {
			int r = (int) (Math.random() * 100);
			if (r <= 19) {
				out.println("<p>" + name + "님 코로나 '양성'입니다. </p>");
			} else if (r >= 20) {
				out.println("<p>" + name + "님 코로나 '음성'입니다. </p>");
			}
			
			
		}
		
		out.println("</body>");
		out.println("</html>");
		
		
	}

}
