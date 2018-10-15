package com.echallan.exception;

public class TxnException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TxnException(String message) {
        super(message);
    }

    public TxnException(String message, Throwable cause) {
        super(message, cause);
    }

}
