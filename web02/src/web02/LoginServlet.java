package web02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LS")
public class LoginServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("로그인 기능 메서드!!!");
		
		String userid = request.getParameter("userid");
		String name = request.getParameter("name");
		String age = request.getParameter("age"); // 전달된 데이터 종류에 상관없이 문자열로 처리해야 함.
				
		System.out.println("입력된 아이디 : " + userid);
		System.out.println("입력된 이름 : " + name);
		
		// 체크박스 등 다수의 데이터가 하나의 이름으로 넣어올 때 => 배열로 처리
		String[] hobbys = request.getParameterValues("hobby");
		System.out.print("입력된 취미 : ");
		for(String hobby:hobbys) {
			System.out.print(hobby + ", ");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("로그인 기능 메서드!!!");
		System.out.println("POST 호출");
		
		request.setCharacterEncoding("UTF-8");
		
		String userid = request.getParameter("userid");
		String userpwd = request.getParameter("userpwd");
		String name = request.getParameter("name");
		String age = request.getParameter("age"); // 전달된 데이터 종류에 상관없이 문자열로 처리해야 함.
		
		
		System.out.println("입력된 아이디 : " + userid);
		System.out.println("입력된 비밀번호 : " + userpwd);
		System.out.println("입력된 이름 : " + name);
	}

}
