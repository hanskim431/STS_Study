package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class VersionPrinter {

	private int majorVersion;
	private int minorVersion;
	
	@Value("5")
	public void setMajorVersion(int majorVersion) {
		this.majorVersion = majorVersion;
	}
	
	@Value("1")
	public void setMinorVersion(int minorVersion) {
		this.minorVersion = minorVersion;
	}

	public void print() {
		System.out.printf("Program Version: %d.%d \n",majorVersion,minorVersion);
	}
}
