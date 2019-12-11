package com.dukepu.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dukepu.entity.SoftwareInfo;
import com.dukepu.service.SoftwareInfoService;
import com.dukepu.service.SoftwareInfoServiceImpl;
import com.dukepu.utils.CommAction;
import com.dukepu.utils.CommUtils;

public class SoftwareInfoAction extends CommAction {
	private static final long serialVersionUID = 1L;
	private SoftwareInfoService softwareInfoService = new SoftwareInfoServiceImpl();
	//用于接受页面传来的参数.
	private String softwareName;
	public String getSoftwareName() {
		return softwareName;
	}
	public void setSoftwareName(String softwareName) {
		this.softwareName = softwareName;
	}
	public void getSoftwareInfo() throws IOException{
		List<SoftwareInfo>  softwareInfoResponseList =  softwareInfoService.getSoftwareInfo(getPage(), getRows(), "");
		int total = softwareInfoService.getRows(getSoftwareName());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", softwareInfoResponseList);
		CommUtils.toJSON(map);
	}
}
