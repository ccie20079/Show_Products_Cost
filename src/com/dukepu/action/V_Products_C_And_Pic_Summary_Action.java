package com.dukepu.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dukepu.entity.SoftwareInfo;
import com.dukepu.entity.V_Products_C_And_Pic_Summary;
import com.dukepu.service.SoftwareInfoService;
import com.dukepu.service.SoftwareInfoServiceImpl;
import com.dukepu.service.V_Products_C_And_Pic_Summary_Service;
import com.dukepu.service.V_Products_C_And_Pic_Summary_ServiceImpl;
import com.dukepu.utils.CommAction;
import com.dukepu.utils.CommUtils;

public class V_Products_C_And_Pic_Summary_Action extends CommAction{
	private static final long serialVersionUID = 1L;
	private V_Products_C_And_Pic_Summary_Service  v_Products_C_And_Pic_Summary_Service= new V_Products_C_And_Pic_Summary_ServiceImpl();
	//用于接受页面传来的参数.
	private String productName;
	
	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public void get_V_Products_C_And_Pic_Summary_Info() throws IOException{
		List<V_Products_C_And_Pic_Summary>  v_Products_C_And_Pic_Summary_ResponseList =  v_Products_C_And_Pic_Summary_Service.get_Products_C_And_Pic_Summary_Info(getPage(), getRows(), productName);
		int total = v_Products_C_And_Pic_Summary_Service.getRows(getProductName());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", v_Products_C_And_Pic_Summary_ResponseList);
		CommUtils.toJSON(map);
	}

}
