package com.dukepu.service;

import com.dukepu.dao.BaseDao;
import com.dukepu.dao.BaseDaoImpI;
import com.dukepu.entity.User_Info;
import com.dukepu.utils.*;



public class LoginServiceImpI implements LoginService {
	BaseDao baseDao = new BaseDaoImpI();

	@Override
	public Message login(String username, String password) {

		Message msg = new Message();

		// 先判断是否存在此账户�?
		User_Info user = (User_Info) baseDao
				.getObject(String.format("from  User_Info where user_name = '%s' and Product_Name = '%s'", username,CommUtils.getProjectName()));
		if (user == null) {
			msg.setContent("此账户不存在,请先注册。");
			msg.setFlag(false);
			return msg;
		}
		// 判断密码是否正确�?
		if (!password.equals(user.getPassword())) {
			msg.setContent("密码不正确，请与设计者联系");
			msg.setFlag(false);
			return msg;
		}
		msg.setFlag(true);
		msg.setContent("密码验证通过！");
		return msg;
	}
}