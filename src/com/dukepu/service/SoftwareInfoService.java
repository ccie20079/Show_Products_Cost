package com.dukepu.service;

import java.util.List;

import com.dukepu.entity.SoftwareInfo;
import com.dukepu.utils.Message;



public interface SoftwareInfoService {

	List<SoftwareInfo> getSoftwareInfo(String page,String rows,String softwareName);
	//返回某个软件信息可能产生的行数.
	int getRows(String softwareName);
}
