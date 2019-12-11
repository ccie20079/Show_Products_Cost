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

public class ProductsCostAction extends CommAction {
	private static final long serialVersionUID = 1L;
	
	
	
	
	
	
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
