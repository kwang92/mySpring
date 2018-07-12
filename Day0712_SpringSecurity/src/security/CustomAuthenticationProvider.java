package security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import model.SMember;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{
	
	@Autowired
	private UserDetailsService userDetailService;
	
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UsernamePasswordAuthenticationToken authToken;
		String memberid = authentication.getName();
		String password = (String)authentication.getCredentials();
		
		UserDetails member = userDetailService.loadUserByUsername(memberid);
		
		
		if(member == null) {
			throw new UsernameNotFoundException(memberid);
		}
		if(!( password.equals(member.getPassword()) )) {
			throw new BadCredentialsException("사용자가 없거나 비밀번호가 일치하지 않습니다.");
		} else {
			System.out.println("비번일치");
			
			authToken = new UsernamePasswordAuthenticationToken(memberid, password, member.getAuthorities());
		}
		return authToken;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(arg0);
	}

}
