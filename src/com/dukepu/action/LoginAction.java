package com.dukepu.action;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import com.dukepu.service.LoginService;
import com.dukepu.utils.CommAction;
import com.dukepu.utils.CommSingletion;
import com.dukepu.utils.CommUtils;
import com.dukepu.utils.Message;


public class LoginAction extends CommAction {
	private static final long serialVersionUID = 1L;

	private String username;
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	LoginService loginService = CommSingletion
			.getLoginServiceImpIInstanceInstance();

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	public void login() throws Exception {
		Message msg = loginService.login(username, password);
		if (msg.getFlag()) {
			// ��¼�ɹ���������session�����á�
			HttpSession session = CommUtils.getRequest().getSession();
			session.setAttribute("username", username);
		}
		CommUtils.toObjectJSON(msg);
	}
/*
	public void registerUser() throws IOException {
		UsersService usersService = CommSingletion
				.getUsersServiceImpIInstance();
		// �ȵõ������û�
		CommUtils.toObjectJSON(usersService.registerUser(username, userEmail));
	}
*/
	public void logout() throws IOException {
		HttpSession session = CommUtils.getRequest().getSession();
		session.removeAttribute("username");
		session.invalidate();
		CommUtils.getResponse().sendRedirect("login.jsp");
	}

}