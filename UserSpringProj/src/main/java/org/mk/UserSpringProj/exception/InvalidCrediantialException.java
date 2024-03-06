package org.mk.UserSpringProj.exception;

public class InvalidCrediantialException extends RuntimeException{
	@Override
	public String getMessage() {
		return "Invalid phone or email or id or password";
	}
}
