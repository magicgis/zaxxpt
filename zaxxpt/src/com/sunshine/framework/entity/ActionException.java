package com.sunshine.framework.entity;

public class ActionException extends Exception {

	private static final long serialVersionUID = 5797776185082675093L;

	public ActionException(){
		super();
	}
	
	public ActionException(String message) {
		super(message);
	}

	public ActionException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ActionException(Throwable cause) {
        super(cause);
    }
	
}
