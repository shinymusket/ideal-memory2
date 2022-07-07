package spring.vo;

public class LoginCommand {
	
	private String email;
	private String password;
	private boolean remeberEmail;
	
	public boolean isRemeberEmail() {
		return remeberEmail;
	}
	public void setRemeberEmail(boolean remeberEmail) {
		this.remeberEmail = remeberEmail;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
