package nowon.domain.dto;

public class MemberLogDTO {
	private String email;
	private String pass;
	
	
	
	public MemberLogDTO(String email, String pass) {
		super();
		this.email = email;
		this.pass = pass;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	

}
