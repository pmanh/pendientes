package pmh.utils;

import java.util.List;

public class GenericResult<E> {
	private String code;
	private String action;
	private String message;
	private Integer total;
	private Boolean success;
	private List<E> data;

	public GenericResult(List<E> data, Integer total) {
		this.data = data;
		this.total = total;
	}

	public GenericResult(List<E> data, Integer total, String action) {
		this.data = data;
		this.total = total;
		this.action = action;
	}

	public GenericResult(List<E> data, Integer total, String code, String message, Boolean success) {
		this.data = data;
		this.total = total;
		this.code = code;
		this.message = message;
		this.success = success;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<E> getData() {
		return data;
	}

	public void setData(List<E> data) {
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

}
