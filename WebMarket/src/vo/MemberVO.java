package vo;

public class MemberVO {
	
	private String memId;
	private String memPass;
	private String memName;
	private String memTel;
	private String memAddr;
	private String memPhoto;
	
	public MemberVO() {};
	
	public MemberVO(String memId, String memPass, String memName, String memTel, String memAddr, String memPhoto) {
		super();
		this.memId = memId;
		this.memPass = memPass;
		this.memName = memName;
		this.memTel = memTel;
		this.memAddr = memAddr;
		this.memPhoto = memPhoto;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPass() {
		return memPass;
	}

	public void setMemPass(String memPass) {
		this.memPass = memPass;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemTel() {
		return memTel;
	}

	public void setMemTel(String memTel) {
		this.memTel = memTel;
	}

	public String getMemAddr() {
		return memAddr;
	}

	public void setMemAddr(String memAddr) {
		this.memAddr = memAddr;
	}

	public String getMemPhoto() {
		return memPhoto;
	}

	public void setMemPhoto(String memPhoto) {
		this.memPhoto = memPhoto;
	}
	
	
	
	
}
