package kr.co.kyobo.exception;

public class RecordNotFoundException extends Exception {

	public RecordNotFoundException() {
		super("존재하지 않는 데이터");
	}

	public RecordNotFoundException(String message) {
		super("존재하지 않는 데이터 : "+message);
	}

}
