package book.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

public class UserRealm extends AuthorizingRealm {

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		// TODO Auto-generated method stub
		UsernamePasswordToken token=(UsernamePasswordToken)arg0;
		System.out.print(token.getUsername());
		System.out.print(token.getPassword());
		if(!(token.getUsername().equals("yq")))
			return null;
		//2.判断密码
		return new SimpleAuthenticationInfo(token,"123",ByteSource.Util.bytes("siggy"),this.getName());
	}

}
