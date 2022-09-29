package com.altice.alticcisequence.exceptions;

public class InvalidAlticciSequenceIndexException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidAlticciSequenceIndexException() {
		super("The input value must be zero or a natural number.");	
	}
}
