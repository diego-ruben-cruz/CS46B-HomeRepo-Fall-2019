package dna;

// A useful class to give good feedback for erroneous inputs.
public class RecordFormatException extends Exception {

	// Constructor that takes a message.
	public RecordFormatException(String message) {
		super(message);
	}

	// Method that returns the error message
	public String getMessage() {
		return super.getMessage();
	}

}