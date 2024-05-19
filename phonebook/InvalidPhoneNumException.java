package Q2;

public class InvalidPhoneNumException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidPhoneNumException() {
        super();
    }

    public InvalidPhoneNumException(String msg) {
        super(msg);
    }
}
