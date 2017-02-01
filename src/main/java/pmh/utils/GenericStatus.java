package pmh.utils;

public class GenericStatus<T> {
	private int id;
	private String code;
	private T message;
	private Boolean success;

	public GenericStatus(int i, String code, T message, Boolean success) {
		super();
		this.id = i;
		this.code = code;
		this.message = message;
		this.success = success;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public T getMessage() {
		return message;
	}

	public void setMessage(T message) {
		this.message = message;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

}
