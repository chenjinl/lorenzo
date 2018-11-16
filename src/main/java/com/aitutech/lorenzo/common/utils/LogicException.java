package com.aitutech.lorenzo.common.utils;

/**
 * @author cjl
 * 	自定义异常
 */
public class LogicException extends Exception{
	
	private static final long serialVersionUID = -9118426857322009044L;

	public LogicException() {
		super();
	}
	
	public LogicException(String message) {
		super(message);
	}
	
	public LogicException(Exception e) {
		super(e);
	}

	public LogicException(String message, Exception e) {
		super(message, e);
	}
}
