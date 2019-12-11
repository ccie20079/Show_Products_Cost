package com.dukepu.service;

import java.util.List;

import com.dukepu.entity.SoftwareInfo;
import com.dukepu.entity.V_Products_C_And_Pic_Summary;
import com.dukepu.utils.Message;



public interface V_Products_C_And_Pic_Summary_Service{
	List<V_Products_C_And_Pic_Summary> get_Products_C_And_Pic_Summary_Info(String page,String rows,String productName);
	//返回某个软件信息可能产生的行数.
	int getRows(String productName);
}
