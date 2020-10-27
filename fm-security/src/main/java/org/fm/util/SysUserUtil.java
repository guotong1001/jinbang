package org.fm.util;


import org.fm.bean.FMUserInfo;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

public class SysUserUtil {

	/**
	 * 获取登陆的 LoginAppUser
	 *
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static FMUserInfo getLoginAppUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication instanceof OAuth2Authentication) {
			OAuth2Authentication oAuth2Auth = (OAuth2Authentication) authentication;
			authentication = oAuth2Auth.getUserAuthentication();
			if (authentication instanceof UsernamePasswordAuthenticationToken) {
				UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) authentication;
				return (FMUserInfo) authenticationToken.getPrincipal();
			} else if (authentication instanceof PreAuthenticatedAuthenticationToken) {
				// 刷新token方式
				PreAuthenticatedAuthenticationToken authenticationToken = (PreAuthenticatedAuthenticationToken) authentication;
				return (FMUserInfo) authenticationToken.getPrincipal();
			}
		}
		return null;
	}
}
