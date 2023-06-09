package form;

import java.util.Arrays;

public class FormCommand {
	private String loginType; // 회원 유형 : 일반회원, 기업회원, 헤드헌트 회원
	private String jobCode; // 직종 코드 : 프로그래머, 디자이너, 기획자
	private String[] favoriteOS; // 선호 OS : win, Linux, mac
	private boolean allowNoti; // 이메일 수신 동의 여부  
	
	public String getLoginType() {
		return loginType;
	}
	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
	public String getJobCode() {
		return jobCode;
	}
	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}
	public String[] getFavoriteOS() {
		return favoriteOS;
	}
	public void setFavoriteOS(String[] favoriteOS) {
		this.favoriteOS = favoriteOS;
	}
	public boolean isAllowNoti() { // ${formCommand.allowNoti}
		return allowNoti;
	}
	public void setAllowNoti(boolean allowNoti) {
		this.allowNoti = allowNoti;
	}
	
	@Override
	public String toString() {
		return "FormCommand [loginType=" + loginType + ", jobCode=" + jobCode + ", favoriteOS="
				+ Arrays.toString(favoriteOS) + ", allowNoti=" + allowNoti + "]";
	}
	
	
}
