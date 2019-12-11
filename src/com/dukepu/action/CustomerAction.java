package com.dukepu.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dukepu.utils.CommAction;

/**
 * 
 * @author 董魁 2015-05-19
 * 
 */

public class CustomerAction extends CommAction {
	private static final long serialVersionUID = 1L;

	// 用于修改用户信息�?
	private String fid;
	//private static Customer c;
	// 用于模糊查询，客户姓�?
	private String id;
	private String custName;
	private String custSex;
	private String custTel;
	private String custAddress;
	private String custBirthday;
	private String custCardnumber;
	private String custEmail;
	private String custVip;// 0�?,�?
	private String custRegisterTime;
	private String custDesc;
	private String orderIdStr;
	private String orderNumber;

	// 前台传输的待删除ID数组

	private String[] arrayOfID;

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	//private CustomerService customerService = new CustomerServiceImpI();

	public String getCustSex() {
		return custSex;
	}

	public void setCustSex(String custSex) {
		this.custSex = custSex;
	}

	public String getCustTel() {
		return custTel;
	}

	public void setCustTel(String custTel) {
		this.custTel = custTel;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public String getCustBirthday() {
		return custBirthday;
	}

	public void setCustBirthday(String custBirthday) {
		this.custBirthday = custBirthday;
	}

	public String getCustCardnumber() {
		return custCardnumber;
	}

	public void setCustCardnumber(String custCardnumber) {
		this.custCardnumber = custCardnumber;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getCustVip() {
		return custVip;
	}

	public void setCustVip(String custVip) {
		this.custVip = custVip;
	}

	public String getCustRegisterTime() {
		return custRegisterTime;
	}

	public void setCustRegisterTime(String custRegisterTime) {
		this.custRegisterTime = custRegisterTime;
	}

	public String getCustDesc() {
		return custDesc;
	}

	public void setCustDesc(String custDesc) {
		this.custDesc = custDesc;
	}

	public String getOrderIdStr() {
		return orderIdStr;
	}

	public void setOrderIdStr(String orderIdStr) {
		this.orderIdStr = orderIdStr;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String[] getArrayOfID() {
		return arrayOfID;
	}

	public void setArrayOfID(String[] arrayOfID) {
		this.arrayOfID = arrayOfID;
	}
	/*
	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public void findWithPage() throws IOException {
		List<CustomerResponse> CustomerResponseList = customerService
				.findWithPage(getPage(), getRows(), getCustName());

		int total = customerService.getRows(getCustName());

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", CustomerResponseList);

		CommUtils.toJSON(map);
	}

	public void deleteCustomerByIDArray() throws IOException {

		int count = 0;
		// 注意前台传�?数组，名字可以不带[],但是后台获取时，名字后面必须跟[]
		arrayOfID = CommUtils.getRequest().getParameterValues("arrayOfID[]");

		Message deleteResult = customerService
				.deleteCustomerByIDArray(arrayOfID);
		CommUtils.toObjectJSON(deleteResult);
	}

	public void saveCustomerInfo() throws IOException {
		// 实例化一个前台，表单提交对象�?

		CustomerResponse cR = new CustomerResponse();
		cR.setCustAddress(custAddress);
		cR.setCustBirthday(custBirthday);
		cR.setCustCardnumber(custCardnumber);
		cR.setCustDesc(custDesc);
		cR.setCustEmail(custEmail);
		cR.setCustName(custName);
		cR.setCustRegisterTime(custRegisterTime);
		cR.setCustSex(custSex);
		cR.setCustTel(custTel);
		cR.setCustVip(custVip);
		cR.setOrderIdStr(orderIdStr);
		boolean flag = customerService.saveOrdersResponse(cR);
		CommUtils.toObjectJSON(flag);
	}

	// 获取某个用户
	public void findCustomerById() throws IOException {
		// 用于保存待修改的对象引用�?
		CustomerResponse cR = customerService.getCustomerResponseById(fid);
		c = customerService.findCustomerByID(fid);
		CommUtils.toObjectJSON(cR);
	}

	// 更新用户�?
	public void updateCustomerInfo() throws IOException {
		c.setCustAddress(custAddress);
		c.setCustBirthday(custBirthday);
		c.setCustCardnumber(custCardnumber);
		c.setCustDesc(custDesc);
		c.setCustEmail(custEmail);
		c.setCustName(custName);
		c.setCustRegisterTime(custRegisterTime);
		c.setCustSex(custSex);
		c.setCustTel(custTel);
		c.setCustVip(custVip);
		boolean result = customerService.updateCustomer(c, orderIdStr);
		CommUtils.toObjectJSON(result);
	}

	public void test() throws IOException {
		String result = CommUtils.getRequest().getParameter("testStr");
		CommUtils.toObjectJSON(result);
	}
	*/
}
