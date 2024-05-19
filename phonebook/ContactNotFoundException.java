package Q2;

public class ContactNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public ContactNotFoundException() {
        super();
    }

    public ContactNotFoundException(String msg) {
        super(msg);
    }

}
