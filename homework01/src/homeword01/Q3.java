package homeword01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Q3")
public class Q3 extends HttpServlet {
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String[] dans = request.getParameterValues("dan");
			
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>구구단</title>");
		out.println("<style>table, td {border: 1px solid #ccc; border-collapse: collapse} table {float:left; margin-left:20px;} </style>");
		
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>구구단</h1>");
		
		
		
		for(String dan:dans) {
			int i = Integer.parseInt(dan);
			out.println("<table>");
			for (int j = 1; j <= 9; j++) {
				
				out.println("<tr>");
				out.println("<td>");
				out.println(i + " X " + j + " = " + i*j);
				out.println("</td>");
				out.println("</tr>");
				
			}
			out.println("</table>");
		}
		
		
		out.println("</body>");
		out.println("</html>");
		
		
		
	}

}
