package com.briup.demo.utils;

/**
 * 自定义返回信息类型
 * @author Administrator
 * 
 */
public class Message<T> {
	
	/**
	 * 状态码
	 */
	private Integer status;
	
	/**
	 * 数据信息
	 */
	private String message;
	
	/**
	 * 数据类
	 */
	private T data;
	
	/**
	 * 时间
	 */
	private Long time;
	
	public Message() {
		super();
	}

	public Message(Integer status, String message, T data, Long time) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
		this.time = time;
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	
}
