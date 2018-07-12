package test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncodingTest {
	public static void main(String[] args) {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		// 123 -> 60자, 1자당 20자 
		
		System.out.println(encoder.matches("97", encoder.encode("a")));
	}
}
