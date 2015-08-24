package br.com.eleitoralweb.exceptions;

@SuppressWarnings("serial")
public class BusinessException extends RuntimeException {

	/**
	 * Construtor default
	 */
	public BusinessException() {
	}

	/**
	 * Construtor
	 * @param message
	 */
	public BusinessException(String message) {
		super(message);
	}

	/**
	 * Construtor
	 * @param cause
	 */
	public BusinessException(Throwable cause) {
		super(cause);
	}

	/**
	 * Construtor
	 * @param message
	 * @param cause
	 */
	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

}
