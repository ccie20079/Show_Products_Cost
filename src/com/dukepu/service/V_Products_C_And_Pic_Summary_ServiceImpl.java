package com.dukepu.service;

import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.dukepu.dao.BaseDao;
import com.dukepu.dao.BaseDaoImpI;
import com.dukepu.entity.SoftwareInfo;
import com.dukepu.entity.V_Products_C_And_Pic_Summary;
import com.dukepu.entity.V_Products_Cost_Summary;
import com.dukepu.utils.DbHibernate;
import com.dukepu.utils.CommUtils;
import com.dukepu.utils.GetPicFromDB;

public class V_Products_C_And_Pic_Summary_ServiceImpl implements V_Products_C_And_Pic_Summary_Service {
	private BaseDao baseDao = new BaseDaoImpI();
	@SuppressWarnings("unchecked")
	@Override
	public List<V_Products_C_And_Pic_Summary> get_Products_C_And_Pic_Summary_Info(String page,String rows,String productName) {
		int pageParam = 0;
		int rowsParam = 0;
		List<V_Products_C_And_Pic_Summary> v_Products_C_And_Pic_Summary_List = new ArrayList<V_Products_C_And_Pic_Summary>();
		List<V_Products_Cost_Summary> v_Products_Cost_Summary_List = new ArrayList<V_Products_Cost_Summary>();
		StringBuffer HQL = new StringBuffer(
				"from V_Products_Cost_Summary where 1=1");
		if (!"".equals(productName) && productName != null) {
			HQL.append("  and  product_Name like '%" + productName + "%'  ");
		}
		try {
			pageParam = Integer.parseInt(page);
			rowsParam = Integer.parseInt(rows);
			v_Products_Cost_Summary_List = (List<V_Products_Cost_Summary>) baseDao.findWithPage(pageParam,
					rowsParam, HQL.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		V_Products_Cost_Summary v_Products_Cost_Summary = null;
		
		for(int i = 0;i<=v_Products_Cost_Summary_List.size()-1;i++){
			v_Products_Cost_Summary = v_Products_Cost_Summary_List.get(i);
			V_Products_C_And_Pic_Summary v_Products_C_And_Pic_Summary = new V_Products_C_And_Pic_Summary();
			v_Products_C_And_Pic_Summary.setMin_seq(v_Products_Cost_Summary.getMin_seq());
			v_Products_C_And_Pic_Summary.setProduct_Name(v_Products_Cost_Summary.getProduct_name());
			v_Products_C_And_Pic_Summary.setSupplier(v_Products_Cost_Summary.getSupplier());
			v_Products_C_And_Pic_Summary.setTotal_man_hours(v_Products_Cost_Summary.getTotal_man_hours());
			v_Products_C_And_Pic_Summary.setTotal_labour_cost(v_Products_Cost_Summary.getTotal_labour_cost());
			v_Products_C_And_Pic_Summary.setLatest_update_time(v_Products_Cost_Summary.getLatest_update_time());
			//获取照片从数据库中.
			String picName = GetPicFromDB.GetPicFromDB(v_Products_Cost_Summary.getProduct_name());
			v_Products_C_And_Pic_Summary.setPicture_name(picName);
			v_Products_C_And_Pic_Summary_List.add(v_Products_C_And_Pic_Summary);
		}
		return v_Products_C_And_Pic_Summary_List;
	}
	@Override
	public int getRows(String productName) {
		StringBuffer HQL = new StringBuffer(
				"select count(*) from V_Products_Cost_Summary where 1=1 ");
		if (!"".equals(productName) && productName != null) {
			HQL.append(" and product_Name like '%" + productName + "%'");
		}
		Object obj = baseDao.getObject(HQL.toString());
		if (obj != null) {
			long tempObj = (Long) obj;
			return (int) tempObj;
		}
		return 0;
	}
}
