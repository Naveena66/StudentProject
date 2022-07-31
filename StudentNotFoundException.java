package sdbms;

public class StudentNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	StudentNotFoundException(String message) {
		this.message=message;
	}
	@Override
	public String getMessage() {
		return message;
	}

}
