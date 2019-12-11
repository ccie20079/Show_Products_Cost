package com.dukepu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "V_Products_Cost_Summary", catalog = "dukepu")
public class V_Products_Cost_Summary {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String min_seq;
	@Column(length = 50)
	private String product_name; 
	@Column(length = 50)
	private String total_man_hours; 
	@Column(length = 50)
	private String total_labour_cost; 
	@Column(length = 50)
	private String supplier; 
	@Column(length = 50)
	private String latest_update_time;

	public String getMin_seq() {
		return min_seq;
	}
	public void setMin_seq(String min_seq) {
		this.min_seq = min_seq;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getTotal_man_hours() {
		return total_man_hours;
	}
	public void setTotal_man_hours(String total_man_hours) {
		this.total_man_hours = total_man_hours;
	}
	public String getTotal_labour_cost() {
		return total_labour_cost;
	}
	public void setTotal_labour_cost(String total_labour_cost) {
		this.total_labour_cost = total_labour_cost;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getLatest_update_time() {
		return latest_update_time;
	}
	public void setLatest_update_time(String latest_update_time) {
		this.latest_update_time = latest_update_time;
	}
	
	
}
