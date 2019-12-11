package com.dukepu.utils;

//反馈给前台的Message�?
public class Message {
	private boolean flag;
	private String content;

	public Message() {

	}

	public boolean getFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	// 追加信息�?
	public void appendContent(String addConent) {

		content = content == null ? addConent : content + "<br/>" + addConent;

	}

	// 将信息添加在前面�?
	public void headContent(String headContent) {

		content = content == null ? headContent : headContent + "<br/>"
				+ content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
