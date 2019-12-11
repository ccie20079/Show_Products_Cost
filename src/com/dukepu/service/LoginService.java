package com.dukepu.service;

import java.util.List;

import com.dukepu.utils.Message;



public interface LoginService {

	// 判断是否为有效账户�?
	Message login(String username, String email);

}
