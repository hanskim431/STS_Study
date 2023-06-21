package spring;

import java.time.LocalDateTime;
import java.util.Date;

public class DemoBean {
	
	private Date regDate;
	private LocalDateTime updateDate; 

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}
}