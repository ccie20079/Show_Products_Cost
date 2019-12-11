package com.dukepu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "V_Products_C_And_Pic_Summary", catalog = "dukepu")
public class V_Products_C_And_Pic_Summary {
	//v_products_c_and_pic_summary
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String min_seq;
	@Column(length=50)
	private String product_Name;
	@Column(length=50)
	private String total_man_hours;
	@Column(length=50)
    private String total_labour_cost;
	@Column(length=50)
    private String supplier;
	@Column(length=50)
    private String latest_update_time;
	@Column(length=50)
    private String picture_name;
    
	public String getPicture_name() {
		return picture_name;
	}
	public void setPicture_name(String picture_name) {
		this.picture_name = picture_name;
	}
	public String getMin_seq() {
		return min_seq;
	}
	public void setMin_seq(String min_seq) {
		this.min_seq = min_seq;
	}
	public String getProduct_Name() {
		return product_Name;
	}
	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
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
