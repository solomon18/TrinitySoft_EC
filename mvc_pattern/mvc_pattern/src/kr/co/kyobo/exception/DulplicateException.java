package kr.co.kyobo.exception;

public class DulplicateException extends Exception {

	public DulplicateException() {
		super("존재하는 데이터");
	}

	public DulplicateException(String message) {
		super("존재하는 데이터 : "+message);
	}
	
}
