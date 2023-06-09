package spring.service;

public class ServiceVersion {

	private String major;
	private int minor;
	
	public ServiceVersion() {} // setter를 사용하기 위함
	
	public ServiceVersion(String major, int minor) {
		this.major = major;
		this.minor = minor;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public void setMinor(int minor) {
		this.minor = minor;
	}

	public void versionPrint() {
		System.out.println("Program Version : " + major + "." + minor);
	}
}
