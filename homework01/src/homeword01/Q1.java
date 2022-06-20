package homeword01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Q1")
public class Q1 extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		int korScore = Integer.parseInt(request.getParameter("korScore"));
		int engScore = Integer.parseInt(request.getParameter("engScore"));
		int mathScore = Integer.parseInt(request.getParameter("mathScore"));
		
		int sumScore = korScore + engScore + mathScore;
		double avgScore = sumScore/3.0;
		
		String sum = String.valueOf(sumScore);
		String avg = String.valueOf(avgScore);
		
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + avg);
		
		
		PrintWriter out = response.getWriter(); // 인쇄 장비를 마련
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>과목 총점 및 평균 구하기</title>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("<h1>과목 총점 및 평균 구하기</h1>");
		out.println("<p> 국어점수 : " + korScore + "점</p>");
		out.println("<p> 영어점수 : " + engScore + "점</p>");
		out.println("<p> 수학점수 : " + mathScore + "점</p>");
		out.println("<p> 총점 : " + sum + "점</p>");
		out.println("<p> 평균 : " + avg + "점</p>");
		out.println("</body>");
		
		out.println("</html>");
	}

}
