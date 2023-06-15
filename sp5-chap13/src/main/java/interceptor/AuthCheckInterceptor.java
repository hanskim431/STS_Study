package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

// 인증되지 않은 사용자가 허용되지 않는 페이지로 접근하는 것을 방지
public class AuthCheckInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);
		if (session != null) { 
		// 세션이 생성된 것을 판별, 이 작업 없이 바로 authInfo에 접근하면 NullPointError 발생 가능성
			Object authInfo = session.getAttribute("authInfo");
			// 세션에서 로그인 정보가 담긴 authInfo 속성을 가져와서 객체 생성 대입함
			if (authInfo != null) { // 로그인 정보가 없으면(비로그인) 참을 반환 
				return true;
			}
		}
		response.sendRedirect(request.getContextPath() + "/login"); // 로그인 페이지로 리다이렉트
		return false;
	}
}