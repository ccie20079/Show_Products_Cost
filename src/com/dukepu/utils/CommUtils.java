package com.dukepu.utils;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;

public class CommUtils {

	/**
	 * 设置Customer编号
	 * @return
	 */
	public static  String getCustomerUUID(){
		return java.util.UUID.randomUUID().toString()+System.currentTimeMillis();
	}

	/**
	 * 设置ManufacturerAction编号
	 * @return
	 */
	public static String getManufacturerUUID(){
		return java.util.UUID.randomUUID().toString()+System.currentTimeMillis();
	}
	/**
	 * 设置Orders编号
	 * @return
	 */
	public static String getOrdersUUID(){
		return java.util.UUID.randomUUID().toString()+System.currentTimeMillis();
	}
	/**
	 * 设置PurchaseInfo编号
	 * @return
	 */
	public static String getPurchaseInfoUUID(){
		return java.util.UUID.randomUUID().toString()+System.currentTimeMillis();
	}
	
	/**
	 * 设置货架编号
	 * @return
	 */
	public static String getPurchStrutsInfoUUID(){
		return java.util.UUID.randomUUID().toString()+System.currentTimeMillis();
	}
	/**
	 * 设置PurType编号
	 * @return
	 */
	public  static String getPurTypeUUID(){
		return java.util.UUID.randomUUID().toString()+System.currentTimeMillis();
	}
	/**
	 * 设置Store编号
	 * @return
	 */
	public static String getStoreUUID(){
		return java.util.UUID.randomUUID().toString()+System.currentTimeMillis();
	}
	/**
	 * 设置Users编号
	 * @return
	 */
	public static String getUsersUUID(){
		return java.util.UUID.randomUUID().toString()+System.currentTimeMillis();
	}

	/**
	 * 获得request对象
	 * @return
	 */
	public static HttpServletRequest getRequest(){
		return ServletActionContext.getRequest();
	}
	/**
	 * 获得response对象
	 * @return
	 */
	public static HttpServletResponse getResponse(){
		return ServletActionContext.getResponse();
	}
	/**
	 * 将map转化成json格式数据
	 * @param map
	 * @throws IOException
	 */
	public static void toJSON(Map<String,Object>map) throws IOException{
		getResponse().setCharacterEncoding("utf-8");
		//getResponse().setContentType("text/plain");
		getResponse().setContentType("application/json");
		getResponse().getWriter().print(new Gson().toJson(map));
		getResponse().getWriter().flush();
		getResponse().getWriter().close();
	}
	/**
	 * 将一个对象转化成json
	 * @param obj
	 * @throws IOException
	 */
	public static void toObjectJSON(Object obj) throws IOException{
		getResponse().setCharacterEncoding("utf-8");
		getResponse().getWriter().print(new Gson().toJson(obj));
		getResponse().getWriter().flush();
		getResponse().getWriter().close();
	}
	/**
	 * 关闭打印流，不进行任何json转化
	 * @throws IOException
	 */
	public static void closeprint() throws IOException{
		getResponse().setCharacterEncoding("utf-8");
		getResponse().getWriter().flush();
		getResponse().getWriter().close();
	}
	/**
	 * 获取系统当前时间
	 * @throws null
	 */
	public static String Time() {
		DateFormat df = DateFormat.getDateInstance();
		String dateString = df.format(new Date());
		df = DateFormat.getTimeInstance(DateFormat.MEDIUM);
		String timeString = df.format(new Date());
		return dateString + "  " + timeString;
	}
	public static String getProjectName(){
		String rootDir=getRequest().getServletContext().getContextPath();
		return rootDir.substring(1);
	}
}
