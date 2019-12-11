package com.dukepu.utils;

import com.dukepu.dao.BaseDaoImpI;
import com.dukepu.service.LoginServiceImpI;



public class CommSingletion {
	private static BaseDaoImpI baseDaoImpIInstance;
	
	public static BaseDaoImpI getBaseDaoImpIInstance(){  
		if(baseDaoImpIInstance==null){  
			baseDaoImpIInstance=new BaseDaoImpI();  
		}  
		return baseDaoImpIInstance;  
	} 

	
private static LoginServiceImpI LoginServiceImpIInstance;
	
	public static LoginServiceImpI getLoginServiceImpIInstanceInstance(){  
		if(LoginServiceImpIInstance==null){  
			LoginServiceImpIInstance=new LoginServiceImpI();  
		}  
		return LoginServiceImpIInstance;  
	} 
}
