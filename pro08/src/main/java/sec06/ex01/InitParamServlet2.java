package sec06.ex01;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitParamServlet2 extends HttpServlet{


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = getInitParameter("email");
		String tel = getInitParameter("tel");
		System.out.println("이메일 : " + email);
		System.out.println("전화번호 : " + tel);
		
		System.out.println("=============================");
		
		Enumeration<String> paramName = getInitParameterNames();
		
		while(paramName.hasMoreElements()) { // rs.next()
			String result = paramName.nextElement();
			System.out.println(result + " : " + getInitParameter(result));
		}
		
	}
}
