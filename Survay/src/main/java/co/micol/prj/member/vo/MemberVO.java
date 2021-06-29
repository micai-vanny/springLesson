package co.micol.prj.member.vo;

public class MemberVO {
	private String email;
	private String name;
	private String password;
	private String state;
	

	public MemberVO() {
		// TODO Auto-generated constructor stub
	}

	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
