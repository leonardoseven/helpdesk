package br.com.spmdesk.DAO;

public class LoginDAO {

	private static final String VERIFICALOGIN = "SELECT  username, password form tbuser where username = ? and password = ?";
	
	public int verifyUser(String user, String pass) {
		return 1;
	}
}
