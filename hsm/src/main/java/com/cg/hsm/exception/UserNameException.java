package com.cg.hsm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserNameException extends RuntimeException
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public UserNameException()
    {
    	super();
    }
    public UserNameException(String errMsg)
    {
    	super(errMsg);
    }
}
